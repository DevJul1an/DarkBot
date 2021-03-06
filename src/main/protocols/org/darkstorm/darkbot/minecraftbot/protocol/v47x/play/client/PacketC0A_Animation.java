package org.darkstorm.darkbot.minecraftbot.protocol.v47x.play.client;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.WriteablePacket;

import java.io.DataOutputStream;
import java.io.IOException;

public class PacketC0A_Animation extends AbstractPacketX implements WriteablePacket {
	private int playerId;
	private Animation animation;

	public PacketC0A_Animation(int playerId, Animation animation) {
		super(0x0A, State.PLAY, Direction.UPSTREAM);

		this.playerId = playerId;
		this.animation = animation;
	}

	@Override
	public void writeData(DataOutputStream out) throws IOException {
		out.writeInt(playerId);
		out.writeByte(animation.getId());
	}

	public enum Animation {
		NONE(0),
		SWING_ARM(1),
		TAKE_DAMAGE(2),
		LEAVE_BED(3),
		EAT_FOOD(5),
		CRITICAL_EFFECT(6),
		MAGIC_CRITICAL_EFFECT(7),

		UNKNOWN_102(102),
		CROUCH(104),
		UNCROUCH(105);

		private final int id;

		private Animation(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}
	}
}
