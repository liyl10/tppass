/**
 * @filename StatisticsProjectServiceImplTest.java
 * @author liyilin
 * @date 2013-12-10
 * @vsersion 1.0
 * Copyright (C) 2013 辉盛科技发展责任有限公司
 */
package com.hopsun.tppas.api.statistics.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml"})
public class StatisticsProjectServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests{

	@Resource
	private StatisticsProjectServiceImpl statisticsProjectServiceImpl;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected=NullPointerException.class)
	public void testGetExportDatas() {
		statisticsProjectServiceImpl.getExportDatas(null);
	}
	
	@Test
	public void testGetExportDatas2() {
		Map<String,Object> param = new HashMap<String,Object>();
		List<Object> list = new ArrayList<Object>();
		
		list = statisticsProjectServiceImpl.getExportDatas(param);
		assertTrue(list.size() > 0);
	}

}

