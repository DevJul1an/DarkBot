package org.darkstorm.darkbot.minecraftbot.protocol.v47x.play.client;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.WriteablePacket;

import java.io.DataOutputStream;
import java.io.IOException;

public class PacketC17_PluginMessage extends AbstractPacketX implements WriteablePacket {
	private String channel;
	private byte[] data;

	public PacketC17_PluginMessage(String channel, byte[] data) {
		super(0x17, State.PLAY, Direction.UPSTREAM);

		this.channel = channel;
		this.data = data;
	}

	@Override
	public void writeData(DataOutputStream out) throws IOException {
		writeString(channel, out);
		writeByteArray(data, out);
	}

	public String getChannel() {
		return channel;
	}

	public byte[] getData() {
		return data;
	}
}
