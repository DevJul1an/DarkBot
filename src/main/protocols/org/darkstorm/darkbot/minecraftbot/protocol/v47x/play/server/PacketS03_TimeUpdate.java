package org.darkstorm.darkbot.minecraftbot.protocol.v47x.play.server;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.ReadablePacket;

import java.io.DataInputStream;
import java.io.IOException;

public class PacketS03_TimeUpdate extends AbstractPacketX implements ReadablePacket {
	private long worldAge, time;

	public PacketS03_TimeUpdate() {
		super(0x03, State.PLAY, Direction.DOWNSTREAM);
	}

	@Override
	public void readData(DataInputStream in) throws IOException {
		worldAge = in.readLong();
		time = in.readLong();
	}

	public long getWorldAge() {
		return worldAge;
	}

	public long getTime() {
		return time;
	}
}
