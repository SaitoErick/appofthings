package br.com.marcosvidolin.sgp.util;

import org.junit.Test;

import br.com.marcosvidolin.sgp.util.MD5Util;

public class MD5UtilTest {

	@Test
	public void testToMD5() {
		System.out.println(MD5Util.toMD5("password").equals(
				"5f4dcc3b5aa765d61d8327deb882cf99"));
	}
}
