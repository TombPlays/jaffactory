package app.tombplays.jaffactorymod.datagen;

import app.tombplays.jaffactorymod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import app.tombplays.jaffactorymod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.ORANGE_JUICE.get(), 1)
                .requires(ModItems.ORANGE.get())
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy(getHasName(ModItems.ORANGE.get()), has(ModItems.ORANGE.get()))
                .save(pRecipeOutput);

        /* Get Items from a Block - Category, Item, Block, Count, pRecipeOutput */
        ShapelessGetFromGiveRecipe(RecipeCategory.FOOD, ModItems.ORANGE.get(), ModBlocks.ORANGE_BLOCK.get(), 9, pRecipeOutput);
        ShapelessGetFromGiveRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORANGE_PLANKS_BLOCK.get(), ModBlocks.ORANGE_LOG_BLOCK.get(), 4, pRecipeOutput);

        /* Get Block from 9 Items in a square - Category, Block, Item, pRecipeOutput */
        ShapedBlockRecipe(RecipeCategory.DECORATIONS, ModBlocks.ORANGE_BLOCK.get(), ModItems.ORANGE.get(), pRecipeOutput);


    }

    private <P> void ShapelessGetFromGiveRecipe(RecipeCategory recipeCategory, P get, P give, int count, RecipeOutput pRecipeOutput) {
        ShapelessRecipeBuilder.shapeless(recipeCategory, (ItemLike) get, count)
                .requires((ItemLike) give)
                .unlockedBy(getHasName((ItemLike) give), has((ItemLike) give))
                .save(pRecipeOutput);
    }

    private void ShapedBlockRecipe(RecipeCategory recipeCategory, Block recipeBlock, Item recipeItem, RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(recipeCategory, recipeBlock, 1)
                .pattern("ooo")
                .pattern("ooo")
                .pattern("ooo")
                .define('o', recipeItem)
                .unlockedBy(getHasName(recipeItem), has(recipeItem))
                .save(recipeOutput);
    }
}
