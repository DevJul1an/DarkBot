package org.darkstorm.darkbot.minecraftbot.protocol.v47x.login.server;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.ReadablePacket;

import java.io.DataInputStream;
import java.io.IOException;

public class PacketLS00_Disconnect extends AbstractPacketX implements ReadablePacket {
	private String data;

	public PacketLS00_Disconnect() {
		super(0x00, State.LOGIN, Direction.DOWNSTREAM);
	}

	@Override
	public void readData(DataInputStream in) throws IOException {
		data = readString(in);
	}

	public String getData() {
		return data;
	}
}
