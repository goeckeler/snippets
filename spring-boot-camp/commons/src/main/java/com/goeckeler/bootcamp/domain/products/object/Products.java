package com.goeckeler.bootcamp.domain.products.object;

import java.util.Set;

import com.goeckeler.bootcamp.common.object.EntitySet;

public class Products
  extends EntitySet<Product>
{
  private Set<Product> products;

  @Override
  protected Set<Product> data() {
    return products;
  }

  @Override
  protected void data(final Set<Product> products) {
    this.products = products;
  }
}
