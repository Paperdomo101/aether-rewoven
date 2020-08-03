package paperdomo101.aether_rewoven.block.sapling;

import java.util.Random;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import paperdomo101.aether_rewoven.world.gen.feature.AetherBiomeFeatures;

public class SkyrootSaplingGenerator extends SaplingGenerator {

    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> createTreeFeature(Random random, boolean bl) {
        return Feature.TREE.configure(AetherBiomeFeatures.SKYROOT_TREE_CONFIG);
    }
    
}