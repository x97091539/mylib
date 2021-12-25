package com.xiexin.mylib;

import java.security.MessageDigest;

public class LibFunc {
    public int add(int a,int b){
        return a+b;
    }

    public static String getString(String key){
        StringBuilder sb = new StringBuilder();
        sb.append("1234567890ABCDEF").append(key);
        byte[] bArr = sb.toString().getBytes();
        String psd = getMessageDigest(bArr);
        psd = psd.substring(0, 7);
        return psd;
    }

    public static String getString(long imei,int sdk,String key){
        StringBuilder sb = new StringBuilder();
        sb.append("1234567890ABCDEF").append(key);
        byte[] bArr = sb.toString().getBytes();
        String psd = getMessageDigest(bArr);
        psd = psd.substring(0, 7);
        return psd;
    }

    public final static String getMessageDigest(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr2 = new char[(length * 2)];
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                byte b2 = digest[i2];
                int i4 = i3 + 1;
                cArr2[i3] = cArr[(b2 >>> 4) & 15];
                cArr2[i4] = cArr[b2 & 15];
                i2++;
                i3 = i4 + 1;
            }
            return new String(cArr2);
        } catch (Exception e2) {
            return null;
        }
    }
}
