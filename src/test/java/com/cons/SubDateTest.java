package com.cons;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cons.utils.CustomDateUtils;

@SpringBootTest
class SubDateTest {

	@Test
	public void 해당년도의_일수_구하기() {
		assertEquals(0, CustomDateUtils.getYearDay(1));
		assertEquals(365, CustomDateUtils.getYearDay(2));
	}

	@Test
	public void _5년의_일수_구하기() {
		assertEquals(365 + 365 + 365 + 366, CustomDateUtils.getYearDay(5));
	}

	@Test
	public void 윤년체크() {
		assertTrue(CustomDateUtils.isLeafYear(0));
		assertFalse(CustomDateUtils.isLeafYear(1));
		assertTrue(CustomDateUtils.isLeafYear(4));
		assertTrue(CustomDateUtils.isLeafYear(1200));
		assertFalse(CustomDateUtils.isLeafYear(700));
	}

	@Test
	public void 해당월의_일수_구하기() {
		assertEquals(0, CustomDateUtils.getMonthDay(1, true));
		assertEquals(31, CustomDateUtils.getMonthDay(2, false));
		assertEquals(31 + 29, CustomDateUtils.getMonthDay(3, true));
		assertEquals(31 + 28, CustomDateUtils.getMonthDay(3, false));
	}

	@Test
	public void 특정일자의_총_일수_구하기() {
		assertEquals(1, CustomDateUtils.getTotalDay("00010101"));
		assertEquals(366, CustomDateUtils.getTotalDay("00020101"));
		assertEquals(4365, CustomDateUtils.getTotalDay("00121213"));
		assertEquals(738004, CustomDateUtils.getTotalDay("20210802"));
	}

	@Test
	public void 두_날짜의_차이_일자() {
		assertEquals(1, CustomDateUtils.subDate("20061231", "20070101"));
		assertEquals(31 + 28 + 30 + 31 + 14, CustomDateUtils.subDate("20070101", "20070515"));
		assertEquals(31 + 29 + 30 + 31 + 14, CustomDateUtils.subDate("20080101", "20080515"));
		assertEquals(3866, CustomDateUtils.subDate("20210802", "20110101"));
	}
}
