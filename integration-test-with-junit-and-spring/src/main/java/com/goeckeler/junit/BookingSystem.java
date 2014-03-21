package com.goeckeler.junit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookingSystem
{
  private static final Logger LOG = LoggerFactory.getLogger(BookingSystem.class);

  public boolean isAvailable() {
    LOG.debug("Yes, system is up and running.");
    return true;
  }

  public boolean bookTraining() {
    LOG.debug("Will book your training.");
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      // don't care
    }
    LOG.debug("Go and visit Uncle Bob's.");
    return true;
  }
}
