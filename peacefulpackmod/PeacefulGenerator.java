package peacefulpackmod;

import java.util.Random;

import peacefulpackmod.worldgen.PeacefulNetherGenMinable;
import peacefulpackmod.worldgen.WorldGenBlazeTrees;
import peacefulpackmod.worldgen.WorldGenEnderclam;
import peacefulpackmod.worldgen.WorldGenFlax;
import peacefulpackmod.worldgen.WorldGenMinableFossil;
import peacefulpackmod.worldgen.WorldGenMinablePeaceful;
import peacefulpackmod.worldgen.WorldGenMinablePeacefulDirt;
import peacefulpackmod.worldgen.WorldGenRemains;
import peacefulpackmod.worldgen.WorldGenRottenplant;
import peacefulpackmod.worldgen.WorldGenSlimepool;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class PeacefulGenerator implements IWorldGenerator 
{
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.dimensionId)
		{
			case -1: generateNether(world, random, chunkX*16, chunkZ*16);
			case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
		}
	}

	public static void generateSurface(World world, Random random, int blockX, int blockZ)
	{
		int Xcoord = blockX + random.nextInt(16);
		int Ycoord = random.nextInt(60);
		int Zcoord = blockZ + random.nextInt(16);
		new WorldGenMinablePeaceful(PeacefulPack.oreblock.blockID, 0, 10).generate(world, random, Xcoord, Ycoord, Zcoord);
		
		int Xcoord1 = blockX + random.nextInt(16);
		int Ycoord1 = random.nextInt(60);
		int Zcoord1 = blockZ + random.nextInt(16);
		new WorldGenMinablePeaceful(PeacefulPack.oreblock.blockID, 1,  10).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
		
		int Xcoord2 = blockX + random.nextInt(16);
		int Ycoord2 = random.nextInt(60);
		int Zcoord2 = blockZ + random.nextInt(16);
		new WorldGenMinableFossil(PeacefulPack.oreblock.blockID, 2, 15).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
		
		int Xcoord3 = blockX + random.nextInt(16);
		int Ycoord3 = random.nextInt(80);
		int Zcoord3 = blockZ + random.nextInt(16);
		new WorldGenFlax().generate(world, random, Xcoord3, Ycoord3, Zcoord3);
		
		int Xcoord5 = blockX + random.nextInt(16);
		int Ycoord5 = random.nextInt(45);
		int Zcoord5 = blockZ + random.nextInt(16);
		new WorldGenSlimepool().generate(world, random, Xcoord5, Ycoord5, Zcoord5);
		
		int Xcoord7 = blockX + random.nextInt(16);
		int Ycoord7 = random.nextInt(70);
		int Zcoord7 = blockZ + random.nextInt(16);
		new WorldGenEnderclam(PeacefulPack.enderclam.blockID).generate(world, random, Xcoord7, Ycoord7, Zcoord7);
		
		if(random.nextInt(2) == 0)
		{
			int Xcoord8 = blockX + random.nextInt(16);
			int Ycoord8 = 55 + random.nextInt(30);
			int Zcoord8 = blockZ + random.nextInt(16);
			new WorldGenRemains().generate(world, random, Xcoord8, Ycoord8, Zcoord8);
		}
		System.out.println("generated: " + blockX + " " + blockZ);
	}

	public static void generateNether(World world, Random random, int blockX, int blockZ)
	{
		int Xcoord4 = blockX + random.nextInt(16);
		int Ycoord4 = random.nextInt(120);
		int Zcoord4 = blockZ + random.nextInt(16);
		new WorldGenRottenplant().generate(world, random, Xcoord4, Ycoord4, Zcoord4);
		
        int Xcoord8 = blockX + random.nextInt(16); 
        int Ycoord8 = random.nextInt(120);
        int Zcoord8 = blockZ + random.nextInt(16); 
        (new WorldGenBlazeTrees()).generate(world, random, Xcoord8, Ycoord8, Zcoord8);
		
		int Xcoord9 = blockX + random.nextInt(16);
		int Ycoord9 = random.nextInt(128);
		int Zcoord9 = blockZ + random.nextInt(16);
		(new PeacefulNetherGenMinable(PeacefulPack.ghastore.blockID, 15)).generate(world, random, Xcoord9, Ycoord9, Zcoord9);
	}
}