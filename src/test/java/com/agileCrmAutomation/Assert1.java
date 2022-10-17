package com.agileCrmAutomation;

import org.testng.Assert;

public class Assert1 {

	private static final String NULL = null;

	public static void main(String[] args) {
		String s1="Ankita";
		String s2="Ankita";
		//Assert.assertNotEquals(s1, s2, "failed");
		 s1="Ankita";
		 s2="Terkhedkar";
		//Assert.assertEquals(s1, s2, "failed");
		 s1="Ankita";
		 s2="Terkhedkar";
		//Assert.assertNotNull(s1, s2);
		 if(s1.equals(s2))
		 {
			 System.out.println("pass test case");
		 }
		 else
		 {
			 Assert.fail("test case failed");
		 }
	}
}