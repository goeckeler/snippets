package com.goeckeler.producer;

import java.util.Objects;

public class Message
{
  private int source;
  private int value;

  public Message(int source, int value) {
    this.source = source;
    this.value = value;
  }

  public int source() {
    return source;
  }

  public int value() {
    return value;
  }

  @Override
  public String toString() {
    return String.format("p%2d:%d", source, value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(source, value);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Message other = (Message) obj;
    return source == other.source && value == other.value;
  }
}
