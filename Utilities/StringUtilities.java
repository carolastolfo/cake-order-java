/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

/**
 *
 * @author carolina astolfo
 */
//capitalize first letter of a word
public final class StringUtilities {
    
    public static String formatString (String string){
        String formatString = string.substring(0, 1).toUpperCase() + string.substring(1);
        return formatString;
    }

}

