/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Vinicius
 */
public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }


    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
   
    public long duration(){
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    
    public String updateDates(Date checkIn, Date checkOut){
            Date now = new Date();
            if(checkIn.before(now) || checkOut.before(now)){
                return "Error in reservation";
            }
            if(!checkOut.after(checkIn)){
                return "Error in reservation";
            }
            this.checkIn = checkIn;
            this.checkOut = checkOut;
            return null;
    }
    
    @Override
    public String toString(){
        return "Room "
                + roomNumber
                +", check-in: "
                +sdf.format(checkIn)
                +", check-out: "
                +sdf.format(checkOut)
                +", "
                + duration()
                +" nights";
    }
}