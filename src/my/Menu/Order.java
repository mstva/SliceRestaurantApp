/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.Menu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author lap
 */
public class Order implements Serializable
{
    
    private ArrayList<Dish> dishes = new ArrayList<Dish>();
    private double totalPrice;
    private String date;

    public Order(ArrayList<Dish> dishes, String date) {
        this.dishes = dishes;
        this.date = date;
    }

    public Order(String date) {
        this.date = date;
    }
    
    

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(ArrayList<Dish> dishes) {
        this.dishes = dishes;
    }
    
    public void addDish(Dish dish) {
        this.dishes.add(dish);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public void removeDish(int index) {
        try {
            this.dishes.remove(index);
        }
        catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void clearDishes() {
        this.dishes.clear();
    }
     
    
}
