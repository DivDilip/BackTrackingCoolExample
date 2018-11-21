package com.dialpad;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class LotteryExtTest {
	private LotteryExt obj=new LotteryExt();
	
	@Test
	public void test() {
	 System.out.println(Arrays.toString(obj.parseStringToIntArray("4938532894754").toArray()));
	}
	@Test
	public void test1() {
	 
	 System.out.println(Arrays.toString(obj.parseStringToIntArray("1234567").toArray()));
	}
	
	@Test
	public void test2() {
	 System.out.println(Arrays.toString(obj.parseStringToIntArray("912934567").toArray()));
	}
	@Test
	public void test3() {
	 System.out.println(Arrays.toString(obj.parseStringToIntArray("9912934567").toArray()));
	}
	
	@Test
	public void test4() {
	 System.out.println(Arrays.toString(obj.parseStringToIntArray("9129231394").toArray()));
	}
	@Test
	public void test5() {
	 System.out.println(Arrays.toString(obj.parseStringToIntArray("1212612345").toArray()));
	}

}
