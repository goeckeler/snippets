package com.goeckeler.visitor.model;

import java.util.Stack;

public class UnitBuilder
{
  private Unit root;
  private Stack<Department> departments;

  private UnitBuilder() {
    departments = new Stack<>();
  }

  public static UnitBuilder unit() {
    return new UnitBuilder();
  }

  public Unit toUnit() {
    return root;
  }

  public UnitBuilder withEmployee(final String name) {
    if (root != null) {
      // A unit is either a department or a single person
      throw new IllegalArgumentException(String.format("Cannot make employee '%s' to supercede %s.", name, root));
    }

    root = new Employee(name);
    return this;
  }

  public UnitBuilder withContractor(final String name) {
    if (root != null) {
      // A unit is either a department or a single person
      throw new IllegalArgumentException(String.format("Cannot make contractor '%s' to supercede %s.", name, root));
    }

    root = new Contractor(name);
    return this;
  }

  public UnitBuilder withDepartment(final String name) {
    final Department current = new Department(name);
    if (root == null) {
      root = current;
      departments.push(current);
      return this;
    }

    if (departments.size() > 1) {
      departments.pop();
      final Department department = departments.peek();
      department.add(current);
      departments.push(current);
      return this;
    }

    throw new IllegalArgumentException(String.format("Cannot add department '%s' parallel to root %s.", name, root));
  }

  public UnitBuilder withSubDepartment(final String name) {
    final Department current = new Department(name);
    if (root == null) {
      root = current;
      departments.push(current);
      return this;
    }

    if (departments.size() > 0) {
      final Department department = departments.peek();
      department.add(current);
      departments.push(current);
      return this;
    }

    throw new IllegalArgumentException(String.format("Cannot add department '%s' to person %s.", name, root));
  }
}
