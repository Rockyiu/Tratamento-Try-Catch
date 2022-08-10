/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package application;

import entities.Account;
import exceptions.DomainException;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Vinicius
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter account data:");
        System.out.print("Number");
        int number = sc.nextInt();
        System.out.println("Holder:");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.println("Initial balance:");
        double balance = sc.nextDouble();
        System.out.println("Withdraw limit:");
        double withdrawLimit = sc.nextDouble();
        
        Account account = new Account(number, holder, balance, withdrawLimit);
       
        System.out.println();
        System.out.println("Enter amount for withdraw:");
        double amount = sc.nextDouble();
        
        try{
            account.withdraw(amount);
            System.out.println("New balance:" + account.getBalance());
        }
        catch (DomainException e){
            System.out.println("Withdraw error:" + e.getMessage());
        }
        
        
        
        sc.close();
    }
    
}
