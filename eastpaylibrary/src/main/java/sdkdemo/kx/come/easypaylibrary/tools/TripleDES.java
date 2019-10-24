package sdkdemo.kx.come.easypaylibrary.tools;

import android.media.MediaCodec;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class TripleDES {

	private static final String ALGORITHM = "DESede/ECB/PKCS5Padding";

	/***解密方式***/
	private static final String ENCRYPTION_MANNER = "DESede";


	/**
	 * 加密
	 * @param data 加密数据
	 * @param key 加密密码
	 * @return
	 * @throws Exception
	 */
	public static String encrypt3DES(byte[] data, byte[] key) throws Exception {
		// 恢复密钥
		SecretKey secretKey = new SecretKeySpec(key, ENCRYPTION_MANNER);
		// Cipher完成加密
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		// cipher初始化
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encrypt = cipher.doFinal(data);
		//转码
		return new String(Base64.encode(encrypt, Base64.DEFAULT), "UTF-8");
	}

	public static Key generateDESedeKey(byte[] key) {
		byte[] keyBytes = new byte[24];
		System.arraycopy(key, 0, keyBytes, 0, key.length);
		for (int i = 0; i < 8; i++) {
			keyBytes[key.length + i] = key[i];
		}
		return new SecretKeySpec(keyBytes, "DESede");
	}


	/**
	 * 解密
	 * @param data 加密后的字符串
	 * @param key 加密密码
	 * @return
	 * @throws Exception
	 */
	public static String decrypt3DES(String data, byte[] key) throws Exception {
		// 恢复密钥
		SecretKey secretKey = new SecretKeySpec(key, ENCRYPTION_MANNER);
		// Cipher完成解密
		Cipher cipher = Cipher.getInstance(ENCRYPTION_MANNER);
		// 初始化cipher
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		//转码
		byte[] bytes = Base64.decode(data.getBytes("UTF-8"), Base64.DEFAULT);
		//解密
		byte[] plain = cipher.doFinal(bytes);
		//解密结果转码
		return new String(plain, "utf-8");
	}
}
