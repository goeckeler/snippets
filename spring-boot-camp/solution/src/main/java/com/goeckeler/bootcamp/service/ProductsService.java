package com.goeckeler.bootcamp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.goeckeler.bootcamp.domain.products.dao.ProductRepository;
import com.goeckeler.bootcamp.domain.products.object.Product;
import com.goeckeler.bootcamp.domain.products.object.Products;

@Component
public class ProductsService
{
  @Autowired
  private ProductRepository productRepository;
  
  public Products searchByArtist(final String artistName) {
    return new Products();
  }
  
  public Optional<Product> findBy(Long id) {
    return Optional.ofNullable(productRepository.findOne(id));
  }
}
