package com.goeckeler.bootcamp.rest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goeckeler.bootcamp.domain.products.object.Product;
import com.goeckeler.bootcamp.domain.products.object.Products;
import com.goeckeler.bootcamp.service.ProductsService;

@RestController
@RequestMapping(value = "/products")
public class ProductsRestService
{
  @Autowired
  private ProductsService productsService;
  
  @RequestMapping(method = GET, value = "/search")
  public Products search(@RequestParam(value = "artist-name", required = false) String artistName) {
    return productsService.searchByArtist(artistName);
  }
  
  @RequestMapping(method = GET, value="/{id}")
  public Optional<Product> findById(@PathVariable Long id) {
    return productsService.findBy(id);
  }
}
