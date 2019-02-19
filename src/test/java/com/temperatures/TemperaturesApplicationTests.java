package com.temperatures;

import com.temperatures.service.TemperatureService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TemperaturesApplicationTests {

	@Autowired
	private TemperatureService tempService;

	@Test
	public void testGet() {
		resetTable();
		final String actual = tempService.getTemps().stream().map(i -> i.toStringNoDateNoId()).collect(Collectors.joining(","));
		final String expected = "{celsius: 35.5, fahrenheit:95.9}";
		Assert.assertEquals(actual,expected);
	}

	@Test
	public void testPost(){
		resetTable();
		Integer id = tempService.getTemps().get(0).getId();
		tempService.postTemp(id,21.0);
		final String actual = tempService.getTemps().stream().map(i -> i.toStringNoDateNoId()).collect(Collectors.joining(","));
		final String expected = "{celsius: 21.0, fahrenheit:69.8}";
		Assert.assertEquals(actual,expected);
	}

	@Test
	public void testDelete(){
		resetTable();
		Integer id = tempService.getTemps().get(0).getId();
		tempService.deleteTemp(id);
		final String actual = tempService.getTemps().stream().map(i -> i.toStringNoDateNoId()).collect(Collectors.joining(","));
		final String expected = "";
		Assert.assertEquals(actual,expected);
	}

	private void resetTable(){
		tempService.deleteAll();
		tempService.putTemp(35.5);
	}

}
