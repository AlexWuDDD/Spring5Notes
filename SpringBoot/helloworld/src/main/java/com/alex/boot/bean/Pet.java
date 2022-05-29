package com.alex.boot.bean;

import java.util.Objects;

public class Pet {
  private String name;

  public Pet() {
  }

  public Pet(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Pet name(String name) {
    setName(name);
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pet)) {
            return false;
        }
        Pet pet = (Pet) o;
        return Objects.equals(name, pet.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }

  @Override
  public String toString() {
    return "Pet{" +
      " name='" + getName() + "'" +
      "}";
  }

}
