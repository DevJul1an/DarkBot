package org.darkstorm.darkbot.minecraftbot.protocol.v47x.play.client;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.WriteablePacket;

import java.io.DataOutputStream;
import java.io.IOException;

public class PacketC00_KeepAlive extends AbstractPacketX implements WriteablePacket {
	private int pingId;

	public PacketC00_KeepAlive(int pingId) {
		super(0x00, State.PLAY, Direction.UPSTREAM);

		this.pingId = pingId;
	}

	@Override
	public void writeData(DataOutputStream out) throws IOException {
		out.writeInt(pingId);
	}

	public int getPingId() {
		return pingId;
	}
}
