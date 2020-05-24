package com.revature.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;


public class StringUtil {
	public static Logger log = Logger.getLogger(StringUtil.class);
	
    public static boolean isStringNullOrEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static int safeParseInt(String str) {
        int i = -1;
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException ignored) {
            // no-op
        }
        return i;
    }

    /**
     * Hashing strings for password storage/comparison.
     * Ideally we'd be salting the hash and using an
     * algorithm like BCrypt instead of SHA, but even
     * bothering with password management is beyond
     * what's needed for this project, so just hashing
     * them should be fine.
     *
     * @param unhashed - the string we're going to hash
     * @return the SHA-512 hash for unhashed
     */
    public static String sha512String(final String unhashed) {
    	if (isStringNullOrEmpty(unhashed)) return "";
        try {
        	
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            StringBuilder builder = new StringBuilder();

            byte[] hashedBytes = digest.digest(unhashed.getBytes(StandardCharsets.UTF_8));
            for (byte hashedByte : hashedBytes) {
                String hex = Integer.toHexString(0xff & hashedByte);
                if (hex.length() == 1) builder.append('0');
                builder.append(hex);
            }

            return builder.toString();
        } catch (NoSuchAlgorithmException ex) {
            log.error("We're not suppose to get here?!");
        }
        return "";
    }
}