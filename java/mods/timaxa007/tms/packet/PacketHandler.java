package mods.timaxa007.tms.packet;
//anti344
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.EnumMap;

import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.relauncher.Side;
//PacketHandler.init()
@Sharable//��� �����, ������, ����� ����
public class PacketHandler extends SimpleChannelInboundHandler<FMLProxyPacket>{

private static FMLEmbeddedChannel server;
private static FMLEmbeddedChannel client;

public static void init(){
EnumMap<Side, FMLEmbeddedChannel> channels = NetworkRegistry.INSTANCE.newChannel("����������_��������_������_modid_��������", new PacketHandler());
client = channels.get(Side.CLIENT);
server = channels.get(Side.SERVER);
}

public static void sendToServer(ByteBuf data){ //ByteBuf - �������� �����, ��� ������ ������� � IDE, � �������� ��� ����� ������� Unpooled.buffer()
client.attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
client.writeAndFlush(new FMLProxyPacket(data, "��_�����_��������_������_���������_�_���������_�_��_��������")).addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
}

//cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper - ������ ���� "������" - �������, � ��������� � �. �. ��� � ������ ������ PacketDispatcher-�.

@Override
public void  channelRead0(ChannelHandlerContext ctx, FMLProxyPacket msg){
ByteBuf data = msg.payload();//���� ����.
switch(data.readByte()){//������� ���� ������, �� ������ ���������� ������ ���
//case 0:doMagic1();break;
//case 1:doMagic2();break;
//default:sysout("WRONG PACKET RECEIVED");
}
}
}