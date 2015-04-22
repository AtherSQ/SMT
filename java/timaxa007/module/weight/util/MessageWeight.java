package timaxa007.module.weight.util;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import timaxa007.tms.CoreTMS;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageWeight implements IMessage {

	//public float weight;
	public float weight_max;

	public MessageWeight() {}

	public MessageWeight(float weight_max) {
		//this.weight = weight;
		this.weight_max = weight_max;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		//buf.writeFloat(weight);
		buf.writeFloat(weight_max);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		//weight = buf.readFloat();
		weight_max = buf.readFloat();
	}
	//----------------------------------------------------------------------------------
	public static class Handler implements IMessageHandler<MessageWeight, IMessage> {

		@Override
		public IMessage onMessage(MessageWeight packet, MessageContext context) {
			//float weight = packet.weight;
			float weight_max = packet.weight_max;
			ActionWeight.setWeight(null, weight_max);
			return null;
		}

	}
	//----------------------------------------------------------------------------------
}