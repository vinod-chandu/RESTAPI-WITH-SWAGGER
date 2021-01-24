package com.productinfo.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productinfo.Entity.Product;

public interface ProductRepository  extends JpaRepository<Product,Serializable>{

}
