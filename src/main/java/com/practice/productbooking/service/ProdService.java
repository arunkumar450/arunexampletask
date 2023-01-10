package com.practice.productbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.practice.productbooking.model.Production;
import com.practice.productbooking.repository.ProdRepository;

@Service

public class ProdService {
	@Autowired
	private ProdRepository prodRepository;
	public void addProduct(Production product) {
		prodRepository.save(product);
	}
	public List<Production> getAllProducts(){
		return prodRepository.findAll();
	}
	public Production getProduct(String prodId) {
		return prodRepository.findById(prodId).get();
	}
	public void deleteProduct(String prodId) {
		prodRepository.deleteById(prodId);
	}
	public Production updateProduct(Production product) throws NotFoundException{
	if(product.getProdId()==null) {
		throw new NotFoundException();
	}
	Optional<Production> optionallProduct = prodRepository.findById(product.getProdId());
	if(!optionallProduct.isPresent()) {
		throw new NotFoundException();
	}
	Production products= optionallProduct.get();
	products.setProdName(product.getProdName());
	products.setProdSize(product.getProdSize());
	products.setProdCost(product.getProdCost());
	products.setQuantity(product.getQuantity());
	products.setType(product.getType());
	return prodRepository.save(products);
}
}
