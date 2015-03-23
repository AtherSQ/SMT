package timaxa007.pack.furniture.render.item;

import timaxa007.tms.lib.AddTextureModel;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class ItemRenderGrills implements IItemRenderer{
	private static final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/grill01.obj"));

	public ItemRenderGrills() {

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
		NBTTagCompound nbt = is.getTagCompound();

		String tex = "";

		if (nbt != null) {
			if (nbt.hasKey("Style")) {tex = nbt.getString("Style");}
		}

		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

		Minecraft.getMinecraft().renderEngine.bindTexture(AddTextureModel.get(tex).getTexture());

		this.model.renderPart("grill");
		this.model.renderPart("grid");

		GL11.glPopMatrix();

	}

}