package app.tombplays.jaffactory.worldgen.feature.tree;

import app.tombplays.jaffactory.worldgen.feature.configurations.JAFTreeConfiguration;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;

import java.util.Collection;
import java.util.function.BiConsumer;

public class JAFTreeFeature<FC extends JAFTreeConfiguration> extends TreeFeature {
    protected JAFTreeFeature(Codec<FC> codec)
    {
        super((Codec)codec);
    }

    public boolean placeLeaves(LevelAccessor level, BlockPos pos, FoliagePlacer.FoliageSetter leaves, FC config)
    {
        if (canReplace(level, pos))
        {
            leaves.set(pos, config.foliageProvider.getState(level.getRandom(), pos));
            return true;
        }
        return false;
    }

    public boolean placeAltLeaves(LevelAccessor level, BlockPos pos, FoliagePlacer.FoliageSetter leaves, FC config)
    {
        if (canReplace(level, pos))
        {
            leaves.set(pos, config.altFoliageProvider.getState(level.getRandom(), pos));
            return true;
        }
        return false;
    }

    public boolean placeLog(LevelAccessor world, BlockPos pos, BiConsumer<BlockPos, BlockState> logs, FC config)
    {
        return this.placeLog(world, pos, null, logs, config);
    }

    public boolean placeLog(LevelAccessor level, BlockPos pos, Direction.Axis axis, BiConsumer<BlockPos, BlockState> logs, FC config)
    {
        Property logAxisProperty = this.getLogAxisProperty(level, pos, config);
        BlockState log = config.trunkProvider.getState(level.getRandom(), pos);
        BlockState directedLog = (axis != null && logAxisProperty != null) ? log.setValue(logAxisProperty, axis) : log;

        if (canReplace(level, pos))
        {
            // Logs must be added to the "changedBlocks" so that the leaves have their distance property updated,
            // preventing incorrect decay
            logs.accept(pos, directedLog);
            return true;
        }
        return false;
    }


    protected boolean canReplace(LevelAccessor level, BlockPos pos)
    {
        return TreeFeature.isAirOrLeaves(level, pos) || level.isStateAtPosition(pos, (state) -> {
            Block block = state.getBlock();
            return state.is(BlockTags.REPLACEABLE_BY_TREES) || state.is(BlockTags.SAPLINGS) || block == Blocks.VINE ||  block == Blocks.MOSS_CARPET  || block instanceof BushBlock;
        });
    }

    protected Property getLogAxisProperty(LevelAccessor level, BlockPos pos, FC config)
    {
        BlockState log = config.trunkProvider.getState(level.getRandom(), pos);

        for (Property property : log.getProperties())
        {
            Collection allowedValues = property.getPossibleValues();
            if (allowedValues.contains(Direction.Axis.X) && allowedValues.contains(Direction.Axis.Y) && allowedValues.contains(Direction.Axis.Z))
            {
                return property;
            }
        }
        return null;
    }

    public static boolean isFree(LevelSimulatedReader level, BlockPos pos)
    {
        return validTreePos(level, pos) || level.isStateAtPosition(pos, (state) -> {
            return state.is(BlockTags.LOGS);
        });
    }
}
