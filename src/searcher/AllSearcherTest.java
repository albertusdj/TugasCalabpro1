package searcher;

import static org.junit.Assert.*;


import org.junit.Test;

public class AllSearcherTest {
	@Test
	public void EmailSearcherTest(){
		EmailSearcher test = new EmailSearcher("tom");
		assertEquals("https://api.github.com/search/users?q=tom+in%3Aemail&type=Users", test.getUrl());
	}
	
	@Test
	public void EmailSearcherFilterFollowerMaxTest() {
		EmailSearcherFilterFollowerMax test = new EmailSearcherFilterFollowerMax("tom", 20);
		assertEquals("https://api.github.com/search/users?q=tom+in%3Aemail+followers:%3C20&type=Users", test.getUrl());
	}
	
	@Test
	public void EmailSearcherFilterFollowerMinTest(){
		EmailSearcherFilterFollowerMin test = new EmailSearcherFilterFollowerMin("tom", 5);
		assertEquals("https://api.github.com/search/users?q=tom+in%3Aemail+followers:%3E5&type=Users", test.getUrl());
	}
	
	@Test
	public void EmailSearcherFilterFollowerMinMaxTest(){
		EmailSearcherFilterFollowerMinMax test = new EmailSearcherFilterFollowerMinMax("tom", 1, 5);
		assertEquals("https://api.github.com/search/users?q=tom+in%3Aemail+followers%3A1..5&type=Users", test.getUrl());
	}
	
	@Test
	public void EmailSearcherFilterRepoMaxTest(){
		EmailSearcherFilterRepoMax test = new EmailSearcherFilterRepoMax("tom", 4);
		assertEquals("https://api.github.com/search/users?q=tom+in%3Aemail+repos:%3C4&type=Users", test.getUrl());
	}
	
	@Test
	public void EmailSearcherFilterRepoMaxFollowerMaxtest() {
		EmailSearcherFilterRepoMaxFollowerMax test = new EmailSearcherFilterRepoMaxFollowerMax("tom", 10, 10);
		assertEquals("https://api.github.com/search/users?q=tom+in%3Aemail+repos:%3C10+followers:%3C10&type=Users", test.getUrl());
	}

	@Test
	public void EmailSearcherFilterRepoMaxFollowerMinTest(){
		EmailSearcherFilterRepoMaxFollowerMin test = new EmailSearcherFilterRepoMaxFollowerMin("tom", 5, 5);
		assertEquals("https://api.github.com/search/users?q=tom+in%3Aemail+repos:%3C5+followers:%3E5&type=Users", test.getUrl());
	}
	
	@Test
	public void EmailSearcherFilterRepoMaxFollowerMinMaxTest(){
		EmailSearcherFilterRepoMaxFollowerMinMax test = new EmailSearcherFilterRepoMaxFollowerMinMax("lau", 10, 1, 5);
		assertEquals("https://api.github.com/search/users?q=lau+in%3Aemail+repos:%3C10+followers%3A1..5&type=Users", test.getUrl());
	}
	
	@Test
	public void EmailSearcherFilterRepoMinTest(){
		EmailSearcherFilterRepoMin test = new EmailSearcherFilterRepoMin("lau", 5);
		assertEquals("https://api.github.com/search/users?q=lau+in%3Aemail+repos:%3E5&type=Users", test.getUrl());
	}
	
	@Test
	public void EmailSearcherFilterRepoMinFollowerMaxTest(){
		EmailSearcherFilterRepoMinFollowerMax test = new EmailSearcherFilterRepoMinFollowerMax("lau", 5, 5);
		assertEquals("https://api.github.com/search/users?q=lau+in%3Aemail+repos:%3E5+followers:%3C5&type=Users", test.getUrl());
	}
	
	@Test
	public void EmailSearcherFilterRepoMinFollowerMinTest(){
		EmailSearcherFilterRepoMinFollowerMin test = new EmailSearcherFilterRepoMinFollowerMin("lau", 5, 5);
		assertEquals("https://api.github.com/search/users?q=lau+in%3Aemail+repos:%3E5+followers:%3E5&type=Users", test.getUrl());
	}
	
	@Test
	public void EmailSearcherFilterRepoMinFollowerMinMaxTest(){
		EmailSearcherFilterRepoMinFollowerMinMax test = new EmailSearcherFilterRepoMinFollowerMinMax("lau", 5, 1, 5);
		assertEquals("https://api.github.com/search/users?q=lau+in%3Aemail+repos:%3E5+followers%3A1..5&type=Users", test.getUrl());
	}
	
