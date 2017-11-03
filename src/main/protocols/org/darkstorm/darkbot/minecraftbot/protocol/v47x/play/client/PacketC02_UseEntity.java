package org.darkstorm.darkbot.minecraftbot.protocol.v47x.play.client;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.WriteablePacket;

import java.io.DataOutputStream;
import java.io.IOException;

public class PacketC02_UseEntity extends AbstractPacketX implements WriteablePacket {
	private int entityId, button;

	public PacketC02_UseEntity(int entityId, int button) {
		super(0x02, State.PLAY, Direction.UPSTREAM);

		this.entityId = entityId;
		this.button = button;
	}

	@Override
	public void writeData(DataOutputStream out) throws IOException {
		out.writeInt(entityId);
		out.write(button);
	}

	public int getEntityId() {
		return entityId;
	}

	public int getButton() {
		return button;
	}
}
