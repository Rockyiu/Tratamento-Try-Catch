/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package application;

import entities.Reservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Vinicius
 */
public class Program {

    /**
     * Implementação da Solução Ruim para tratar
     * exceções;
     * Implementação da lógica de validação no programa
     * principal;
     * A solução em si é muito ruim, pois da linha 52 até a linha 63, toda essa
     * logica deveria estar na classe Reservation e não na principal;
     */
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Room number:");
        int roomNumber = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy)");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy)");
        Date checkOut = sdf.parse(sc.next());
        
        if(!checkOut.after(checkIn)){
            System.out.println("Error in reservation");
        }
        else{
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation:" + reservation);
            
            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy)");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy)");
            checkOut = sdf.parse(sc.next());
            
            
            Date now = new Date();
            if(checkIn.before(now) || checkOut.before(now)){
                System.out.println("Error in reservation");
            }
            else if(!checkOut.after(checkIn)){
                System.out.println("Error in reservation");
            }
            
            else{
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation:" + reservation);
            }
       }   
        sc.close();
    }
    
}
