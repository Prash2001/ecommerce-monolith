package com.java.springdemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "cart")
@Table(name = "cart")
public class Cart {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
//  @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
//  @JoinColumn(name = "user_id", referencedColumnName = "username")
//  private User user;
  
  @Column(name = "user_id")
  private String userId;


  public Cart() {}



  public Cart(String userId) {
    this.userId = userId;
  }


//public User getUser() {
//  return user;
//}
//
//public void setUser(User theUser) {
//  this.user = theUser;
//}
  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }

//
//
//  /**
//   * @return
//   * @see com.java.springdemo.entity.User#getProducts()
//   */
//  public List<Product> getProducts() {
//    return user.getProducts();
//  }
//
//
//
//  /**
//   * @param products
//   * @see com.java.springdemo.entity.User#setProducts(java.util.List)
//   */
//  public void setProducts(List<Product> products) {
//    user.setProducts(products);
//  }
//
//
//
//  /**
//   * @return
//   * @see java.lang.Object#hashCode()
//   */
//  public int hashCode() {
//    return user.hashCode();
//  }
//
//
//
//  /**
//   * @return
//   * @see com.java.springdemo.entity.User#getCart()
//   */
//  public Cart getCart() {
//    return user.getCart();
//  }
//
//
//
//  /**
//   * @param cart
//   * @see com.java.springdemo.entity.User#setCart(com.java.springdemo.entity.Cart)
//   */
//  public void setCart(Cart cart) {
//    user.setCart(cart);
//  }
//
//
//
//  /**
//   * @return
//   * @see com.java.springdemo.entity.User#getUsername()
//   */
//  public String getUsername() {
//    return user.getUsername();
//  }
//
//
//
//  /**
//   * @param username
//   * @see com.java.springdemo.entity.User#setUsername(java.lang.String)
//   */
//  public void setUsername(String username) {
//    user.setUsername(username);
//  }
//
//
//
//  /**
//   * @return
//   * @see com.java.springdemo.entity.User#getPassword()
//   */
//  public String getPassword() {
//    return user.getPassword();
//  }
//
//
//
//  /**
//   * @param password
//   * @see com.java.springdemo.entity.User#setPassword(java.lang.String)
//   */
//  public void setPassword(String password) {
//    user.setPassword(password);
//  }
//
//
//
//  /**
//   * @return
//   * @see com.java.springdemo.entity.User#getFirstName()
//   */
//  public String getFirstName() {
//    return user.getFirstName();
//  }
//
//
//
//  /**
//   * @param firstName
//   * @see com.java.springdemo.entity.User#setFirstName(java.lang.String)
//   */
//  public void setFirstName(String firstName) {
//    user.setFirstName(firstName);
//  }
//
//
//
//  /**
//   * @return
//   * @see com.java.springdemo.entity.User#getLastName()
//   */
//  public String getLastName() {
//    return user.getLastName();
//  }
//
//
//
//  /**
//   * @param lastName
//   * @see com.java.springdemo.entity.User#setLastName(java.lang.String)
//   */
//  public void setLastName(String lastName) {
//    user.setLastName(lastName);
//  }
//
//
//
//  /**
//   * @return
//   * @see com.java.springdemo.entity.User#getContact()
//   */
//  public String getContact() {
//    return user.getContact();
//  }
//
//
//
//  /**
//   * @param contact
//   * @see com.java.springdemo.entity.User#setContact(java.lang.String)
//   */
//  public void setContact(String contact) {
//    user.setContact(contact);
//  }
//
//
//
//  /**
//   * @return
//   * @see com.java.springdemo.entity.User#getEmail()
//   */
//  public String getEmail() {
//    return user.getEmail();
//  }
//
//
//
//  /**
//   * @param email
//   * @see com.java.springdemo.entity.User#setEmail(java.lang.String)
//   */
//  public void setEmail(String email) {
//    user.setEmail(email);
//  }
//
//
//
//  /**
//   * @param obj
//   * @return
//   * @see java.lang.Object#equals(java.lang.Object)
//   */
//  public boolean equals(Object obj) {
//    return user.equals(obj);
//  }
//
//
//
//  /**
//   * @param product
//   * @see com.java.springdemo.entity.User#addProduct(com.java.springdemo.entity.Product)
//   */
//  public void addProduct(Product product) {
//    user.addProduct(product);
//  }
//
//

  @Override
  public String toString() {
    return "Cart [id=" + id + ", userId"+ userId+"]";
  }



  /**
   * @return the userId
   */
  public String getUserId() {
    return userId;
  }



  /**
   * @param userId the userId to set
   */
  public void setUserId(String userId) {
    this.userId = userId;
  }





}
