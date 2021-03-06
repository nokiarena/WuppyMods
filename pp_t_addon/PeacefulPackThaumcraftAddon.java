package pp_t_addon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = PeacefulPackThaumcraftAddon.modid, name = "PeacefulPack Thaumcraft addon", version = "1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class PeacefulPackThaumcraftAddon
{
	public static final String modid = "wuppy29_peacefulpackthaumcraftaddon";
	
	public static int GraveID;
	
	public static Block grave;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		GraveID = config.getBlock("Grave ID", Configuration.CATEGORY_BLOCK, 320).getInt();
		config.save();
	}
	
	@EventHandler
    public void load(FMLInitializationEvent event)
    {
		grave = new BlockGrave(GraveID, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setUnlocalizedName("grave");
		MinecraftForge.setBlockHarvestLevel(grave, "pickaxe", 1);
		
		GameRegistry.registerBlock(grave, "Grave");
		
		LanguageRegistry.addName(grave, "Grave");
		
		GameRegistry.registerWorldGenerator(new PeacefulThaumGenerater());
    }
}
