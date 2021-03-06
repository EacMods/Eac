package Eac.block.OreGeneration;

import Eac.block.BlockEac;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class WorldGenEac implements IWorldGenerator {

    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case -1:
                generateNether(world, rand, chunkX * 16, chunkZ * 16);
            case 0:
                generateSurface(world, rand, chunkX * 16, chunkZ * 16);
        }
    }

    private void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
        for (int i = 0; i < 2; i++) {
            int randPosX = chunkX + rand.nextInt(16);
            int randPosY = rand.nextInt(16);
            int randPosZ = chunkZ + rand.nextInt(16);

            (new WorldGenMinable(BlockEac.oreAir, 7)).generate(world, rand, randPosX, randPosY, randPosZ);
        }
    }

    private void generateNether(World world, Random rand, int chunkX, int chunkZ) {
        for (int i = 0; i < 8; i++) {
            int randPosX = chunkX + rand.nextInt(16);
            int randPosY = rand.nextInt(128);
            int randPosZ = chunkZ + rand.nextInt(16);

            (new NetherGenEac(BlockEac.oreShadow, 4)).generate(world, rand, randPosX, randPosY, randPosZ);
        }
    }

}
