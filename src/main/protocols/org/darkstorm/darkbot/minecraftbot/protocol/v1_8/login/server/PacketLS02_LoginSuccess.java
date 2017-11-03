package org.darkstorm.darkbot.minecraftbot.protocol.v1_8.login.server;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.ReadablePacket;

import java.io.DataInputStream;
import java.io.IOException;

public class PacketLS02_LoginSuccess extends AbstractPacketX implements ReadablePacket {
	private String uuid, username;

	public PacketLS02_LoginSuccess() {
		super(0x02, State.LOGIN, Direction.DOWNSTREAM);
	}

	@Override
	public void readData(DataInputStream in) throws IOException {
		uuid = readString(in);
		username = readString(in);
	}

	public String getUuid() {
		return uuid;
	}

	public String getUsername() {
		return username;
	}
}
