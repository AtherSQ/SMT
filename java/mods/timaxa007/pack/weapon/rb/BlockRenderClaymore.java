package mods.timaxa007.pack.weapon.rb;

import mods.timaxa007.pack.weapon.model.ModelClaymoreStick;
import mods.timaxa007.pack.weapon.te.TEClaymore;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class BlockRenderClaymore extends TileEntitySpecialRenderer {
private static ModelClaymoreStick model;

public BlockRenderClaymore() {
model = new ModelClaymoreStick();
}

public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
renderTE((TEClaymore)te, dx, dy, dz, f);
}

public void renderTE(TEClaymore te, double dx, double dy, double dz, float f) {
GL11.glPushMatrix();
GL11.glTranslated(dx, dy, dz);
GL11.glTranslatef(0.5F, 1.5F, 0.5F);
GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
bindTexture(new ResourceLocation("textures/blocks/planks_oak.png"));
model.render();
GL11.glPopMatrix();
}

}