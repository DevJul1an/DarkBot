package org.darkstorm.darkbot.minecraftbot.protocol.v1_8.play.server;

import java.io.DataInputStream;
import java.io.IOException;

public class PacketS19_EntityHeadRotationUpdate extends PacketS14_EntityUpdate {
	private double headYaw;

	public PacketS19_EntityHeadRotationUpdate() {
		super(0x19);
	}

	@Override
	public void readData(DataInputStream in) throws IOException {
		super.readData(in);

		headYaw = (in.readByte() * 360) / 256D;
	}

	public double getHeadYaw() {
		return headYaw;
	}
}
