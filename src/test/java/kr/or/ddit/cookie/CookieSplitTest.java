package kr.or.ddit.cookie;

import static org.junit.Assert.*;

import org.junit.Test;

public class CookieSplitTest {

	
	@Test
	public void getCookieValueSuccessTest() {
		/***Given***/
		CookieSplit cookie = new CookieSplit();

		/***When***/
		String name = cookie.getCookieValue("USERNM");
		/***Then***/
		assertEquals(name, "brown");
	}
	
	@Test
	public void getCookieValueFailTest() {
		/***Given***/
		CookieSplit cookie = new CookieSplit();
		
		/***When***/
		String name = cookie.getCookieValue("PASSWORD");
		/***Then***/
		assertEquals(name, "");
	}

}
