package com.goeckeler.bootcamp.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goeckeler.bootcamp.domain.object.Products;

@RestController
@RequestMapping(value = "/catalog")
public class CatalogRestService
{
  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public Products search(@RequestParam(value = "artist-name", required = false) String artistName) {
    return new Products();
  }
}
