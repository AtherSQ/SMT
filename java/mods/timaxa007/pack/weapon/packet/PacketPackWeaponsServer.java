package mods.timaxa007.pack.weapon.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketPackWeaponsServer implements IMessage {

	public int button;
	public boolean buttonstate;

	public PacketPackWeaponsServer() {}

	public PacketPackWeaponsServer(int button, boolean buttonstate) {
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

	public static class Handler implements IMessageHandler<PacketPackWeaponsServer, IMessage> {

		@Override
		public IMessage onMessage(PacketPackWeaponsServer packet, MessageContext message) {
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
