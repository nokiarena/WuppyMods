package goblinsgiants.dimension.savannah;

import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureStart;

public class MapGenMineshaftSavannah extends MapGenStructure
{
    protected boolean canSpawnStructureAtCoords(int par1, int par2)
    {
        return this.rand.nextInt(100) == 0 && this.rand.nextInt(80) < Math.max(Math.abs(par1), Math.abs(par2));
    }

    protected StructureStart getStructureStart(int par1, int par2)
    {
        return new StructureMineshaftStartSavannah(this.worldObj, this.rand, par1, par2);
    }
}
