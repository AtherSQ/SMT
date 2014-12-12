package mods.timaxa007.pack.furniture.ri;

import mods.timaxa007.pack.furniture.model.ModelBlockLamps2;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class ItemRenderLamps2On implements IItemRenderer{
private static ModelBlockLamps2 model;

public ItemRenderLamps2On() {
model=new ModelBlockLamps2();
}

@Override
public boolean handleRenderType(ItemStack is, ItemRenderType type) {
return true;
}

@Override
public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack is, ItemRendererHelper helper) {
return true;
}

@Override
public void renderItem(ItemRenderType type, ItemStack is, Object... data) {
GL11.glPushMatrix();
GL11.glTranslatef(0.5F, 1.5F, 0.5F);
GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

switch(is.getItemDamage()) {
case 0:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_black_on.png"));break;
case 1:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_blue_on.png"));break;
case 2:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_brown_on.png"));break;
case 3:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_cyan_on.png"));break;
case 4:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_gray_on.png"));break;
case 5:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_green_on.png"));break;
case 6:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_light_blue_on.png"));break;
case 7:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_light_gray_on.png"));break;
case 8:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_light_green_on.png"));break;
case 9:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_magenta_on.png"));break;
case 10:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_orange_on.png"));break;
case 11:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_pink_on.png"));break;
case 12:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_purple_on.png"));break;
case 13:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_red_on.png"));break;
case 14:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_white_on.png"));break;
case 15:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_yellow_on.png"));break;
default:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_red_on.png"));break;
}

this.model.render();
GL11.glPopMatrix();
}

}