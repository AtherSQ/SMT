package mods.timaxa007.pack.mining.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketPackMiningClient implements IMessage {

	public int button;
	public boolean buttonstate;

	public PacketPackMiningClient() {}

	public PacketPackMiningClient(int button, boolean buttonstate) {
		this.button = button;
		this.buttonstate = buttonstate;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(button);
		buf.writeBoolean(buttonstate);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		button = buf.readInt();
		buttonstate = buf.readBoolean();
	}

	public static class Handler implements IMessageHandler<PacketPackMiningClient, IMessage> {

		@Override
		public IMessage onMessage(PacketPackMiningClient packet, MessageContext message) {
			int button = packet.button;
			boolean buttonstate = packet.buttonstate;
			EntityPlayerMP player = message.getServerHandler().playerEntity;

			switch(button) {
			//case 0:ActionWeapons.onReload(player);break;
			}

			return null;
		}

	}

}
