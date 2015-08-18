package timaxa007.pack.conjoint;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.api.IProxyPackCommon;
import timaxa007.pack.conjoint.event.EventItemStorage;
import timaxa007.pack.conjoint.event.EventPackConjoints;
import timaxa007.pack.conjoint.event.EventUpdate;
import timaxa007.pack.conjoint.event.EventWorldBlockData;
import timaxa007.pack.conjoint.render.RenderMain;
import cpw.mods.fml.common.FMLCommonHandler;

public class ProxyCommon implements IProxyPackCommon {

	@Override
	public void preInit() {

		RenderMain.preInit();

	}

	@Override
	public void init() {

		FMLCommonHandler.instance().bus().register(new EventItemStorage());
		MinecraftForge.EVENT_BUS.register(new EventPackConjoints());
		MinecraftForge.EVENT_BUS.register(new EventWorldBlockData());
		FMLCommonHandler.instance().bus().register(new EventUpdate());

	}

	@Override
	public void postInit() {

	}

}
