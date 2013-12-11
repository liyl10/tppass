/**
 * @filename StatisticsProjectDaoImplTest.java
 * @author liyilin
 * @date 2013-12-10
 * @vsersion 1.0
 * Copyright (C) 2013 辉盛科技发展责任有限公司
 */
package com.hopsun.tppas.api.statistics.dao.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.ExpectedException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml"})
public class StatisticsProjectDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests{

	@Resource()
	private StatisticsProjectDaoImpl statisticsProjectDaoImpl;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testQueryProjectInfo() {
		Map<String,Object> param = new HashMap<String,Object>();
		List<Object> list = new ArrayList<Object>();
		list = statisticsProjectDaoImpl.queryListinfo(param);
		assertTrue(list.size()==0);
	}
	
	@Test(expected=NullPointerException.class)
	public void testQueryProjectInfo2() {
		//Map<String,Object> param = new HashMap<String,Object>();
		List<Object> list = new ArrayList<Object>();
		list = statisticsProjectDaoImpl.queryListinfo(null);
		assertTrue(list.size()==8);
	}

	@Test
	@Ignore
	public void testGetTableInfo() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testQueryListinfo() {
		fail("Not yet implemented");
	}

}

