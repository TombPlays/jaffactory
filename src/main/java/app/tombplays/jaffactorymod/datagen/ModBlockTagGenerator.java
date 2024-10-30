package app.tombplays.jaffactorymod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import app.tombplays.jaffactorymod.JaffactoryMod;
import app.tombplays.jaffactorymod.block.ModBlocks;
import app.tombplays.jaffactorymod.util.ModTags;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, JaffactoryMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.JAFFACTORY_FRUIT)
                .add(ModBlocks.ORANGE_BLOCK.get()
                )
                .addTag(Tags.Blocks.STORAGE_BLOCKS);
        this.tag(ModTags.Blocks.ORANGE_PLANKS_BLOCK)
                .add(ModBlocks.ORANGE_PLANKS_BLOCK.get()
                )
                .addTag(BlockTags.PLANKS);
        this.tag(ModTags.Blocks.ORANGE_LOG_BLOCK)
                .add(ModBlocks.ORANGE_LOG_BLOCK.get()
                )
                .addTag(BlockTags.LOGS);

        this.tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.ORANGE_PLANKS_FENCE.get());
        this.tag(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.ORANGE_PLANKS_DOOR.get());
        this.tag(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.ORANGE_PLANKS_BUTTON.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.ORANGE_PLANKS_TRAPDOOR.get());
        this.tag(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.ORANGE_PLANKS_SLAB.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.ORANGE_PLANKS_PRESSURE_PLATE.get());
        this.tag(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.ORANGE_PLANKS_STAIRS.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.ORANGE_PLANKS_FENCE_GATE.get());
    }
}
