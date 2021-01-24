package com.productinfo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productinfo.Entity.Product;
import com.productinfo.Repository.ProductRepository;

import io.swagger.annotations.ApiOperation;

@RestController
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	@ApiOperation("THIS IS USED TO GET SINGLE DATA ")
	@GetMapping(value = "/getData/{id}", produces = { "Application/json" })
	public ResponseEntity<Product> getbyId(@PathVariable("id") Integer id) {

		Optional<Product> findById = productRepository.findById(id);
		Product product = findById.get();
		if (product.getProductId().equals(id)) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
	}

	@ApiOperation("THIS IS USED TO GET ALL DATA")
	@GetMapping(value = "/getTotalData", produces = { "Application/json" })
	public ResponseEntity<List<Product>> getTotalData() {
		List<Product> findAll = productRepository.findAll();
		return new ResponseEntity<>(findAll, HttpStatus.OK);
	}

	@ApiOperation("THIS IS USED TO SAVE DATA")
	@PostMapping(value = "/saveData", consumes = { "Application/json" })
	public ResponseEntity<Product> saveingData(@RequestBody Product product) {
		if (product.getProductId() != null) {
			Product productData = productRepository.save(product);

			return new ResponseEntity<Product>(productData, HttpStatus.CREATED);
		} else {
			return null;
		}
	}

	@ApiOperation("THIS IS USED TO UPDATE DATA")
	@PutMapping(value = "/updateData/{id}", consumes = { "APPLICATION/JSON" })
	public ResponseEntity<Product> updateData(@RequestBody Product product, @PathVariable("id") Integer id) {
		System.out.println("product object send from client to change :" + product);
		Optional<Product> findById = productRepository.findById(id);
		Product product2 = findById.get();
		System.out.println("product2 before update :" + product2);
		product2.setProductName(product.getProductName());
		System.out.println("product2 after update :" + product2);
		productRepository.save(product2);

		return new ResponseEntity<Product>(product, HttpStatus.CREATED);
	}

	@ApiOperation("THIS IS USED TO DELETE DATA")
	@DeleteMapping(value = "/deleteData/{id}")
	public ResponseEntity<String> deleteData(@RequestBody Product product,@PathVariable("id") Integer id) {
		productRepository.deleteById(id);
		String msg = "DATA IS DELETED :" + id;
		return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);

	}

}