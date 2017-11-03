package org.darkstorm.darkbot.minecraftbot.protocol.v1_8.play.server;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.ReadablePacket;
import org.darkstorm.darkbot.minecraftbot.util.IntHashMap;
import org.darkstorm.darkbot.minecraftbot.world.entity.WatchableObject;

import java.io.DataInputStream;
import java.io.IOException;

public class PacketS0C_SpawnPlayer extends AbstractPacketX implements ReadablePacket {
	private int entityId;
	private String uuid, name;
	private PlayerProperty[] properties;

	private double x, y, z, yaw, pitch;
	private int heldItemId;
	private IntHashMap<WatchableObject> metadata;

	public PacketS0C_SpawnPlayer() {
		super(0x0C, State.PLAY, Direction.DOWNSTREAM);
	}

	@Override
	public void readData(DataInputStream in) throws IOException {
		entityId = readVarInt(in);
		uuid = readString(in);
		name = readString(in);

		properties = new PlayerProperty[readVarInt(in)];
		for(int i = 0; i < properties.length; i++) {
			String name = readString(in);
			String value = readString(in);
			String signature = readString(in);
			properties[i] = new PlayerProperty(name, value, signature);
		}

		x = in.readInt() / 32D;
		y = in.readInt() / 32D;
		z = in.readInt() / 32D;
		yaw = (in.readByte() * 360) / 256D;
		pitch = (in.readByte() * 360) / 256D;
		heldItemId = in.readShort();
		metadata = readWatchableObjects(in);
	}

	public int getEntityId() {
		return entityId;
	}

	public String getUuid() {
		return uuid;
	}

	public String getName() {
		return name;
	}

	public PlayerProperty[] getProperties() {
		return properties.clone();
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public double getYaw() {
		return yaw;
	}

	public double getPitch() {
		return pitch;
	}

	public int getHeldItemId() {
		return heldItemId;
	}

	public IntHashMap<WatchableObject> getMetadata() {
		return metadata;
	}

	public static class PlayerProperty {
		private final String name, value, signature;

		private PlayerProperty(String name, String value, String signature) {
			this.name = name;
			this.value = value;
			this.signature = signature;
		}

		public String getName() {
			return name;
		}

		public String getValue() {
			return value;
		}

		public String getSignature() {
			return signature;
		}
	}
}
