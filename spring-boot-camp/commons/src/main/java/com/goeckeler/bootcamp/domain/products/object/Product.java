package com.goeckeler.bootcamp.domain.products.object;

import static org.apache.commons.lang3.StringUtils.defaultIfBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product  implements Comparable<Product>

{
  @Id
  @GeneratedValue
  private Long id;

  @Column(length = 80)
  private String name;

  public Product() {
    this(null);
  }

  public Product(String name) {
    this.name = name;
  }

  @Override
  public int hashCode() {
    return toString().hashCode();
  }

  public String getName() {
    return defaultIfBlank(name, "(n/a)");
  }

  public void setName(final String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;

    if (!getClass().isAssignableFrom(other.getClass())) return false;

    Product that = (Product) other;
    return this.toString().equals(that.toString());
  }

  @Override
  public int compareTo(Product that) {
    if (that == null) return 1;
    if (this == that) return 0;
    return getName().compareToIgnoreCase(that.getName());
  }

  @Override
  public String toString() {
    return getName();
  }
}
