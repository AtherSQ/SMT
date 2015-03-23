package timaxa007.pack.magic.block;

import timaxa007.pack.magic.tile.*;
import timaxa007.tms.util.UtilTMS;
import net.minecraft.block.Block;

public class ListBlock {

	public static boolean 
	magic_machines_be,
	magic_slims_be,
	magic_cauldron_be,
	magic_locked_be;

	public static Block 
	magic_machines,
	magic_slims,
	magic_cauldron,
	magic_locked;

	public static Class 
	te_magic_machines,
	te_magic_slims,
	te_magic_cauldron,
	te_magic_locked;

	public static Block[] list_block;

	public static Class[] list_te;

	public static void preInit() {

		if (magic_machines_be) {
			magic_machines = new BlockMagicMachines("magic_machines");
			te_magic_machines = TileEntityMagicMachines.class;
		}

		if (magic_slims_be) {
			magic_slims = new BlockSlims("magic_slims");
			te_magic_slims = TileEntitySlims.class;
		}

		if (magic_cauldron_be) {
			magic_cauldron = new BlockMagicCauldron("magic_cauldron");
			te_magic_cauldron = TileEntityMagicCauldron.class;
		}

		if (magic_locked_be) {
			magic_locked = new BlockLocked("magic_locked");
			te_magic_locked = TileEntityBlockLocked.class;
		}

		list_block = new Block[] {
				magic_machines, 
				magic_slims, 
				magic_cauldron, 
				magic_locked
		};

		UtilTMS.UtilBlock.RegBlock(list_block);

		list_te = new Class[] {
				te_magic_machines, 
				te_magic_slims, 
				te_magic_cauldron, 
				te_magic_locked
		};

		UtilTMS.UtilBlock.RegTE(list_te);

	}

}