package com.goeckeler.visitor.model;

import org.apache.commons.lang3.StringUtils;

import com.goeckeler.visitor.Visitor;

public class Employee extends Unit
{

  public Employee(final String name) {
    super(name);
  }

  @Override
  public void accept(final Visitor visitor) {
    visitor.visit(this);
  }

  @Override
  public String toString() {
    return StringUtils.defaultString(getName());
  }
}
