package com.proandcat.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proandcat.models.Cat;
import com.proandcat.models.Product;
import com.proandcat.services.ProductService;

@Controller
public class ProductController {

	private static ProductService productServ;

	public ProductController(ProductService productServ) {
		this.productServ = productServ;
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newProduct", new Product());
		return "newProduct.jsp";
	}

	@PostMapping("/product/new")
	public String newProduct(@Valid @ModelAttribute("newProduct") Product newProduct, BindingResult result) {
		if (result.hasErrors()) {
			return "newProduct.jsp";
		} else {
			productServ.create(newProduct);
			return "redirect:/";
		}
	}

	@PostMapping("/cat/new")
	public String newCat(@Valid @ModelAttribute("newCat") Cat newCat, BindingResult result) {
		if (result.hasErrors()) {
			return "newCat.jsp";
		} else {
			productServ.create(newCat);
			return "redirect:/cat";
		}
	}

	@GetMapping("/cat")
	public String cat(Model model) {
		model.addAttribute("newCat", new Cat());
		return "newCat.jsp";
	}

	@GetMapping("/product/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		model.addAttribute("newCat", new Cat());
		model.addAttribute("allCats", productServ.getCats());
		model.addAttribute("product", productServ.getProduct(id));
		return "showProduct.jsp";
	}

	@GetMapping("/cat/{id}")
	public String showCat(@PathVariable("id") Long id, Model model) {
		model.addAttribute("newProduct", new Product());
		model.addAttribute("allProducts", productServ.getProducts());
		model.addAttribute("cat", productServ.getCat(id));
		return "showCat.jsp";
	}

	@PostMapping("add/cat")
	public String addCatToProduct(@RequestParam("productId") Long productId, @RequestParam("catId") Long catId) {
		Product product = productServ.getProduct(productId);
		Cat cat = productServ.getCat(catId);
		List<Cat> product_cats = product.getCats();
		product_cats.add(cat);
		productServ.saveProduct(product);
		return "redirect:/product/" + productId;
	}

	@PostMapping("add/product")
	public String addProductToCat(@RequestParam("productId") Long productId, @RequestParam("catId") Long catId) {
		Cat cat = productServ.getCat(catId);
		Product product = productServ.getProduct(productId);
		List<Product> product_cats = cat.getProducts();
		product_cats.add(product);
		productServ.saveCat(cat);
		return "redirect:/cat/" + catId;
	}
}
