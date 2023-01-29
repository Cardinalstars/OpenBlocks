package openblocks.common;

import net.minecraft.util.IIcon;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;

import openblocks.IOpenBlocksProxy;

public class ServerProxy implements IOpenBlocksProxy {

    @Override
    public void preInit() {}

    @Override
    public void init() {}

    @Override
    public void postInit() {}

    @Override
    public void registerRenderInformation() {}

    @Override
    public void spawnLiquidSpray(World worldObj, Fluid fluid, double x, double y, double z, float scale, float gravity,
            Vec3 velocity) {}

    @Override
    public void spawnParticleSpray(World worldObj, IIcon icon, double x, double y, double z, float scale, float gravity,
            Vec3 velocity) {}

    @Override
    public int getParticleSettings() {
        return 3; // really no particles
    }

}
