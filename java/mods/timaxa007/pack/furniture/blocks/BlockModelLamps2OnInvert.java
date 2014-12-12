package mods.timaxa007.pack.furniture.blocks;

import java.util.List;
import java.util.Random;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.te.TELamps2On;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModelLamps2OnInvert extends BlockContainer{
@SideOnly(Side.CLIENT) private IIcon[] iconArray;
private final boolean powered;

public BlockModelLamps2OnInvert() {
super(Material.redstoneLight);
setCreativeTab(PackFurniture.proxy.tab_furniture_pack);
setStepSound(soundTypeGlass);
setHardness(0.3F);
setResistance(1.0F);
setLightOpacity(1);
powered=true;
setLightLevel(1.0F);
setBlockTextureName("planks_oak");
setBlockName("BlockModelLamps2OnInvert");
}
/*
@SideOnly(Side.CLIENT)
public IIcon getIcon(int par1, int par2) {
return iconArray[par2 % iconArray.length];
}
*/
public int quantityDropped(Random par1Random) {return 0;}
public int idDropped(int par1, Random par2Random, int par3) {return par1;}
public int damageDropped(int par1) {return par1;}

public int getRenderType() {return -1;}
public boolean isOpaqueCube() {return false;}
public boolean renderAsNormalBlock() {return false;}

@Override
public TileEntity createNewTileEntity(World world, int meta) {return new TELamps2On();}

@SideOnly(Side.CLIENT)
public void getSubBlocks(Item id, CreativeTabs table, List list) {
for(byte j=0;j<16;++j) {list.add(new ItemStack(id, 1, j));}
}

public void onBlockAdded(World world, int par2, int par3, int par4) {
if(!world.isRemote) {
if(!powered && !world.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
world.scheduleBlockUpdate(par2, par3, par4, this, 4);
}
else if(powered && world.isBlockIndirectlyGettingPowered(par2, par3, par4)) {

for(byte j=0;j<16;++j) {
if(getDamageValue(world, par2, par3, par4)==j) {
world.setBlock(par2, par3, par4, PackFurniture.proxy.block_model_lamps2_off_invert, j, 2);
}
}

}
}
}

public void onNeighborBlockChange(World world, int par2, int par3, int par4, int par5) {
if(!world.isRemote) {
if(!powered && !world.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
world.scheduleBlockUpdate(par2, par3, par4, this, 4);
}
else if(powered && world.isBlockIndirectlyGettingPowered(par2, par3, par4)) {

for(byte j=0;j<16;++j) {
if(getDamageValue(world, par2, par3, par4)==j) {

world.setBlock(par2, par3, par4, PackFurniture.proxy.block_model_lamps2_off_invert, j, 2);
}
}

}
}
}

public void updateTick(World world, int par2, int par3, int par4, Random par5Random) {
if(!world.isRemote && !powered && !world.isBlockIndirectlyGettingPowered(par2, par3, par4)) {

for(byte j=0;j<16;++j) {
if(getDamageValue(world, par2, par3, par4)==j) {
world.setBlock(par2, par3, par4, PackFurniture.proxy.block_model_lamps2_on_invert, j, 2);
}
}

}
}
/*
@Override 
public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune) {
ArrayList<ItemStack> ret=super.getBlockDropped(world, x, y, z, metadata, fortune);
ret.add(new ItemStack(PackFurniture.proxy.block_model_lamps2_on_invert, 1, metadata));
return ret;
}
*/
@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister ir) {
iconArray=new IIcon[16];
for(byte i=0;i<iconArray.length;++i) {
iconArray[i]=ir.registerIcon("timaxa007:"+"lamps/lamp_"+GetColors.getNameColors[i]+"_on");
}
}

}