/**********************************************
Workshop 10
Course:JAC444 - Semester 4
Last Name: Patel
First Name: Ved
ID: 149409203
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature: VedPatel
Date: 08/05/2022
**********************************************/
package work;

import java.util.Scanner;

public class TestTask1{
	
   public static void main(String args[]) {
	   
       Scanner Input = new Scanner(System.in);
       int hrs, mins, secs;
       long elps;
       
       System.out.print("-------------------------------------------------------------\n");
       System.out.print("Input TIME1 (HOUR, MINUTE, and SECOND): ");
       hrs = Input.nextInt();
       mins = Input.nextInt();
       secs = Input.nextInt();
       Time Time1 = new Time(hrs, mins, secs);
       System.out.print("-------------------------------------------------------------\n");
       System.out.println(Time1);
       System.out.println("ELAPSED SECONDS IN TIME1: " + Time1.getSeconds());
       System.out.println();
       System.out.print("-------------------------------------------------------------\n");
       
       System.out.print("Input TIME2 (ELAPSED TIME IN SECONDS): ");
       elps = Input.nextLong();
       Time Time2 = new Time(elps);
       System.out.print("-------------------------------------------------------------\n");
       System.out.println(Time2);
       System.out.println("ELAPSED SECONDS IN TIME2: " + Time2.getSeconds());
       System.out.println();
       System.out.print("-------------------------------------------------------------\n");

       System.out.println("TIME1.COMPARETO(TIME2)? " + Time1.compareTo(Time2));
       Time Time3 = Time1.clone();
       System.out.println("TIME3 CREATED AS A CLONE OF TIME1 TIME1.COMPARETO(TIME3)? " + Time1.compareTo(Time3));
       System.out.println("-------------------------------------------------------------\n");
   } 
}