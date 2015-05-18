package timaxa007.pack.magic.tile;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import timaxa007.module.forbidden.api.ITileEntityOwner;
import timaxa007.pack.magic.PackMagic;
import timaxa007.smt.util.UtilString;

public class TileEntityMagicMachines extends TileEntity implements ISidedInventory, ITileEntityOwner {

	private int type;
	private int rot;
	private String owner;

	public TileEntityMagicMachines() {
		type = 0;
		rot = 0;
		owner = "";
	}

	public void setType(int i) {type = i;}
	public int getType() {return type;}

	public void setRot(int i) {rot = i;}
	public int getRot() {return rot;}

	public void setOwner(String username) {owner = username;}
	public String getOwner() {return owner;}

	public void updateEntity() {
		Block block = worldObj.getBlock(xCoord, yCoord, zCoord);
		float light = worldObj.getSunBrightness(1.0F);

		if (worldObj.canBlockSeeTheSky(xCoord, yCoord + 1, zCoord) && light >= 0.9F) {
			if (block == PackMagic.block.magic_machines) {
				System.out.println("day - " + light);
			}
		}
	}

	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("Owner")) owner = nbt.getString("Owner");
	}

	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		if (UtilString.hasString(owner)) nbt.setString("Owner", owner);
	}

	public Packet getDescriptionPacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt);
	}

	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
	}

	@Override
	public int getSizeInventory() {
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {
		return null;
	}

	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {

	}

	@Override
	public String getInventoryName() {
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		return false;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
		return null;
	}

	@Override
	public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
		return false;
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
		return false;
	}

}
