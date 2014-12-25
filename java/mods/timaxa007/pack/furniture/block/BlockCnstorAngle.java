package mods.timaxa007.pack.furniture.block;

import java.util.List;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.tile.TileEntityAngleMod;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCnstorAngle extends Block implements ITileEntityProvider {

	public BlockCnstorAngle() {
		super(Material.glass);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(0);
		setStepSound(soundTypeWood);
		setBlockTextureName("timaxa007:woodFrame");
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		setBlockName("cnstor.angle");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityAngleMod();
	}
	
	public int getRenderType() {
		return PackFurniture.proxy.render.block_cnstor_angle_modelID;
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
/*
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
	
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound tag = is.getTagCompound();
		
		if (te != null && te instanceof TileEntityAngleMod) {

			int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			((TileEntityAngleMod)te).rotation = l;

			if (tag != null) {
				((TileEntityAngleMod)te).setType(tag.getInteger("Type"));
				((TileEntityAngleMod)te).setSize(tag.getInteger("Size"));
				((TileEntityAngleMod)te).setRotation(tag.getBoolean("UPing"));
			}

		}
	}
*/
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		//for (int j = 0; j < TileTexture.consMT.length; ++j) {
		//for (int i = 0; i < 16; ++i) {
		//int j = 0;
		list.add(addTag(0, 0));
		//}
		//}
	//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(int par1, int par2) {
		ItemStack is=new ItemStack(PackFurniture.proxy.block.cnstor_angle, 1, 0);
		NBTTagCompound tag=new NBTTagCompound();
		tag.setInteger("Type", par2);
		tag.setInteger("Size", par1);
		is.setTagCompound(tag);
		return is;
	}

}