package com.goeckeler.visitor;

public interface Visitable
{
  void accept(final Visitor visitor);
}
