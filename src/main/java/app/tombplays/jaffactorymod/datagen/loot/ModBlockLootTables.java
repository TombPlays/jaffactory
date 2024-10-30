package app.tombplays.jaffactorymod.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import app.tombplays.jaffactorymod.block.ModBlocks;

import java.util.Collections;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.ORANGE_BLOCK.get());
        this.dropSelf(ModBlocks.ORANGE_LOG_BLOCK.get());
        this.dropSelf(ModBlocks.ORANGE_PLANKS_BLOCK.get());

        this.dropSelf(ModBlocks.ORANGE_PLANKS_STAIRS.get());
        this.dropSelf(ModBlocks.ORANGE_PLANKS_BUTTON.get());
        this.dropSelf(ModBlocks.ORANGE_PLANKS_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ORANGE_PLANKS_TRAPDOOR.get());
        this.dropSelf(ModBlocks.ORANGE_PLANKS_FENCE.get());
        this.dropSelf(ModBlocks.ORANGE_PLANKS_FENCE_GATE.get());

        this.add(ModBlocks.ORANGE_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ORANGE_PLANKS_SLAB.get()));
        this.add(ModBlocks.ORANGE_PLANKS_DOOR.get(),
                block -> createDoorTable(ModBlocks.ORANGE_PLANKS_DOOR.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
