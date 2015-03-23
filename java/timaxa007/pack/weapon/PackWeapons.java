package timaxa007.pack.weapon;

import timaxa007.pack.weapon.packet.RegisterMessage;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod (modid = PackWeapons.MODID, name = PackWeapons.MODNAME, version = PackWeapons.VERSION, dependencies = "required-after:timaxa007")

public class PackWeapons {

	public static final String MODID = "weaponpack";
	public static final String MODNAME = "PackWeapon";
	public static final String VERSION = "0.1a";
	public static final String[] AUTHORS = new String[] {"timaxa007"};

	@Instance(PackWeapons.MODID) public static PackWeapons instance;
	@SidedProxy(modId = PackWeapons.MODID, clientSide = "timaxa007.pack.weapon.ProxyClient", serverSide = "timaxa007.pack.weapon.ProxyCommon")
	public static ProxyCommon proxy;
	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static CreativeTabs tab_weapons = new CreativeTabs("tab_weapons") {
		public Item getTabIconItem() {
			return PackWeapons.proxy.item.items_for_weapons;
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting sub-mod " + PackWeapons.MODNAME + ".");

		network = NetworkRegistry.INSTANCE.newSimpleChannel(PackWeapons.MODID);
		RegisterMessage.init(network);

		proxy.preInit(event);

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
	}

}