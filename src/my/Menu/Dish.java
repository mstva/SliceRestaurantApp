/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.Menu;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author lap
 */
public class Dish implements Serializable 
{
    private static final long serialVersionUID = -6954215955802552673L;
    private ArrayList<Ingredientsclass> ingredients  = new ArrayList<Ingredientsclass>();
    private String name;
    private double price;
    private double quantity;

    public Dish(ArrayList<Ingredientsclass> ingredients, String name, double price) {
        
        this.ingredients = ingredients;
        this.name = name;
        this.price = price;
    }

    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Dish(String name, double price, double quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public ArrayList<Ingredientsclass> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredientsclass> ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    
    public void addIngredient(Ingredientsclass ingredient) {
        this.ingredients.add(ingredient);
    }

    
    
    
}
