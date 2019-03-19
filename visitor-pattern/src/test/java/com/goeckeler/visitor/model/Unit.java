package com.goeckeler.visitor.model;

import com.goeckeler.visitor.Visitable;

public abstract class Unit implements Named, Visitable
{
  private String name;

  public Unit(final String name) {
    this.name = name;
  }

  @Override
  public final String getName() {
    return null == name ? "Secret Service" : name;
  }
}