	@Test
	public void EmailSearcherFilterRepoMinMaxTest(){
		EmailSearcherFilterRepoMinMax test = new EmailSearcherFilterRepoMinMax("lau", 1, 5);
		assertEquals("https://api.github.com/search/users?q=lau+in%3Aemail+repos%3A1..5&type=Users", test.getUrl());
	}
	
	@Test
	public void EmailSearcherFilterRepoMinMaxFollowerMaxTest(){
		EmailSearcherFilterRepoMinMaxFollowerMax test = new EmailSearcherFilterRepoMinMaxFollowerMax("lau", 1, 5, 5);
		assertEquals("https://api.github.com/search/users?q=lau+in%3Aemail+repos%3A1..5+followers:%3C5&type=Users", test.getUrl());
	}
	
	@Test
	public void EmailSearcherFilterRepoMinMaxFollowerMinTest(){
		EmailSearcherFilterRepoMinMaxFollowerMin test = new EmailSearcherFilterRepoMinMaxFollowerMin("lau", 1, 5, 1);
		assertEquals("https://api.github.com/search/users?q=lau+in%3Aemail+repos%3A1..5+followers:%3E1&type=Users", test.getUrl());
	}
	
	@Test
	public void EmailSearcherFilterRepoMinMaxFollowerMinMaxTest(){
		EmailSearcherFilterRepoMinMaxFollowerMinMax test = new EmailSearcherFilterRepoMinMaxFollowerMinMax("lau", 1, 5, 1, 5);
		assertEquals("https://api.github.com/search/users?q=lau+in%3Aemail+repos%3A1..5+followers%3A1..5&type=Users", test.getUrl());
	}
	
	@Test
	public void FullNameSearcherTest(){
		FullNameSearcher test = new FullNameSearcher("john");
		assertEquals("https://api.github.com/search/users?q=john+in%3AfullName&type=Users", test.getUrl());
	}
	
	@Test
	public void FullNameSearcherFilterFollowerMaxTest(){
		FullNameSearcherFilterFollowerMax test = new FullNameSearcherFilterFollowerMax("john", 10);
		assertEquals("https://api.github.com/search/users?q=john+in%3AfullName+followers:%3C10&type=Users", test.getUrl());
	}
	
	@Test
	public void FullNameSearcherFilterFollowerMinTest(){
		FullNameSearcherFilterFollowerMin test = new FullNameSearcherFilterFollowerMin("john", 5);
		assertEquals("https://api.github.com/search/users?q=john+in%3AfullName+followers:%3E5&type=Users", test.getUrl());
	}
	
	@Test
	public void FullNameSearcherFilterFollowerMinMaxTest(){
		FullNameSearcherFilterFollowerMinMax test = new FullNameSearcherFilterFollowerMinMax("john", 1, 5);
		assertEquals("https://api.github.com/search/users?q=john+in%3AfullName+followers%3A1..5&type=Users", test.getUrl());
	}
	
	@Test
	public void FullNameSearcherFilterRepoMaxTest(){
		FullNameSearcherFilterRepoMax test = new FullNameSearcherFilterRepoMax("john", 5);
		assertEquals("https://api.github.com/search/users?q=john+in%3AfullName+repos:%3C5&type=Users", test.getUrl());
	}
	
	@Test
	public void FullNameSearcherFilterRepoMaxFollowerMaxTest(){
		FullNameSearcherFilterRepoMaxFollowerMax test = new FullNameSearcherFilterRepoMaxFollowerMax("john", 5, 5);
		assertEquals("https://api.github.com/search/users?q=john+in%3AfullName+repos:%3C5+followers:%3C5&type=Users", test.getUrl());
	}
	
	@Test
	public void FullNameSearcherFilterRepoMaxFollowerMinTest(){
		FullNameSearcherFilterRepoMaxFollowerMin test = new FullNameSearcherFilterRepoMaxFollowerMin("john", 5, 1);
		assertEquals("https://api.github.com/search/users?q=john+in%3AfullName+repos:%3C5+followers:%3E1&type=Users", test.getUrl());
	}
	
	@Test
	public void FullNameSearcherFilterRepoMaxFollowerMinMaxTest(){
		FullNameSearcherFilterRepoMaxFollowerMinMax test = new FullNameSearcherFilterRepoMaxFollowerMinMax("john", 5, 1, 5);
		assertEquals("https://api.github.com/search/users?q=john+in%3AfullName+repos:%3C5+followers%3A1..5&type=Users", test.getUrl());
	}
	
