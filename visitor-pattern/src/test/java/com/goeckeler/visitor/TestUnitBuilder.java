package com.goeckeler.visitor;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import com.goeckeler.visitor.model.Unit;
import com.goeckeler.visitor.model.UnitBuilder;

class TestUnitBuilder
{

  @Test
  void testSingleEmployee() {
    final Unit singleEmployee = UnitBuilder.unit().withEmployee("Adrian").toUnit();
    assertThat(singleEmployee.toString(), is("Adrian"));
  }
}
