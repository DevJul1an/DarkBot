package org.darkstorm.darkbot.minecraftbot.protocol.v1_8.play.server;

import java.io.DataInputStream;
import java.io.IOException;

public class PacketS1E_EntityRemoveEffect extends PacketS14_EntityUpdate {
	private int effectId;

	public PacketS1E_EntityRemoveEffect() {
		super(0x1E);
	}

	@Override
	public void readData(DataInputStream in) throws IOException {
		super.readData(in);

		effectId = in.read();
	}

	public int getEffectId() {
		return effectId;
	}
}
