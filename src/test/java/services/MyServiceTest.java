package services;

import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import me.brunogomes.conf.AppWebConfiguration;
import me.brunogomes.daos.ProductDao;
import me.brunogomes.models.Product;
import me.brunogomes.services.MyService;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {AppWebConfiguration.class})
public class MyServiceTest {
	
	@Mock private ProductDao productDao;
	
	private MyService myService;
	
	@Before
	public void setUp() throws Exception {
	
	    
	    Product product = new Product();
	    
	    myService = new MyService(productDao);
	    
	    product.setDescription("bla bla");
	    
	    product.setName("test");
	    when(productDao.findAll()).thenReturn(Collections.singletonList(product));   
	}
	
	@Test
	public void deveCaaregarContexto() {
		Assert.assertNotNull(myService.getProducts());
	}
	

}
