// Copyright (c) 1998-2016 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2016-XX-XX, damon.huang, creation
// ============================================================================
package com.webchat.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author damon.huang
 *
 */
public class AuthenticationUtil {
    private static final String token = "damon";

    public static boolean validateSignature(final String signatrue, final String timestamp, final String nonce) {
        final String[] args = new String[]{token, timestamp, nonce};
        Arrays.sort(args);
        final String encrypt = SHA1(args.toString());
        return encrypt.equals(signatrue);
    }

    private static String SHA1(final String decript) {
        try {
            final MessageDigest digest = java.security.MessageDigest
                    .getInstance("SHA-1");
            digest.update(decript.getBytes());
            final byte messageDigest[] = digest.digest();
            // Create Hex String
            final StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                final String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (final NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
