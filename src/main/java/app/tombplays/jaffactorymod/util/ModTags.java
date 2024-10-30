package app.tombplays.jaffactorymod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import app.tombplays.jaffactorymod.JaffactoryMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> JAFFACTORY_FRUIT = tag("jaffactory_fruit");
        public static final TagKey<Block> ORANGE_BLOCK = tag("orange_block");
        public static final TagKey<Block> ORANGE_LOG_BLOCK = tag("orange_log_block");
        public static final TagKey<Block> ORANGE_PLANKS_BLOCK = tag("orange_planks_block");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(JaffactoryMod.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> JAFFACTORY_FRUIT = tag("jaffactory_fruit");
        public static final TagKey<Item> ORANGE = tag("orange");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(JaffactoryMod.MODID, name));
        }
    }
}
