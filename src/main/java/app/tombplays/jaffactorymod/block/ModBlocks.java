package app.tombplays.jaffactorymod.block;

import app.tombplays.jaffactorymod.JaffactoryMod;
import app.tombplays.jaffactorymod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, JaffactoryMod.MODID);

    /* Register the Blocks START */
    public static final RegistryObject<Block> ORANGE_BLOCK = registerBlock("orange_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COMPOSTER)));
    public static final RegistryObject<Block> ORANGE_LOG_BLOCK = registerBlock("orange_log_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> ORANGE_PLANKS_BLOCK = registerBlock("orange_planks_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    /* Register the Blocks END */

    /* Register the Decorations START */
    public static final RegistryObject<Block> ORANGE_PLANKS_STAIRS = registerBlock("orange_planks_stairs",
            () -> new StairBlock( ModBlocks.ORANGE_PLANKS_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> ORANGE_PLANKS_SLAB = registerBlock("orange_planks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> ORANGE_PLANKS_BUTTON = registerBlock("orange_planks_button",
            () -> new ButtonBlock(BlockSetType.OAK, 20, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));
    public static final RegistryObject<Block> ORANGE_PLANKS_PRESSURE_PLATE = registerBlock("orange_planks_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));

    public static final RegistryObject<Block> ORANGE_PLANKS_FENCE = registerBlock("orange_planks_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> ORANGE_PLANKS_FENCE_GATE = registerBlock("orange_planks_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));

    public static final RegistryObject<Block> ORANGE_PLANKS_DOOR = registerBlock("orange_planks_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
    public static final RegistryObject<Block> ORANGE_PLANKS_TRAPDOOR = registerBlock("orange_planks_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));
    /* Register the Decorations END */

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }


}
