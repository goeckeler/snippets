package com.goeckeler.junit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/spring-test-default.xml" })
public class BookingSystemFullTest
{
  private BookingSystem bookingSystem = new BookingSystem();

  @Test
  public void testIsAvailable() {
    assertTrue(bookingSystem.isAvailable());
  }

  @Test
  @IfProfileValue(name = "junit.stage", value = "integration")
  public void testBookTraining() {
    assertTrue(bookingSystem.bookTraining());
  }

  @Test
  @Ignore
  @IfProfileValue(name = "junit.stage", values = {
    "integration", "production", "nightly"
  })
  public void testExternalBookingSystem() {
    fail("Did not bother to code this.");
  }

  @Test
  @Ignore
  @IfProfileValue(name = "junit.stage", value = "driver.profile.memory")
  public void testMemoryConsumption() {
    fail("Did not bother to code this.");
  }
}
