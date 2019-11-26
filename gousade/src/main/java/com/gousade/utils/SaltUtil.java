package com.gousade.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;

public class SaltUtil {//toHex和bytetoHex方法得到的结果是相同的，ByteSource.Util.bytes(salt)方法似乎并不影响加密结果
    public static final String g = "-";
    public static final String k = "";
    private static String algorithmName="md5";
    private static int hashIterations=52;
    public static String getUUId() {
        return UUID.randomUUID().toString().replace(g, k);
    }
    
    public static String getsalt() {
        return DigestUtils.md5Hex(UUID.randomUUID().toString().replace(g, k));
    }
    
    public static String toHex(Object source, Object salt) {
        return new SimpleHash(algorithmName, source, ByteSource.Util.bytes(salt), hashIterations).toHex();
    }
    public static String bytetoHex(Object source, Object salt) {
        return new SimpleHash(algorithmName, source, salt, hashIterations).toHex();
    }
    @Test
    public void test() throws UnknownHostException {
        String saltstr= getsalt();
        String uidstr=getUUId();
        String uuidstr=DigestUtils.md5Hex(uidstr);
        System.out.println("uid："+uidstr);
        System.out.println("uid加盐："+uuidstr);
        System.out.println("盐："+saltstr);
        InetAddress address = InetAddress.getLocalHost();
		String hostAddress = address.getHostAddress();
//		System.out.println("your ip is : "+hostAddress);
		String nobyte=toHex("123456","salt");
		String havebyte=toHex("123456","salt");
		System.err.println("无byte加密："+nobyte);
		System.err.println("有byte加密："+havebyte);
		System.err.println(ByteSource.Util.bytes("salt").toString());
    }
}
