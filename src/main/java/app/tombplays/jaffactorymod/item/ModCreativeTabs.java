package app.tombplays.jaffactorymod.item;

import app.tombplays.jaffactorymod.JaffactoryMod;
import app.tombplays.jaffactorymod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JaffactoryMod.MODID);

    public static final RegistryObject<CreativeModeTab> JAFFACTORY_TAB = CREATIVE_MODE_TABS.register("jaffactory_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ORANGE.get()))
                    .title(Component.translatable("creativetab.jaffactory_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ORANGE.get());
                        output.accept(ModItems.ORANGE_JUICE.get());

                        output.accept(ModBlocks.ORANGE_BLOCK.get());
                        output.accept(ModBlocks.ORANGE_LOG_BLOCK.get());

                        output.accept(ModBlocks.ORANGE_PLANKS_BLOCK.get());
                        output.accept(ModBlocks.ORANGE_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.ORANGE_PLANKS_SLAB.get());
                        output.accept(ModBlocks.ORANGE_PLANKS_BUTTON.get());
                        output.accept(ModBlocks.ORANGE_PLANKS_PRESSURE_PLATE.get());

                        output.accept(ModBlocks.ORANGE_PLANKS_FENCE.get());
                        output.accept(ModBlocks.ORANGE_PLANKS_FENCE_GATE.get());

                        output.accept(ModBlocks.ORANGE_PLANKS_DOOR.get());
                        output.accept(ModBlocks.ORANGE_PLANKS_TRAPDOOR.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
