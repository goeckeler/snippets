package com.goeckeler.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookingSystemPlainTest
{
  private BookingSystem bookingSystem = new BookingSystem();

  @Test
  public void testIsAvailable() {
    assertTrue(bookingSystem.isAvailable());
  }

  @Test
  public void testBookTraining() {
    assertTrue(bookingSystem.bookTraining());
  }
}
