package org.darkstorm.darkbot.minecraftbot.protocol.v47x.play.server;

import java.io.DataInputStream;
import java.io.IOException;

public class PacketS1D_EntityEffectUpdate extends PacketS14_EntityUpdate {
	private int effectId, amplifier, duration;

	public PacketS1D_EntityEffectUpdate() {
		super(0x1D);
	}

	@Override
	public void readData(DataInputStream in) throws IOException {
		super.readData(in);

		effectId = in.read();
		amplifier = in.readByte();
		duration = in.readShort();
	}

	public int getEffectId() {
		return effectId;
	}

	public int getAmplifier() {
		return amplifier;
	}

	public int getDuration() {
		return duration;
	}
}
