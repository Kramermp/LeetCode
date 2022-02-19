package main;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scnr =  new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash  = digest.digest(scnr.next().getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {

            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }

        System.out.println(sb.toString());

    }
}