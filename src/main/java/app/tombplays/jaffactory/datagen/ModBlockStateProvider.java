package app.tombplays.jaffactory.datagen;

import app.tombplays.jaffactory.JaffactoryMod;
import app.tombplays.jaffactory.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, JaffactoryMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockBarrelWithItem(ModBlocks.ORANGE_BLOCK);

//        blockTubeWithItem(ModBlocks.ORANGE_LOG_BLOCK);

        blockWithItem(ModBlocks.ORANGE_PLANKS_BLOCK);

        stairsBlock(        ModBlocks.ORANGE_PLANKS_STAIRS.get(), blockTexture(ModBlocks.ORANGE_PLANKS_BLOCK.get()));
        slabBlock(          ModBlocks.ORANGE_PLANKS_SLAB.get(), blockTexture(ModBlocks.ORANGE_PLANKS_BLOCK.get()), blockTexture(ModBlocks.ORANGE_PLANKS_BLOCK.get()));

        buttonBlock(        ModBlocks.ORANGE_PLANKS_BUTTON.get(), blockTexture(ModBlocks.ORANGE_PLANKS_BLOCK.get()));
        pressurePlateBlock( ModBlocks.ORANGE_PLANKS_PRESSURE_PLATE.get(), blockTexture(ModBlocks.ORANGE_PLANKS_BLOCK.get()));

        fenceBlock(         ModBlocks.ORANGE_PLANKS_FENCE.get(), blockTexture(ModBlocks.ORANGE_PLANKS_BLOCK.get()));
        fenceGateBlock(     ModBlocks.ORANGE_PLANKS_FENCE_GATE.get(), blockTexture(ModBlocks.ORANGE_PLANKS_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.ORANGE_PLANKS_DOOR.get(), modLoc("block/orange_planks_door_bottom"), modLoc("block/orange_planks_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.ORANGE_PLANKS_TRAPDOOR.get(), modLoc("block/orange_planks_trapdoor"), true, "cutout");
    }


    private void blockBarrelWithItem(RegistryObject<Block> blockRegistryObject) {
        ResourceLocation sideTexture = modLoc("block/" + blockRegistryObject.getId().getPath() + "_side");
        ResourceLocation bottomTexture = modLoc("block/" + blockRegistryObject.getId().getPath() + "_bottom");
        ResourceLocation topTexture = modLoc("block/" + blockRegistryObject.getId().getPath() + "_top");

        ModelFile barrelModel = modelBarrel(sideTexture, bottomTexture, topTexture);

        simpleBlockWithItem(blockRegistryObject.get(), barrelModel);
    }

    private void blockTubeWithItem(RegistryObject<Block> blockRegistryObject) {
        ResourceLocation sideTexture = modLoc("block/" + blockRegistryObject.getId().getPath() + "_side");
        ResourceLocation topTexture = modLoc("block/" + blockRegistryObject.getId().getPath() + "_top");

        ModelFile tubeModel = modelTube(sideTexture, topTexture);

        simpleBlockWithItem(blockRegistryObject.get(), tubeModel);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {

        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private ModelFile modelBarrel(ResourceLocation sideTexture, ResourceLocation bottomTexture, ResourceLocation topTexture) {
        return models().cubeBottomTop("barrel", sideTexture, bottomTexture, topTexture);
    }

    private ModelFile modelTube(ResourceLocation sideTexture, ResourceLocation topTexture) {
        return models().cubeColumn("tube", sideTexture, topTexture);
    }

}