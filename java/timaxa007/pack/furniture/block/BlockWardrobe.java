package timaxa007.pack.furniture.block;

import java.util.List;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.tile.TileEntityWardrobe;
import timaxa007.tms.util.ModifiedBlock;
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

public class BlockWardrobe extends ModifiedBlock implements ITileEntityProvider {

	public BlockWardrobe(String tag) {
		super(tag, Material.wood);
		setHardness(0.5F);
		setCreativeTab(PackFurniture.tab_furniture);
		setBlockTextureName("planks_oak");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityWardrobe();
	}

	public int getRenderType() {
		return PackFurniture.proxy.render.block_wardrobe_modelID;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int idPicked(World world, int x, int y, int z) {
		return 0;
	}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityWardrobe) 
			return addNBT(0, ((TileEntityWardrobe)te).getType());
		return null;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		//for(int j=0;j<TileTexture.getTexturesConstructionCount;++j) {
		//for(byte i=0;i<16;++i) {
		int j=0;

		list.add(addNBT(0, j));
		//list.add(addNBT(1, j));
		//list.add(addNBT(2, j));
		//list.add(addNBT(3, j));
		//list.add(addNBT(4, j));
		//list.add(addNBT(5, j));
		//list.add(addNBT(6, j));
		//list.add(addNBT(7, j));
		//list.add(addNBT(8, j));
		//list.add(addNBT(9, j));
		//list.add(addNBT(10, j));
		//list.add(addNBT(11, j));
		//}
		//}
		//list.add(new ItemStack(PackFurniture.blockCnstorBlock, 1, 0));
	}

	public static ItemStack addNBT(int par1, int par2) {
		ItemStack is = new ItemStack(PackFurniture.proxy.block.wardrobe, 1, par1);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("Type", par2);
		is.setTagCompound(nbt);
		return is;
	}

}