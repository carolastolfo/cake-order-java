/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Order;

import Cakes.Cake;
import Cakes.Cupcake;
import Cakes.CustomCake;
import Cakes.InvalidCupcakeCountException;
import Cakes.OccasionCake;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author carolina astolfo
 */
public class OrderCake {
    Cake[] cakes;
    Scanner scan;
    
    public OrderCake(){
        scan = new Scanner(System.in);
        cakes = new Cake[5]; 
    }
    
    //initializes scanner object and cakes array with user provided size
    //then calls addCake() method to fill in the array
    public OrderCake(int index){
        scan = new Scanner(System.in);
        cakes = new Cake[index];
    }
    
    //handles user inputs to create cake objs
    //if statements compares user input to identify type of cake
    //then creates an object of that cake type in the Cake array with params provided by users
    //after obj is created, call calculatePrice()
    public void addCake(){
        System.out.println("You can choose Cupcakes or a Occasion or a Custom cake");
        for(int i = 0; i < cakes.length; i++){
            System.out.println("Enter the type of cake that you want - ");
            String cakeType = scan.next().trim();
            
            //occasion cake
            if(cakeType.equalsIgnoreCase("occasion")){
                System.out.println("Enter the flavour and the name of the Occasion cake (Holiday, Wedding, Birthday, and Anniversary)");
                String flavour = scan.next();
                String occasionType = scan.next();
                cakes[i] = new OccasionCake(flavour, occasionType);
                cakes[i].calculatePrice();
            }
            
            //custom cake
            else if(cakeType.equalsIgnoreCase("custom")){
                System.out.println("Enter the flavour, the number of layers (1 to 4) and size of the cake (6\", 8\", 10\", and 12\")");
                String flavour = scan.next();
                int layers = scan.nextInt();
                int size = scan.nextInt();
                cakes[i] = new CustomCake(flavour, layers, size);
                cakes[i].calculatePrice();
            }
            
            //cupcake
            else if(cakeType.equals("cupcake") || cakeType.equals("cupcakes")){
                System.out.println("Enter the flavour, count (4 or 6), and weight in ounces (1, 2 or 3)");
                try{
                    String flavour = scan.next();
                    int count = scan.nextInt();
                    int weight = scan.nextInt();
                    cakes[i] = new Cupcake(flavour, count, weight);
                    cakes[i].calculatePrice();
                }catch(InvalidCupcakeCountException e){
                    System.out.println(e.toString()); 
                }
            }
            
            //invalid and decrement counter so user has another chance to input valid options
            else{
                System.out.println("Invalid cake type. Please try again");
                i--;
            }
        }
    }
    
    //calculates the total order cost
    public double calculateCost(){
        double total = 0;
        for (Cake cake : cakes){
            total += cake.getPrice();
        }
        return total;
    }
    
    //calculates total order weight
    public int calculateWeight(){
        int total = 0;
        for (Cake cake : cakes){
            total += cake.getWeight();
        }
        return total;
    }
    
    //generates random number
    public int generateOrderNumber(){
        return (int) (Math.random() * 900000) + 10000;
    }
    
    //dialog boxes to display toString, confirm order, offer shipping
    public void confirmOrder(){
String[] options = { "Confirm order", "Add shipping", "Cancel order" };
        int confirmation = JOptionPane.showOptionDialog(null, this.toString() + "\n\nWe offer next day shipping for $1 per ounce of cake!\nWould you like to add shipping?",
                "Confirm Order", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        switch (confirmation) {
            //confirm order
            case 0 -> {
                int confirmationNumber = this.generateOrderNumber();
                JOptionPane.showMessageDialog(null, "Thank you \nYour order has been placed.\nYour Confirmation code is: " + confirmationNumber);
            }
            //add shipping
            case 1 -> {
                int confirmationNumber = this.generateOrderNumber();
                Shipping shipping = new Shipping(calculateWeight());
                JOptionPane.showMessageDialog(null, "Thank you \nYour order has been placed.\nYour Confirmation code is: " + confirmationNumber +
                        shipping.toString());
            //cancel order
            }
            case 2 -> JOptionPane.showMessageDialog(null, "Order cancelled.");
        } 
    }
    
    //collects each obj toString method and adds the total at the end
    @Override
    public String toString(){
        String output = "";
        for (Cake cake : cakes){
            output += cake.toString() + "\n";
        }
        output += "Total amount of the order is $" + calculateCost();
        return output;
    }
}
