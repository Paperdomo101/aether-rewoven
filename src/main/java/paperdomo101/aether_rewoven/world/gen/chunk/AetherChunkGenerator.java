package paperdomo101.aether_rewoven.world.gen.chunk;

import java.util.Collections;
import java.util.Optional;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.block.BlockState;
import net.minecraft.world.BlockView;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.Heightmap;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.StructuresConfig;
import net.minecraft.world.gen.chunk.VerticalBlockSample;

public class AetherChunkGenerator extends ChunkGenerator {

	public static final Codec<AetherChunkGenerator> CODEC = RecordCodecBuilder.create((
		instance) -> instance.group(BiomeSource.field_24713.fieldOf("biome_source").forGetter(
		(generator) -> generator.biomeSource)).apply(instance, instance.stable(AetherChunkGenerator::new))
	);

	public AetherChunkGenerator(BiomeSource biomeSource) {
		super(biomeSource, new StructuresConfig(Optional.empty(), Collections.emptyMap()));
	}

	@Override
	protected Codec<? extends ChunkGenerator> method_28506() {
		return CODEC;
	}

	@Override
	public ChunkGenerator withSeed(long seed) {
		return this;
	}

	@Override
	public void buildSurface(ChunkRegion region, Chunk chunk) {
        
	}

	@Override
	public void populateNoise(WorldAccess world, StructureAccessor accessor, Chunk chunk) {
		
	}

	@Override
	public void addStructureReferences(WorldAccess world, StructureAccessor accessor, Chunk chunk) {

	}

	@Override
	public int getHeight(int x, int z, Heightmap.Type heightmapType) {
		return 0;
	}

	@Override
	public BlockView getColumnSample(int x, int z) {
		return new VerticalBlockSample(new BlockState[0]);
	}
}