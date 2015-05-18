package timaxa007.pack.mining.block;

import timaxa007.pack.mining.tile.*;
import timaxa007.smt.util.UtilSMT;
import net.minecraft.block.Block;

public class ListBlock {

	public static boolean 
	ore_rock_ores_be, 
	ore_nether_ores_be, 
	ore_ender_ores_be, 
	cristals_be;

	public static Block 
	ore_rock_ores, 
	ore_nether_ores, 
	ore_ender_ores, 
	cristals;

	public static Class 
	te_ore_ores, 
	te_cristals;

	public static Block[] list_block;

	public static Class[] list_te;

	public static void preInit() {

		if (ore_rock_ores_be) ore_rock_ores = new OreOres("ore_rock_ores").setBlockTextureName("stone");
		if (ore_nether_ores_be) ore_nether_ores = new OreOres("ore_nether_ores").setBlockTextureName("netherrack");
		if (ore_ender_ores_be) ore_ender_ores = new OreOres("ore_ender_ores").setBlockTextureName("end_stone");
		if (ore_rock_ores_be || ore_nether_ores_be || ore_ender_ores_be) te_ore_ores = TileEntityOreOres.class;

		if (cristals_be) {
			cristals = new BlockCristals("cristals");
			te_cristals = TileEntityCristals.class;
		}

		list_block = new Block[] {
				ore_rock_ores, 
				ore_nether_ores, 
				ore_ender_ores, 
				cristals
		};

		UtilSMT.UtilBlock.RegBlock(list_block);

		list_te = new Class[] {
				te_ore_ores, 
				te_cristals
		};

		UtilSMT.UtilBlock.RegTE(list_te);

	}

}
