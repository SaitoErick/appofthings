package br.com.marcosvidolin.sgp.util;

import com.google.common.base.Charsets;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

/**
 * 
 * @author dev
 * @see https://code.google.com/p/guava-libraries/wiki/HashingExplained
 * @see http://md5.gromweb.com/
 */
public class MD5Util {

	
	/**
	 * 
	 * @param plainText
	 * @return
	 */
	public static String toMD5(String plainText) {
		HashFunction hf = Hashing.md5();
		return hf.newHasher().putString(plainText, Charsets.UTF_8).hash()
				.toString();
	}

}
