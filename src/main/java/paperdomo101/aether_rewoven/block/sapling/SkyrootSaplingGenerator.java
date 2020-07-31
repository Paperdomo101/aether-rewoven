package paperdomo101.aether_rewoven.block.sapling;

import java.util.Random;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class SkyrootSaplingGenerator extends SaplingGenerator {

    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> createTreeFeature(Random random, boolean bl) {
        return random.nextInt(10) == 0 ? Feature.TREE.configure(bl ? DefaultBiomeFeatures.FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG : DefaultBiomeFeatures.FANCY_TREE_CONFIG) : Feature.TREE.configure(bl ? DefaultBiomeFeatures.OAK_TREE_WITH_MORE_BEEHIVES_CONFIG : DefaultBiomeFeatures.OAK_TREE_CONFIG);
    }
    
}