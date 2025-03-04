/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cakes;

import java.time.LocalDate;

/**
 *
 * @author carolina astolfo
 */
public class Cupcake extends Cake implements CakeDetailsInterface{
    private int count;
    private int ounces;
    private LocalDate orderDate;
    private LocalDate bestBefore;
    
    public Cupcake(String flavour, int count, int ounces)throws InvalidCupcakeCountException{
        super(flavour);
        int weight = count*ounces;
        super.setWeight(weight);
        setCount(count);
        this.ounces = ounces;
        orderDate = LocalDate.now();
        setBestBefore();
    }
    
    //setter throws custom exception
    public void setCount(int count) throws InvalidCupcakeCountException{
        if (count == 4 || count == 6){
            this.count = count;
        }else{
            this.count = 4;
            throw new InvalidCupcakeCountException();
        }
    }
    
    private void setBestBefore(){
        bestBefore = orderDate.plusDays(3);
    }
    
     
    //superclass abstract method implementation
    //calculater price and sets superclass field
    //called in OrderCake
    @Override
    public void calculatePrice(){
        double price = (2 * ounces) * count;
        super.setPrice(price);
    }
    
    //interface implementation
    @Override
    public String getCakeDetails(){
        return count + "ct, " + ounces + "oz Buttercream cupcakes and good till " + bestBefore;
    }
    
    @Override
    public String toString(){
        return super.toString() + this.getCakeDetails();
    }
}
