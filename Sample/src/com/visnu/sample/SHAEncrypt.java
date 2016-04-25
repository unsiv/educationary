package com.visnu.sample;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAEncrypt
{

	public static String	SHA_1_ALGO		= "SHA-1";
	public static String	SHA_256_ALGO	= "SHA-256";
	public static String	text			= "admin_dashboard";

	public static void main(String[] args)
	{

		System.out.println(encrypt(text, SHA_1_ALGO));
		// System.out.println(encrypt(text, SHA_256_ALGO));

	}

	public static String encrypt(String plaintext, String algorithm)
	{
		StringBuffer hexString = new StringBuffer();
		try
		{
			MessageDigest md = MessageDigest.getInstance(algorithm);
			md.update(plaintext.getBytes());

			byte byteData[] = md.digest();

			// convert the byte to hex format method 1
			for (int i = 0; i < byteData.length; i++)
			{
				hexString.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}

			// // convert the byte to hex format method 2
			//
			// for (int i = 0; i < byteData.length; i++)
			// {
			// String hex = Integer.toHexString(0xff & byteData[i]);
			// if (hex.length() == 1)
			// hexString.append('0');
			// hexString.append(hex);
			// }
			// System.out.println("Hex format : " + hexString.toString());
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		return hexString.toString();

	}
}
