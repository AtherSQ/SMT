package timaxa007.pack.furniture.block;

import java.util.List;
import java.util.Set;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.tile.TileEntityArmChair;
import timaxa007.tms.util.ModifiedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockArmChair extends ModifiedBlock implements ITileEntityProvider {

	public BlockArmChair(String tag) {
		super(tag, Material.wood);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(0.5F);
		setResistance(2.5F);
		setStepSound(soundTypeWood);
		setBlockTextureName("planks_oak");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityArmChair();
	}

	@Override
	public int getRenderType() {
		return PackFurniture.proxy.render.block_armchair_modelID;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityArmChair) {
			TileEntityArmChair tile = (TileEntityArmChair)te;
			return addNBT(tile.getType(), tile.getSize());
		} else return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs table, List list) {
		for (String type : (Set<String>) Block.blockRegistry.getKeys()) {
			Block b = (Block) Block.blockRegistry.getObject(type);
			if (b.getIcon(1, 0) != null && !(b instanceof ITileEntityProvider)) {
				list.add(addNBT(type, 0));
				list.add(addNBT(type, 1));
				list.add(addNBT(type, 2));
				list.add(addNBT(type, 3));
				list.add(addNBT(type, 4));
				list.add(addNBT(type, 5));
				list.add(addNBT(type, 6));
				list.add(addNBT(type, 7));
				list.add(addNBT(type, 8));
				list.add(addNBT(type, 9));
				list.add(addNBT(type, 10));
				list.add(addNBT(type, 11));
			}
		}
	}

	public static ItemStack addNBT(String par1, int par2) {
		ItemStack is = new ItemStack(PackFurniture.proxy.block.arm_chair, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("Type", par1);
		nbt.setInteger("Size", par2);
		is.setTagCompound(nbt);
		return is;
	}

}