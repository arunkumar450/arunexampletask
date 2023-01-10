package com.practice.productbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.productbooking.model.Production;
import com.practice.productbooking.service.ProdService;

@RestController

@RequestMapping("products")
public class ProdController {
	@Autowired
	private ProdService prodService;

	@PostMapping("/add")
	public void addDetails(@RequestBody Production product) {
	prodService.addProduct(product);
	}

	@GetMapping("/list")
	public List<Production> getAllProducts() {
			return prodService.getAllProducts();
	}

	@GetMapping("getproduct/{prodId}")
	public Production getProduct (@PathVariable String prodId) {
			return prodService.getProduct(prodId);
	}

	@DeleteMapping("deleteproduct/{prodId}")
	public void deleteProduct (@PathVariable String prodId) {
			prodService.deleteProduct(prodId);
	}

	@PutMapping("/update/{prodId}")
	public Production updateProduct(@RequestBody Production product) throws NotFoundException {
			return prodService.updateProduct(product);
		}

}
