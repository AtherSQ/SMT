package mods.timaxa007.pack.furniture.render.block;

import mods.timaxa007.lib.TileTexture;
import mods.timaxa007.pack.furniture.tile.TEMincer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class BlockRenderMincer extends TileEntitySpecialRenderer {
	private static final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/micer.obj"));

	public BlockRenderMincer() {

	}

	public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
		renderTE((TEMincer)te, dx, dy, dz, f);
	}

	private void renderTE(TEMincer te, double dx, double dy, double dz, float f) {

		GL11.glPushMatrix();
		GL11.glTranslated(dx, dy, dz);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

		switch (te.getBlockMetadata()) {
		case 0:GL11.glRotatef(-180F, 0F, 0F, 1F);break;
		case 3:GL11.glRotatef(-90F, 0F, 0F, 1F);break;
		case 2:GL11.glRotatef(0F, 0F, 0F, 1F);break;
		case 1:GL11.glRotatef(90F, 0F, 0F, 1F);break;
		default:GL11.glRotatef(0F, 0F, 0F, 1F);break;
		}

		bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
		model.renderAll();
		GL11.glPopMatrix();
	}

}