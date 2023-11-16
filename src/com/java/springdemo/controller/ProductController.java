package com.java.springdemo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.java.springdemo.entity.Product;
import com.java.springdemo.entity.User;
import com.java.springdemo.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
  @Autowired
  private ProductService productService;
  @GetMapping("/showAddProductForm")
  public String showAddProductForm(Model model) {
    return "add-product";
  }

  @GetMapping("/getProducts")
  synchronized public String getProducts(@RequestParam("section") @Validated String section, Model model,
       HttpSession session) {
    User sessionUser = (User) session.getAttribute("gandva");
//    String section = (String) session.getAttribute("section");
    List<Product> theProducts = productService.getProducts(section);
    if(sessionUser==null) {
      return "redirect:/user/login";
    }
    
    if (theProducts.size() > 0) {  
      model.addAttribute("products", theProducts);
      model.addAttribute("user",sessionUser);
      model.addAttribute("section",section);
    }
    return "index";
  }

  @GetMapping("/getProductById")
  public String getProductById(@ModelAttribute("id") @Validated int id, Model model,
      RedirectAttributes redirectAttributes) {
    Product theProduct = productService.getProductById(id);
    if (theProduct != null) {
      System.out.println(theProduct);
      model.addAttribute("product", theProduct);

      redirectAttributes.addFlashAttribute("product", theProduct);
    }
    return "redirect:/user/addWishListItem";
  }

  @Autowired
  ServletContext context;

  

  @GetMapping("/addToWishList")
  public String addToWishList(Model model) {
    return "add-to-wishlist";
  }

  @GetMapping("/searchProducts")
  public String searchProducts(@ModelAttribute("searchString") @Validated String searchString, Model model, HttpSession session) {
    System.out.println("This is searchString"+searchString);
    User sessionUser = (User) session.getAttribute("gandva");
    List<Product> theProducts = productService.searchProducts(searchString);
    System.out.println("Found this Products --> "+theProducts);
    if(sessionUser==null) {
      return "redirect:/user/login";
    }
    
    if (theProducts.size() > 0) {  
      model.addAttribute("products", theProducts);
      model.addAttribute("user",sessionUser);
    }
    return "index";
  }
  

  @PostMapping("/insertProduct")
  public String saveProduct(@RequestParam("productName") @Validated String productName, @RequestParam("productDetails") @Validated String productDetails,@RequestParam("brand") @Validated String brand, @RequestParam("uploadImage") @Validated MultipartFile file, @RequestParam("price") @Validated int price, @RequestParam("discount") @Validated int discount, @RequestParam("section") @Validated String section) {
    Product prod = new Product();
    prod.setName(productName);
    prod.setProductDetails(productDetails);
    prod.setBrand(brand);
    prod.setImageName(file.getOriginalFilename());
    prod.setPrice(price);
    prod.setDiscount(String.valueOf(discount));
    prod.setSection(section);
    try {
      System.out.println("Uploaded");
      
      prod.setImageData(file.getBytes());
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    productService.saveProduct(prod);
//    String uploadPath =
//        "C:\\Users\\prashantjapkar\\git\\spring\\projects\\ecom-demo-01\\WebContent\\resources\\img\\";
//    // Now do something with file...
//    try {
//      FileCopyUtils.copy(file.getBytes(),
//          new File(uploadPath + file.getOriginalFilename()));
//    } catch (IOException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }
    return "redirect:/product/showAddProductForm";
  }
  @GetMapping("/setSession")
  synchronized public String setSession(@RequestParam("section") @Validated String section, Model model, HttpSession session) {
    session.setAttribute("section", section);
    
    return "redirect:product/getProducts";
  }
}
