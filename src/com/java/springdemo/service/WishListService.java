package com.java.springdemo.service;

import java.util.List;
import com.java.springdemo.entity.WishList;

public interface WishListService {

  List<WishList> getWishListItems(String username);
  public void removeFromWishList(String username, int productId);
}
