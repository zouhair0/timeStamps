package com.zmt.dateserviceTest;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.Date;

import org.junit.Test;

import com.zmt.dateservice.DateService;

public class DateTests {
	
	@Test
	public void dateShouldBeInIsoFormat() {
		assertEquals(DateService.isValid("2020-04-20T06:05:30Z"), true);
		assertEquals(DateService.isValid("2011-12-03T10:15:30+01:00[Europe/Paris]"), false);
	}
	
	@Test
	public void calculateTest1() throws ParseException {
		Date d1 = DateService.toDate("2020-04-20T06:05:30Z");
		Date d2 = DateService.toDate("2020-04-21T08:05:31Z");	
		
		assertEquals(DateService.calculate(d1,d2), "1 day, 2 hours, 0 minutes, 1 second" );
	}
	
	@Test
	public void calculateTest2() throws ParseException {
		Date d1 = DateService.toDate("2020-04-20T06:05:30Z");
		Date d2 = DateService.toDate("2020-04-20T06:06:33Z");	
		
		assertEquals(DateService.calculate(d1,d2), "1 minutes, 3 second" );
	}
	
}
