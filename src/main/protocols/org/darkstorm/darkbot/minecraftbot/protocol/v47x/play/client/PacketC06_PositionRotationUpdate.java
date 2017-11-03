package org.darkstorm.darkbot.minecraftbot.protocol.v47x.play.client;

import java.io.DataOutputStream;
import java.io.IOException;

public class PacketC06_PositionRotationUpdate extends PacketC03_PlayerUpdate {
	private double x, y, z, stance, yaw, pitch;

	public PacketC06_PositionRotationUpdate(double x, double y, double z, double stance, double yaw, double pitch, boolean grounded) {
		super(0x06, grounded);

		this.x = x;
		this.y = y;
		this.z = z;
		this.stance = stance;
		this.yaw = yaw;
		this.pitch = pitch;
	}

	@Override
	public void writeData(DataOutputStream out) throws IOException {
		out.writeDouble(x);
		out.writeDouble(y);
		out.writeDouble(stance);
		out.writeDouble(z);
		out.writeFloat((float) yaw);
		out.writeFloat((float) pitch);

		super.writeData(out);
	}
}
