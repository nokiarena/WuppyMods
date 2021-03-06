package goblinsgiants.dimension.savannah;

import goblinsgiants.GoblinGiant;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.ModLoader;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderGoblinsGiantsSavannah extends WorldProvider
{
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(GoblinGiant.savannah, 0.8F, 0.1F);
		this.dimensionId = GoblinGiant.dimension;
	}

	public String getSaveFolder()
	{
		return "DIM-G&G";
	}

	public String getWelcomeMessage()
	{
		return "Entering The Savannah";
	}

	public String getDepartMessage()
	{
		return "Leaving The Savannah";
	}

	public boolean canRespawnHere()
	{
		return true;
	}

	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderSavannah(worldObj, worldObj.getSeed(), true);
	}

	public String getDimensionName()
	{
		return "Savannah";
	}

	/**
	* Gets the hard-coded portal location to use when entering this dimension.
	*/
	public ChunkCoordinates getEntrancePortalLocation()
	{
		return null;
	}

	public boolean canDoLightning(Chunk chunk)
	{
		return true;
	}

	public boolean canDoRainSnowIce(Chunk chunk)
	{
		return false;
	}
}
