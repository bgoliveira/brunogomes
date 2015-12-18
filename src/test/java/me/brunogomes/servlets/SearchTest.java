package me.brunogomes.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import me.brunogomes.conf.AppWebConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppWebConfiguration.class})
@WebAppConfiguration
public class SearchTest 
{
	@Resource WebApplicationContext wac;
	
	@Test
	public void shouldTest() throws ServletException, IOException
	{
		
		Search servlet = new Search();
		
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(servlet,
			      wac.getServletContext());
		
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		servlet.doGet(request, response);
		
		Assert.assertTrue(response.getContentAsString().contains("search"));
	}

}
