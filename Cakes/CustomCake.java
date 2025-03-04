/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cakes;

/**
 *
 * @author carolina astolfo
 */
public class CustomCake extends Cake implements CakeDetailsInterface{
    private int numOfLayers;
    private int size;
    
    public CustomCake (String flavour, int layers, int size){
        super(flavour);
        int weight = size * 2;
        super.setWeight(weight);
        numOfLayers = layers;
        this.size = size;
    }
    
    //superclass abstract method implementation
    //calculater price and sets superclass field
    //called in OrderCake
    @Override
    public void calculatePrice(){
        double price = BASE_PRICE + (numOfLayers * LAYER) + size;
        super.setPrice(price);
    }
    
    //interface implementation
    @Override
    public String getCakeDetails(){
        return "cake with " + numOfLayers + " layers and size is " + size +
                " inches";
    }
    
    @Override
    public String toString(){
        return super.toString() + this.getCakeDetails();
    }
}