	@Test
	public void FullNameSearcherFilterRepoMinTest(){
		FullNameSearcherFilterRepoMin test = new FullNameSearcherFilterRepoMin("john", 5);
		assertEquals("https://api.github.com/search/users?q=john+in%3AfullName+repos:%3E5&type=Users", test.getUrl());
	}
	
	@Test
	public void FullNameSearcherFilterRepoMinFollowerMaxTest(){
		FullNameSearcherFilterRepoMinFollowerMax test = new FullNameSearcherFilterRepoMinFollowerMax("john", 5, 5);
		assertEquals("https://api.github.com/search/users?q=john+in%3AfullName+repos:%3E5+followers:%3C5&type=Users", test.getUrl());
	}
	
	@Test
	public void FullNameSearcherFilterRepoMinFollowerMinTest(){
		FullNameSearcherFilterRepoMinFollowerMin test = new FullNameSearcherFilterRepoMinFollowerMin("john", 5, 5);
		assertEquals("https://api.github.com/search/users?q=john+in%3AfullName+repos:%3E5+followers:%3E5&type=Users", test.getUrl());
	}
	
	@Test
	public void FullNameSearcherFilterRepoMinFollowerMinMaxTest(){
		FullNameSearcherFilterRepoMinFollowerMinMax test = new FullNameSearcherFilterRepoMinFollowerMinMax("john", 5, 1, 5);
		assertEquals("https://api.github.com/search/users?q=john+in%3AfullName+repos:%3E5+followers%3A1..5&type=Users", test.getUrl());
	}
	
	@Test
	public void FullNameSearcherFilterRepoMinMaxTest(){
		FullNameSearcherFilterRepoMinMax test = new FullNameSearcherFilterRepoMinMax("john", 1, 5);
		assertEquals("https://api.github.com/search/users?q=john+in%3AfullName+repos%3A1..5&type=Users", test.getUrl());
	}
	
	@Test
	public void FullNameSearcherFilterRepoMinMaxFollowerMaxTest(){
		FullNameSearcherFilterRepoMinMaxFollowerMax test = new FullNameSearcherFilterRepoMinMaxFollowerMax("john", 1, 5, 5);
		assertEquals("https://api.github.com/search/users?q=john+in%3AfullName+repos%3A1..5+followers:%3C5&type=Users", test.getUrl());
	}
	
	@Test
	public void FullNameSearcherFilterRepoMinMaxFollowerMinTest(){
		FullNameSearcherFilterRepoMinMaxFollowerMin test = new FullNameSearcherFilterRepoMinMaxFollowerMin("john", 1, 5, 5);
		assertEquals("https://api.github.com/search/users?q=john+in%3AfullName+repos%3A1..5+followers:%3E5&type=Users", test.getUrl());
	}
	
	@Test
	public void FullNameSearcherFilterRepoMinMaxFollowerMinMaxTest(){
		FullNameSearcherFilterRepoMinMaxFollowerMinMax test = new FullNameSearcherFilterRepoMinMaxFollowerMinMax("john", 1, 5, 1, 5);
		assertEquals("https://api.github.com/search/users?q=john+in%3AfullName+repos%3A1..5+followers%3A1..5&type=Users", test.getUrl());
	}
	
	@Test
	public void UserNameSearcherTest(){
		UserNameSearcher test = new UserNameSearcher("smith");
		assertEquals("https://api.github.com/search/users?q=smith+in%3Alogin&type=Users", test.getUrl());
	}
	
	@Test
	public void UserNameSearcherFilterFollowerMaxTest(){
		UserNameSearcherFilterFollowerMax test = new UserNameSearcherFilterFollowerMax("smith", 5);
		assertEquals("https://api.github.com/search/users?q=smith+in%3Alogin+followers:%3C5&type=Users", test.getUrl());
	}
	
	@Test
	public void UserNameSearcherFilterFollowerMinTest(){
		UserNameSearcherFilterFollowerMin test = new UserNameSearcherFilterFollowerMin("smith", 5);
		assertEquals("https://api.github.com/search/users?q=smith+in%3Alogin+followers:%3E5&type=Users", test.getUrl());
	}
	
	@Test
	public void UserNameSearcherFilterFollowerMinMaxTest(){
		UserNameSearcherFilterFollowerMinMax test = new UserNameSearcherFilterFollowerMinMax("smith", 1, 5);
		assertEquals("https://api.github.com/search/users?q=smith+in%3Alogin+followers%3A1..5&type=Users", test.getUrl());
	}
	
	@Test
	public void UserNameSearcherFilterRepoMaxTest(){
		UserNameSearcherFilterRepoMax test = new UserNameSearcherFilterRepoMax("smith", 5);
		assertEquals("https://api.github.com/search/users?q=smith+in%3Alogin+repos:%3C5&type=Users", test.getUrl());
	}
	
