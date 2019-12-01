/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.Menu;
import java.io.*;

/**
 *
 * @author Moshira
 */
public class Ingredientsclass implements Serializable
{
    private static final long serialVersionUID = -8670040565420266061L;
    private String name;
    private double cost;
    private double quantity;
    private double dishQuantity;
    private String unit;

    public Ingredientsclass(String name, double cost, String unit, double quantity) {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
        this.unit = unit;
    }
    
    
    public Ingredientsclass(String ingredients, double cost) {
        this.name = ingredients;
        this.cost = cost;
    }

    public Ingredientsclass(String name, double cost, double quantity) {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    public double getDishQuantity() {
        return dishQuantity;
    }

    public void setDishQuantity(double dishQuantity) {
        this.dishQuantity = dishQuantity;
    }
    
    
    
    
}
