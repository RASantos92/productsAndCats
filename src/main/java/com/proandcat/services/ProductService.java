package com.proandcat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proandcat.models.Cat;
import com.proandcat.models.Product;
import com.proandcat.repositorys.CatRepository;
import com.proandcat.repositorys.ProductRepository;

@Service
public class ProductService {

	private static ProductRepository productRepo;
	private static CatRepository catRepo;

	public ProductService(ProductRepository productRepo, CatRepository catRepo) {
		this.productRepo = productRepo;
		this.catRepo = catRepo;
	}

	public Product create(Product newProduct) {
		return productRepo.save(newProduct);
	}

	public Cat create(Cat newCat) {
		return catRepo.save(newCat);
	}

	public List<Product> getProducts() {
		return (List<Product>) productRepo.findAll();
	}

	public List<Cat> getCats() {
		return (List<Cat>) catRepo.findAll();
	}

	public Product getProduct(Long id) {
		Optional<Product> product = productRepo.findById(id);
		return product.isPresent() ? product.get() : null;
	}

	public Cat getCat(Long id) {
		Optional<Cat> cat = catRepo.findById(id);
		return cat.isPresent() ? cat.get() : null;
	}

	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}

	public Cat saveCat(Cat cat) {
		return catRepo.save(cat);
	}

}
