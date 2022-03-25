package demoQATest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Zebra {

@BeforeTest	
public void browser() {
	
	System.out.println("Excecute Browser");
}
	
@Parameters("Test")
@Test
public void test1(String a) {	
	System.out.println("Test 1 "+a);
}

@Test(groups="All")
public void test2() {
	System.out.println("Test 2");
}

@Test(groups={"Smoke","All"})
public void test3() {
	System.out.println("Test 3");
}

@AfterTest
public void close() {
	System.out.println("Browser Close");
}
	
}
