package com.home;

import java.util.List;

/**
 * TODO
 *
 * @author ahao 2020-08-21
 */
public class Lipstick {
   private Integer id;
   private String brand;
   private String name;
   private String imgs;
   private Double weight;
   private Double price;
   private List<Color> colors;
   private List<Comment> comments;

   public Lipstick() {
   }

   public Lipstick(Integer id, String brand, String name, String imgs, Double weight, Double price, List<Color> colors, List<Comment> comments) {
      this.id = id;
      this.brand = brand;
      this.name = name;
      this.imgs = imgs;
      this.weight = weight;
      this.price = price;
      this.colors = colors;
      this.comments = comments;
   }

   public Integer getId() {
      return this.id;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getName() {
      return this.name;
   }

   public String getImgs() {
      return this.imgs;
   }

   public Double getWeight() {
      return this.weight;
   }

   public Double getPrice() {
      return this.price;
   }

   public List<Color> getColors() {
      return this.colors;
   }

   public List<Comment> getComments() {
      return this.comments;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public void setBrand(String brand) {
      this.brand = brand;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setImgs(String imgs) {
      this.imgs = imgs;
   }

   public void setWeight(Double weight) {
      this.weight = weight;
   }

   public void setPrice(Double price) {
      this.price = price;
   }

   public void setColors(List<Color> colors) {
      this.colors = colors;
   }

   public void setComments(List<Comment> comments) {
      this.comments = comments;
   }

}