	@Test
	public void UserNameSearcherFilterRepoMaxFollowerMaxTest(){
		UserNameSearcherFilterRepoMaxFollowerMax test = new UserNameSearcherFilterRepoMaxFollowerMax("smith", 5, 5);
		assertEquals("https://api.github.com/search/users?q=smith+in%3Alogin+repo:%3C5+followers:%3C5&type=Users", test.getUrl());
	}
	
	@Test
	public void UserNameSearcherFilterRepoMaxFollowerMinTest(){
		UserNameSearcherFilterRepoMaxFollowerMin test = new UserNameSearcherFilterRepoMaxFollowerMin("smith", 5, 5);
		assertEquals("https://api.github.com/search/users?q=smith+in%3Alogin+repos:%3C5+followers:%3E5&type=Users", test.getUrl());
	}
	
	@Test
	public void UserNameSearcherFilterRepoMaxFollowerMinMaxTest(){
		UserNameSearcherFilterRepoMaxFollowerMinMax test = new UserNameSearcherFilterRepoMaxFollowerMinMax("smith", 5, 1, 5);
		assertEquals("https://api.github.com/search/users?q=smith+in%3Alogin+repos:%3C5+followers%3A1..5&type=Users", test.getUrl());
	}
	
	@Test
	public void UserNameSearcherFilterRepoMinTest(){
		UserNameSearcherFilterRepoMin test = new UserNameSearcherFilterRepoMin("smith", 5);
		assertEquals("https://api.github.com/search/users?q=smith+in%3Alogin+repos:%3E5&type=Users", test.getUrl());
	}
	
	@Test
	public void UserNameSearcherFilterRepoMinFollowerMaxTest(){
		UserNameSearcherFilterRepoMinFollowerMax test = new UserNameSearcherFilterRepoMinFollowerMax("smith", 5, 5);
		assertEquals("https://api.github.com/search/users?q=smith+in%3Alogin+repo:%3E5+followers:%3C5&type=Users", test.getUrl());
	}
	
	@Test
	public void UserNameSearcherFilterRepoMinFollowerMinTest(){
		UserNameSearcherFilterRepoMinFollowerMin test = new UserNameSearcherFilterRepoMinFollowerMin("smith", 5, 5);
		assertEquals("https://api.github.com/search/users?q=smith+in%3Alogin+repos:%3E5+followers:%3E5&type=Users", test.getUrl());
	}
	
	@Test
	public void UserNameSearcherFilterRepoMinFollowerMinMaxTest(){
		UserNameSearcherFilterRepoMinFollowerMinMax test = new UserNameSearcherFilterRepoMinFollowerMinMax("smith", 5, 1, 5);
		assertEquals("https://api.github.com/search/users?q=smith+in%3Alogin+repos:%3E5+followers%3A1..5&type=Users", test.getUrl());
	}
	
	@Test
	public void UserNameSearcherFilterRepoMinMaxTest(){
		UserNameSearcherFilterRepoMinMax test = new UserNameSearcherFilterRepoMinMax("smith", 1, 5);
		assertEquals("https://api.github.com/search/users?q=smith+in%3Alogin+repos%3A1..5&type=Users", test.getUrl());
	}
	
	@Test
	public void UserNameSearcherFilterRepoMinMaxFollowerMaxTest(){
		UserNameSearcherFilterRepoMinMaxFollowerMax test = new UserNameSearcherFilterRepoMinMaxFollowerMax("smith", 1, 5, 5);
		assertEquals("https://api.github.com/search/users?q=smith+in%3Alogin+repos%3A1..5+followers:%3C5&type=Users", test.getUrl());
	}
	
	@Test
	public void UserNameSearcherFilterRepoMinMaxFollowerMinTest(){
		UserNameSearcherFilterRepoMinMaxFollowerMin test = new UserNameSearcherFilterRepoMinMaxFollowerMin("smith", 1, 5, 5);
		assertEquals("https://api.github.com/search/users?q=smith+in%3Alogin+repos%3A1..5+followers:%3E5&type=Users", test.getUrl());
	}
	
	@Test
	public void UserNameSearcherFilterRepoMinMaxFollowerMinMaxTest(){
		UserNameSearcherFilterRepoMinMaxFollowerMinMax test = new UserNameSearcherFilterRepoMinMaxFollowerMinMax("smith", 1, 5, 1, 5);
		assertEquals("https://api.github.com/search/users?q=smith+in%3Alogin+repos%3A1..5+followers%3A1..5&type=Users", test.getUrl());
	}
}
