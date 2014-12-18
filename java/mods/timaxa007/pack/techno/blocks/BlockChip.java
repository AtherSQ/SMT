package mods.timaxa007.pack.techno.blocks;

import java.util.List;

import mods.timaxa007.pack.techno.PackTechno;
import mods.timaxa007.pack.techno.te.TEChip;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockChip extends Block implements ITileEntityProvider{

	public BlockChip() {
		super(Material.iron);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
		setCreativeTab(PackTechno.proxy.tab_techno);
		setHardness(0.5F);
		setResistance(1.0F);
		setBlockTextureName("iron_block");
		setBlockName("electric.chip");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TEChip();
	}

	public int getRenderType() {
		return PackTechno.proxy.render_block_chip_modelID;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public int idPicked(World world, int x, int y, int z) {
		return 0;
	}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TEChip) return addTag(((TEChip)te).getType());
		return null;
	}
	/*
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
		TileEntity te = world.getTileEntity(x, y, z);

		if (player.isSneaking()) {
			return false;
		}

		if (te != null && te instanceof TEChip) {
			player.openGui(PackTechno.instance, 0, world, x, y, z);
			return true;
		}
		return false;
	}
	 */
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		TileEntity te = world.getTileEntity(x, y, z);

		if (te != null && te instanceof TEChip) {
			if (((TEChip)te).getRotation() == 0) {
				entity.motionZ += 0.1D;
			} else if (((TEChip)te).getRotation() == 1) {
				entity.motionX -= 0.1D;
			} else if (((TEChip)te).getRotation() == 3) {
				entity.motionX += 0.1D;
			} else if (((TEChip)te).getRotation() == 2) {
				entity.motionZ -= 0.1D;
			} else {}
		}

		entity.motionX *= 0.5D;
		entity.motionZ *= 0.5D;

	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound tag = is.getTagCompound();
		if (te != null && te instanceof TEChip) {

			int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			((TEChip)te).setRotation(l);

			if (tag != null) {

				if (tag.hasKey("Type")) ((TEChip)te).setType(tag.getInteger("Type"));

			}

		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		//for(int j = 0; j < TileTexture.tt01.length; ++j) {
		int j=0;
		list.add(addTag(j));
		//}
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(int par1) {
		ItemStack is = new ItemStack(PackTechno.proxy.block_chip, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("Type", par1);
		is.setTagCompound(tag);
		return is;
	}

}
