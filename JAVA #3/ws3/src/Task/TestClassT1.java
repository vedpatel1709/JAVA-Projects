/**********************************************
Workshop 3
Course: JAC444 - 4
Last Name: Patel
First Name: Ved
ID: 149409203
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature: Ved Patel
Date: 9th June, 2022
**********************************************/

package Task;

import java.util.Scanner;

public class TestClassT1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Task 1
		Triangle Task1_1 = new Triangle();
		System.out.println("Triangle with default value");
		System.out.println("Side 1   : " + Task1_1.getSide1());
		System.out.println("Side 2   : " + Task1_1.getSide2());
		System.out.println("Side 3   : " + Task1_1.getSide3());
		System.out.println("Color    : " + Task1_1.getColor());
		System.out.println("Perimeter: " + Task1_1.getPerimeter());
		System.out.println("Area     : " + Task1_1.getArea());
		System.out.print("\n\n");
		
		System.out.println("Triangle with added info");
		System.out.print("Enter three sides of the triangle: ");
		
		double s1 = input.nextDouble(); 
		double s2 = input.nextDouble(); 
		double s3 = input.nextDouble(); 
		
		Triangle Task1_2 = new Triangle(s1, s2, s3);
		System.out.println(Task1_2.);
	
	}
}
