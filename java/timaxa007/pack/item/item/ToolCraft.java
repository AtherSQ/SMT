package timaxa007.pack.item.item;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
import timaxa007.module.control_button.api.IActionMouse;
import timaxa007.module.control_button.api.IActionPrimaryKey;
import timaxa007.pack.item.PackItems;
import timaxa007.pack.item.packet.MessageInteractionBlock;
import timaxa007.pack.item.packet.MessageInteractionEntity;
import timaxa007.pack.item.util.IToolCraft;
import timaxa007.tms.object.ModifiedItem;
import timaxa007.tms.util.UtilTMS;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolCraft extends ModifiedItem implements IActionMouse, IActionPrimaryKey, IToolCraft {
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT) public static boolean isLeftClick;
	@SideOnly(Side.CLIENT) public static boolean isRightClick;

	@SideOnly(Side.CLIENT) public static boolean isReload;
	@SideOnly(Side.CLIENT) public static boolean isCharge;
	@SideOnly(Side.CLIENT) public static boolean isMode;
	@SideOnly(Side.CLIENT) public static boolean isAction;
	@SideOnly(Side.CLIENT) public static boolean isModeIn;
	@SideOnly(Side.CLIENT) public static boolean isModeOut;
	//--------------------------------------------------------------------------------------------------------------
	public ToolCraft(String tag) {
		super(tag);
		setCreativeTab(PackItems.tab_items);
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onLeftClickTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

		if (tick >= 2 && tick % 20 == 2) {
			MovingObjectPosition entity = UtilTMS.LookOBJ.look(true);

			if (entity != null) {
				if (entity.entityHit != null && entity.typeOfHit == MovingObjectType.ENTITY) {

					double pos_x = entity.entityHit.posX;
					double pos_y = entity.entityHit.posY;
					double pos_z = entity.entityHit.posZ;
					world.spawnParticle("reddust", pos_x, pos_y, pos_z, 0.0D, 255.0D, 0.0D);

					PackItems.network.sendToServer(new MessageInteractionEntity(entity.entityHit.getEntityId(), 1));
				}
				if (entity.typeOfHit == MovingObjectType.BLOCK) {

					int pos_x = entity.blockX;
					int pos_y = entity.blockY;
					int pos_z = entity.blockZ;

					PackItems.network.sendToServer(new MessageInteractionBlock(pos_x, pos_y, pos_z, 1));
				}

			}

		}

	}

	@SideOnly(Side.CLIENT)
	public void onLeftClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isLeftClick = isPress;

	}

	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onRightClickTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onRightClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isRightClick = isPress;
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onReloadTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onReloadClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isReload = isPress;
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onChargeTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onChargeClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isCharge = isPress;
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onModeTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onModeClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isMode = isPress;
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onActionTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onActionClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isAction = isPress;
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onModeInTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onModeInClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isModeIn = isPress;
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onModeOutTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onModeOutClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isModeOut = isPress;
	}
	//--------------------------------------------------------------------------------------------------------------
	@Override
	public void interactionWichEntity(ItemStack is, World world, EntityPlayer player, Entity entity) {

	}
	@Override
	public void interactionWichEntityBlock(ItemStack is, World world, EntityPlayer player, Block block, int x, int y, int z) {

	}
	//--------------------------------------------------------------------------------------------------------------
}