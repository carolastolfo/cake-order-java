
import Order.OrderCake;
import java.util.Scanner;
import javax.swing.JOptionPane;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author carolina astolfo
 */
public class Tester {

    public Tester() {
    
        Scanner scan = new Scanner(System.in);
        System.out.println("****** Welcome to my cake shop ******");
        System.out.println("How many cakes would you like to order?");
        int index = scan.nextInt();
        OrderCake order1 = new OrderCake(index);
        order1.addCake();
        //i added this line because of a focus issue when the dialog box was appearing behind another window
        System.out.println("We are processing your order! Check for the dialog box");
        order1.confirmOrder();

}
    public static void main(String[] args) {
        new Tester();
        }
    
}
