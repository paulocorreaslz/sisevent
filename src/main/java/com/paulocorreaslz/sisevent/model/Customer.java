package com.paulocorreaslz.sisevent.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 
@Entity
@Table(name = "customer")
public class Customer {
 
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
 
  @Column(name = "name")
  private String name;
 
  @Column(name = "age")
  private int age;
 
  @Column(name = "active")
  private boolean active;
 
  @OneToOne
  private Address address;
  
  public Customer() {
  }
 
  public Customer(String name, int age) {
    this.name = name;
    this.age = age;
    this.active = false;
  }
 
  public long getId() {
    return id;
  }
 
  public void setName(String name) {
    this.name = name;
  }
 
  public String getName() {
    return this.name;
  }
 
  public void setAge(int age) {
    this.age = age;
  }
 
  public int getAge() {
    return this.age;
  }
 
  public boolean isActive() {
    return active;
  }
 
  public void setActive(boolean active) {
    this.active = active;
  }
 
  public Address getAddress() {
	return address;
  }

  public void setAddress(Address address) {
	this.address = address;
  }

  @Override
  public String toString() {
    return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", active=" + active + "]";
  }
}