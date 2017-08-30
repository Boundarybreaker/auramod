package space.bbkr.aura;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Aura.modId, name = Aura.name, version = Aura.version)
public class Aura {

    public static final String modId = "aura";
    public static final String name = "Aura";
    public static final String version = "0.1";

    @Mod.Instance(modId)
    public static Aura instance;

    @SidedProxy(serverSide = "space.bbkr.aura.proxy.CommonProxy", clientSide = "space.bbkr.aura.proxy.ClientProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println(name + " is loading!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

}