package com.goeckeler.visitor.model;

import java.util.*;

import org.apache.commons.lang3.StringUtils;

import com.goeckeler.visitor.Visitor;

public class Department extends Unit
{
  private List<Unit> units = new ArrayList<>();
  private Employee manager;

  public Department(final String name) {
    super(name);
  }

  public void setManager(final Employee manager) {
    this.manager = manager;
  }

  public Employee getManager() {
    return manager;
  }

  public List<Unit> getUnits() {
    return Collections.unmodifiableList(units);
  }

  public boolean add(final Unit unit) {
    return units.add(unit);
  }

  public boolean addAll(final Collection<Unit> units) {
    return this.units.addAll(units);
  }

  @Override
  public void accept(final Visitor visitor) {
    visitor.visit(this);
  }

  @Override
  public String toString() {
    final StringBuilder string = new StringBuilder(StringUtils.defaultString(getName()));
    string.append(" {");
    getUnits().forEach(unit -> string.append(unit.toString()));
    string.append("}");
    return string.toString();
  }
}
