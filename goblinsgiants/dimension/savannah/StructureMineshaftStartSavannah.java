package goblinsgiants.dimension.savannah;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class StructureMineshaftStartSavannah extends StructureStart
{
    public StructureMineshaftStartSavannah(World par1World, Random par2Random, int par3, int par4)
    {
        ComponentMineshaftRoomSavannah var5 = new ComponentMineshaftRoomSavannah(0, par2Random, (par3 << 4) + 2, (par4 << 4) + 2);
        this.components.add(var5);
        var5.buildComponent(var5, this.components, par2Random);
        this.updateBoundingBox();
        this.markAvailableHeight(par1World, par2Random, 10);
    }
}
