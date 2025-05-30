package app.tombplays.jaffactory;

import app.tombplays.jaffactory.block.ModBlocks;
import app.tombplays.jaffactory.fluid.ModFluids;
import app.tombplays.jaffactory.fluid.ModFluidTypes;
import app.tombplays.jaffactory.worldgen.feature.JaffaTreeFeatures;
import app.tombplays.jaffactory.worldgen.feature.placement.JaffaFoliagePlacers;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Sheets;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import app.tombplays.jaffactory.item.ModCreativeTabs;
import app.tombplays.jaffactory.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(JaffactoryMod.MOD_ID)
public class JaffactoryMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "jaffactory";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public JaffactoryMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the items
        ModItems.register(modEventBus);

        // Register the blocks
        ModBlocks.register(modEventBus);

        // Register fluids
        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);

        // Register the CreativeTab
        ModCreativeTabs.register(modEventBus);

        // Register the FoliagePlacers
        JaffaFoliagePlacers.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        //context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }


    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code

    }

    // Add the items to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

            ItemBlockRenderTypes.setRenderLayer(ModFluids.ORANGE_JUICE_SOURCE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.ORANGE_JUICE_FLOWING.get(), RenderType.translucent());
        }
    }
}
