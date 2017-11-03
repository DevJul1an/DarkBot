package org.darkstorm.darkbot.minecraftbot.protocol.v47x.play.client;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.WriteablePacket;

import java.io.DataOutputStream;
import java.io.IOException;

public class PacketC13_PlayerAbilities extends AbstractPacketX implements WriteablePacket {

	public PacketC13_PlayerAbilities() {
		super(0x00, State.PLAY, Direction.UPSTREAM);
	}

	@Override
	public void writeData(DataOutputStream out) throws IOException {
	}
}
