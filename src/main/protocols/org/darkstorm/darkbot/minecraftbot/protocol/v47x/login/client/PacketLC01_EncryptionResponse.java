package org.darkstorm.darkbot.minecraftbot.protocol.v47x.login.client;

import org.darkstorm.darkbot.minecraftbot.protocol.AbstractPacketX;
import org.darkstorm.darkbot.minecraftbot.protocol.EncryptionUtil;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;
import org.darkstorm.darkbot.minecraftbot.protocol.WriteablePacket;

import javax.crypto.SecretKey;
import java.io.DataOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;

public class PacketLC01_EncryptionResponse extends AbstractPacketX implements WriteablePacket {
	private final SecretKey secretKey;
	private final PublicKey publicKey;
	private final byte[] sharedSecret, verifyToken;

	public PacketLC01_EncryptionResponse(SecretKey secretKey, PublicKey publicKey, byte[] verifyToken) {
		super(0x01, State.LOGIN, Direction.UPSTREAM);

		this.secretKey = secretKey;
		this.publicKey = publicKey;

		try {
			sharedSecret = EncryptionUtil.cipher(1, publicKey, secretKey.getEncoded());
			this.verifyToken = EncryptionUtil.cipher(1, publicKey, verifyToken);
		} catch(GeneralSecurityException exception) {
			throw new Error("Unable to cipher", exception);
		}
	}

	@Override
	public void writeData(DataOutputStream out) throws IOException {
		writeByteArray(sharedSecret, out);
		writeByteArray(verifyToken, out);
	}

	public SecretKey getSecretKey() {
		return secretKey;
	}

	public PublicKey getPublicKey() {
		return publicKey;
	}

	public byte[] getSharedSecret() {
		return sharedSecret;
	}

	public byte[] getVerifyToken() {
		return verifyToken;
	}
}
