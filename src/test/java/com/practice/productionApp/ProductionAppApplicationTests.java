package com.practice.productionApp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.practice.productbooking.model.Production;
import com.practice.productbooking.repository.ProdRepository;
import com.practice.productbooking.service.ProdService;
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductionAppApplicationTests {

	@Autowired
	private ProdService service;
	
	@MockBean
	private ProdRepository repository;
	
	@Test
	public void  getAllProductsTest() {
		when(repository.findAll()).thenReturn(Stream.
				of(new Production("1","shoe","8",600,1,"footware"),
						new Production("2","adidascheppal","8",500,1,"footware")).collect(Collectors.toList()));
		assertEquals(2,service.getAllProducts().size());
	}
	
	@Test
	public void addTest() {
		Production product = new Production("1","shoe","8",600,1,"footware");
		when(repository.save(product)).thenReturn(product);
	}
	@Test
	public void deleteTest() {
		Production product= new Production("1","shoe","8",600,1,"footware");
		service.deleteProduct("1");
		verify(repository,times(1)).deleteById("1");
	}
	@Test
	public void updateTest() {
		Optional<Production> product = Optional.of(new Production("1","shoe","8",600,1,"footware"));
		Production prod= new Production("1","shoe","8",600,1,"footware");
		when(repository.findById("2")).thenReturn(product);
	}
	
}
