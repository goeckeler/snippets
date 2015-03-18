package com.goeckeler.bootcamp.domain.products.object;

import static org.apache.commons.lang3.StringUtils.defaultIfBlank;

public class Products
{
  private String name;

  public String getName() {
    return defaultIfBlank(name, "products");
  }
}
