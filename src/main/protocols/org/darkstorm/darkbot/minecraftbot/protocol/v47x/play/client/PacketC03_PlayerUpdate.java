package org.darkstorm.darkbot.minecraftbot.protocol.v47x.play.client;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.WriteablePacket;

import java.io.DataOutputStream;
import java.io.IOException;

public class PacketC03_PlayerUpdate extends AbstractPacketX implements WriteablePacket {
	private boolean grounded;

	public PacketC03_PlayerUpdate(boolean grounded) {
		super(0x03, State.PLAY, Direction.UPSTREAM);

		this.grounded = grounded;
	}

	protected PacketC03_PlayerUpdate(int id, boolean grounded) {
		super(id, State.PLAY, Direction.UPSTREAM);

		this.grounded = grounded;
	}

	@Override
	public void writeData(DataOutputStream out) throws IOException {
		out.writeBoolean(grounded);
	}

	public boolean isGrounded() {
		return grounded;
	}
}
