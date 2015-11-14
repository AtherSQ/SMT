package smt.pack.meteorology;

import com.google.common.collect.Lists;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = SMTMeteorology.MODID, name = SMTMeteorology.NAME, version = SMTMeteorology.VERSION, dependencies = "required-after:SMT|CORE", useMetadata = true)
public class SMTMeteorology {
	//-----------------------------------------------------------------------------------------------
	public static final String
	MODID = "SMT|METEOROLOGY",
	NAME = "SMT: Meteorology",
	TAG = "smt_meteorology",
	VERSION = "0.001";
	//-----------------------------------------------------------------------------------------------
	@Mod.Instance(MODID) public static SMTMeteorology instance;
	//-----------------------------------------------------------------------------------------------
	public static smt.pack.meteorology.config.Config config;
	public static smt.pack.meteorology.block.ListBlocks blocks;
	public static smt.pack.meteorology.item.ListItems items;
	//-----------------------------------------------------------------------------------------------
	public static final CreativeTabs tabMeteorology = new CreativeTabs("tabMeteorology") {
		@Override public net.minecraft.item.Item getTabIconItem() {return items.itemsMeteorology;}
	};
	//-----------------------------------------------------------------------------------------------
	@Mod.EventHandler
	public void preInit(cpw.mods.fml.common.event.FMLPreInitializationEvent event) {
		applyMetadata(event.getModMetadata());
		config.main(event.getModConfigurationDirectory());
		blocks.init();
		items.init();
	}
	//-----------------------------------------------------------------------------------------------
	public void applyMetadata(ModMetadata meta) {
		meta.url = "http://forum.mcmodding.ru/viewtopic.php?id=4";
		meta.authorList = Lists.newArrayList("timaxa007", "Dragon2488");
		meta.description = "SMT: Meteorology.";
		meta.logoFile = "/smt_meteorology_logo.png";
		meta.autogenerated = false;
	}
	//-----------------------------------------------------------------------------------------------
}