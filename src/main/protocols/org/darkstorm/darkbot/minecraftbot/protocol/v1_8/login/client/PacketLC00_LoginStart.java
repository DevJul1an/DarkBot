package org.darkstorm.darkbot.minecraftbot.protocol.v1_8.login.client;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.WriteablePacket;

import java.io.DataOutputStream;
import java.io.IOException;

public class PacketLC00_LoginStart extends AbstractPacketX implements WriteablePacket {
	private final String name;

	public PacketLC00_LoginStart(String name) {
		super(0x00, State.LOGIN, Direction.UPSTREAM);

		this.name = name;
	}

	@Override
	public void writeData(DataOutputStream out) throws IOException {
		writeString(name, out);
	}

	public String getName() {
		return name;
	}
}
