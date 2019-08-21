package domain;


import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vimal
 */
public class Details  implements Comparator<Details>{
    String category;
    String iteam;
    Integer totalPrice;
    Integer rating;

    public Details(String category, String iteam, Integer totalPrice, Integer rating) {
        this.category = category;
        this.iteam = iteam;
        this.totalPrice = totalPrice;
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIteam() {
        return iteam;
    }

    public void setIteam(String iteam) {
        this.iteam = iteam;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public int compare(Details o1, Details o2) {
       return o1.getRating().compareTo(o2.getRating());
    }
    
    
}
