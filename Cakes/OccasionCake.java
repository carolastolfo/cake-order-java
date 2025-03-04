/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cakes;

/**
 *
 * @author carolina astolfo
 */
public class OccasionCake extends Cake implements CakeDetailsInterface {
    public String[][] cakeArray = {
            {"Holiday", "30"},
            {"Birthday", "40"},
            {"Anniversary", "50"},
            {"Wedding", "60"}
        };
    private String cakeName;
    private double price;
    
    //loops through 2d array to match 1st column 
    //then sets fields cakeName and price
    public OccasionCake(String flavour, String cakeType){
        super(flavour);
        super.setWeight(BASE_CAKE_WEIGHT);
        for (int i = 0; i < cakeArray.length; i++){
            if (cakeType.equalsIgnoreCase(cakeArray[i][0])){
                cakeName = cakeArray[i][0];
                price = Double.parseDouble(cakeArray[i][1]);
            }
        }
    }
    
    //superclass abstract method implementation
    //calculater price and sets superclass field
    //called in OrderCake
    @Override
    public void calculatePrice(){
        super.setPrice(price);
    }
    
    //interface implementation
    @Override
    public String getCakeDetails(){
        return cakeName + " cake";
    }
    
    @Override
    public String toString(){
        return super.toString() + this.getCakeDetails();
    }
}
