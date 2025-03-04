/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cakes;

/**
 *
 * @author carolina astolfo
 */
public class InvalidCupcakeCountException extends Exception {
    
    public InvalidCupcakeCountException(){
        super();
    }

    @Override
    public String toString(){
        return "Cupcake count must be 4 or 6";
    }
}
