/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cakes;

import Utilities.StringUtilities;

/**
 *
 * @author carolina astolfo
 */
public abstract class Cake {
    private String flavour;
    private double price;
    private int weight;

    public Cake(){
        flavour = "chocolate";
    }
    
    public Cake(String flavour){
        this.flavour = flavour;
    }
    
    //protected keyword because only this package needs access to this methods
    protected void setFlavour(String flavour){
        this.flavour = flavour;
    }
    
    protected void setPrice(double price){
        this.price = price;
    }
    
    protected void setWeight(int weight){
        this.weight = weight;
    }
    
    public double getPrice(){
        return price;
    }
    
    public int getWeight(){
        return weight;
    }
    
    //abstract method to be implemented by children
    public abstract void calculatePrice();
    
    @Override
    public String toString(){
        String output = "$" + this.getPrice() + " for " + StringUtilities.formatString(flavour) +
                            " flavoured ";
        return output;
    }
}
