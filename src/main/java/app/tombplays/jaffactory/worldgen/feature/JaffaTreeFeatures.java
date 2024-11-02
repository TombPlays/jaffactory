package app.tombplays.jaffactory.worldgen.feature;

import app.tombplays.jaffactory.JaffactoryMod;
import app.tombplays.jaffactory.block.ModBlocks;
import com.mojang.serialization.Lifecycle;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class JaffaTreeFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> JAFFA_TREE_KEY = registerKey("jaffa_tree");
    //public static final ResourceKey<ConfiguredFeature<?, ?>> JAFFA_TREE_BEES = registerKey("jaffa_tree_bees");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        register(context, JAFFA_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.ORANGE_LOG.get()),
                new StraightTrunkPlacer(5 , 4 ,3),

                BlockStateProvider.simple(ModBlocks.ORANGE_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),

                new TwoLayersFeatureSize(1, 0 ,2)).build());
                //altFoliage(BlockStateProvider.simple(ModBlocks.ORANGE_FRUIT_LEAVES.get())).build());

        //register(context, JAFFA_TREE_BEES, Feature.TREE, new TreeCo.Builder().trunk(BlockStateProvider.simple(ModBlocks.ORANGE_LOG.get())).foliage(BlockStateProvider.simple(ModBlocks.ORANGE_LEAVES.get())).altFoliage(BlockStateProvider.simple(ModBlocks.ORANGE_FRUIT_LEAVES.get())).decorator(new BeehiveDecorator(0.05f)).build());

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(JaffactoryMod.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, F feature, FC configuration)
    {
        context.register(configuredFeatureKey, new ConfiguredFeature<>(feature, configuration), Lifecycle.stable());
    }
}
