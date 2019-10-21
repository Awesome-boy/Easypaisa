package sdkdemo.kx.come.easypaylibrary.tools;


import android.text.TextUtils;
import android.util.Base64;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by leidong on 2016/11/9.
 * DES类
 */

public  class ThreeDES {

    // 定义加密算法，DESede即3DES
    private static final String ALGORITHM = "DESede/ECB/PKCS5Padding";

    /**
     * 3DES加密
     * @param str
     * @return
     */
    public static String get3DesString( byte[] Key,String str){
        if(!TextUtils.isEmpty(str)){
            byte[] enBytes = encryptMode(Key, str.getBytes());
            return Base64.encodeToString(enBytes,Base64.DEFAULT);
        }else{
            return null;
        }
    }
    /**
     * 加密
     * @param key
     * @param src
     * @return
     */
    private static byte[] encryptMode( byte[] key, byte[] src) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, generateDESedeKey(key));
            return cipher.doFinal(src);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Key generateDESedeKey(byte[] key) {
        byte[] keyBytes = new byte[24];
        System.arraycopy(key, 0, keyBytes, 0, key.length);
        for (int i = 0; i < 8; i++) {
            keyBytes[key.length + i] = key[i];
        }
        return new SecretKeySpec(keyBytes, "DESede");
    }

}
