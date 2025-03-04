/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Order;

import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author carolina astolfo
 */
//netbeans suggested final class because i called overridable methods in the constructor
public final class Shipping {
    private final int COST_PER_OUNCE = 1;
    private double cost;
    private String shippingId;
    private LocalDate deliveryDate;
    
    public Shipping(int weight){
        cost = calculateShippingCost(weight);
        shippingId = generateShippingID();
        deliveryDate = LocalDate.now().plusDays(1);
    }
    
    //calculate shipping cost based on weight
    public double calculateShippingCost(int weight){
        return weight * COST_PER_OUNCE;
    }
    
    //generate and set shipping id using Random class variable
    public String generateShippingID() {
        Random random = new Random();
        String output = "";
        for (int i = 0; i < 3; i++) {
            char letter = (char) (random.nextInt(17) + 'A');
            output += letter;
        }
        output += "-";

        for (int i = 0; i < 4; i++) {
            int digit = random.nextInt(10);
            output += digit;
        }
        return output;
    }
    
    @Override
    public String toString(){
        return "\nDelivery cost is: $" + cost + "\nYour shipping ID is " +
                shippingId + " and your order will arrive tomorrow on: " + deliveryDate;
    }
}
