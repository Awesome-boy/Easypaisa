package sdkdemo.kx.come.easypaylibrary.tools;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 */

public class MD5 {



    public static String buildSign(Map<String, String> map, String key) {
        System.out.println("xxxxxxtt>:" + map);
        Set<Map.Entry<String, String>> set = map.entrySet();
        StringBuffer sb = new StringBuffer();
        ArrayList<String> mStringArrayList = new ArrayList<>();
        for (Iterator<Map.Entry<String, String>> it = set.iterator(); it.hasNext(); ) {
            Map.Entry<String, String> item = it.next();
            if (!stringDetectionNull(item.getKey()) &&
                    !stringDetectionNull(item.getValue())) {
                mStringArrayList.add(item.getKey());
            } else {
                it.remove();
            }
        }
        mStringArrayList = getArray(mStringArrayList);
        for (int i = 0; i < mStringArrayList.size(); i++) {
            sb.append(map.get(mStringArrayList.get(i))+"&");
        }
        sb.append(key);
        System.out.println("xxxxxxtt111111>:" + sb);
        return sb.toString();
    }

    public static boolean stringDetectionNull(String str) {
        if (str == null || "".equals(str.trim()) || "NULL".equals(str.toUpperCase())) {
            return true;
        } else {
            return false;
        }
    }

    public static String getMD5(String message) {
        String md5str = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] input = message.getBytes();
            byte[] buff = md.digest(input);
            md5str = bytesToHex(buff);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5str;
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder md5str = new StringBuilder();
        int digital;
        for (byte aByte : bytes) {
            digital = aByte;

            if (digital < 0) {
                digital += 256;
            }
            if (digital < 16) {
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString().toLowerCase();
    }

    public static String buildData(Map<String, String> map) {
        Set<Map.Entry<String, String>> set = map.entrySet();
        StringBuffer sb = new StringBuffer();
        ArrayList<String> mStringArrayList = new ArrayList<>();
        for (Iterator<Map.Entry<String, String>> it = set.iterator(); it.hasNext(); ) {
            Map.Entry<String, String> item = it.next();
            if (!stringDetectionNull(item.getKey()) &&
                    !stringDetectionNull(item.getValue())) {
                mStringArrayList.add(item.getKey());
            } else {
                it.remove();
            }
        }
        mStringArrayList = getArray(mStringArrayList);
        for (int i = 0; i < mStringArrayList.size(); i++) {
            if (i==mStringArrayList.size()-1){
                sb.append(mStringArrayList.get(i)+"="+map.get(mStringArrayList.get(i)));
            }else {
                sb.append(mStringArrayList.get(i)+"="+map.get(mStringArrayList.get(i))+"&");
            }
        }
        System.out.println("xxxxxxtt111111>:" + sb);
        return sb.toString();
    }

    /**
     * 将byte转为16进制
     *
     * @param bytes
     * @return
     */
    private String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }


    public static ArrayList<String> getArray(ArrayList<String> keys) {
        Collections.sort(keys, new Comparator<String>() {
            public int compare(String pre, String next) {
                if (!stringDetectionNull(pre) && !stringDetectionNull(next)) {
                    char[] c_pre = pre.toCharArray();
                    char[] c_next = next.toCharArray();

                    int minSize = Math.min(c_pre.length, c_next.length);

                    for (int i = 0; i < minSize; i++) {
                        if (c_pre[i] != c_next[i]) {
                            return (int) String.valueOf(c_pre[i]).getBytes()[0] -
                                    (int) String.valueOf(c_next[i]).getBytes()[0];
                        }
                    }
                    return (int) String.valueOf(pre.toCharArray()[0]).getBytes()[0] -
                            (int) String.valueOf(next.toCharArray()[0]).getBytes()[0];
                } else {
                    return 1;
                }
            }
        });
        return keys;
    }

}
