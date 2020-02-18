/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conditionalbreakpoint;

/**
 *
 * @author maxfe
 */
public class ConditionalBreakpoint {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    // Generating a random integer between 1 and 100
    int randomNumber  = (int) (Math.random()*100);
    //The even variable is true when the number is divisible
    boolean even = randomNumber%2==0;
    //Paint the result
    System.out.println("Generated random number " + randomNumber+" = "+even);
    //Finishing the program
    System.out.println("Program is finished!");
    }
    
}
