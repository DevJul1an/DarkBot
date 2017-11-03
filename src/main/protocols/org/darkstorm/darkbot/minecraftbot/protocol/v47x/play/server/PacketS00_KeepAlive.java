package org.darkstorm.darkbot.minecraftbot.protocol.v47x.play.server;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.ReadablePacket;

import java.io.DataInputStream;
import java.io.IOException;

public class PacketS00_KeepAlive extends AbstractPacketX implements ReadablePacket {
	private int pingId;

	public PacketS00_KeepAlive() {
		super(0x00, State.PLAY, Direction.DOWNSTREAM);
	}

	@Override
	public void readData(DataInputStream in) throws IOException {
		pingId = in.readInt();
	}

	public int getPingId() {
		return pingId;
	}
}
