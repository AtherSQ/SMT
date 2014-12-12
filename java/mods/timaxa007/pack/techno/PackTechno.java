package mods.timaxa007.pack.techno;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod (modid = PackTechno.MODID, name = PackTechno.MODNAME, version = PackTechno.VERSION, dependencies = "required-after:03furniturepack")
//@NetworkMod (clientSideRequired = true, serverSideRequired = false, versionBounds = PackInfo.VERSION)
//@NetworkMod (channels = PackInfo.MODID, clientSideRequired = true, serverSideRequired = true, versionBounds = "1.0.0")

public class PackTechno {

public static final String MODID = "04technopack";
public static final String MODNAME = "TechnoPack";
public static final String VERSION = "0.1a";
public static final String AUTHOR = "timaxa007";

@Instance(PackTechno.MODID) public static PackTechno instance;
@SidedProxy(clientSide = "mods.timaxa007.pack.techno.ProxyClient", serverSide = "mods.timaxa007.pack.techno.ProxyServer")
public static ProxyServer proxy;

@EventHandler
public void init(FMLInitializationEvent event) {
proxy.init();
}

@EventHandler
public void preInit(FMLPreInitializationEvent event) {
proxy.preInit(event);
}

}