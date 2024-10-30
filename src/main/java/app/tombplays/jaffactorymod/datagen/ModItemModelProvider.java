package app.tombplays.jaffactorymod.datagen;

import app.tombplays.jaffactorymod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import app.tombplays.jaffactorymod.JaffactoryMod;
import app.tombplays.jaffactorymod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, JaffactoryMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ORANGE);
        simpleItem(ModItems.ORANGE_JUICE);

        simpleBlockItem(ModBlocks.ORANGE_PLANKS_DOOR);

        fenceItem(ModBlocks.ORANGE_PLANKS_FENCE, ModBlocks.ORANGE_PLANKS_BLOCK);
        buttonItem(ModBlocks.ORANGE_PLANKS_BUTTON, ModBlocks.ORANGE_PLANKS_BLOCK);

        // be warned we haven't added the other PLANKS BLOCKS
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        String texturePath = prepareTexturePath(item.getId().getPath());
        return withExistingParent(item.get().toString(), mcLoc("item/generated")).texture("layer0", texturePath);
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> block) {
        String texturePath = prepareTexturePath(block.getId().getPath());
        return withExistingParent(block.get().toString(), mcLoc("item/generated")).texture("layer0", texturePath);
    }

    private static String prepareTexturePath(String path) {
        String texturePath = "item/" + path;
        // Log the texture path
        System.out.println("Using texture path: " + texturePath);
        return texturePath;
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(block.get().toString(), mcLoc("block/fence_inventory"))
                .texture("texture", "block/" + block.getId().getPath());
    }
    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(block.get().toString(), mcLoc("block/button_inventory"))
                .texture("texture", "block/" + block.getId().getPath());
    }
    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(block.get().toString(), mcLoc("block/fence_inventory"))
                .texture("texture", "block/" + block.getId().getPath());
    }
}
