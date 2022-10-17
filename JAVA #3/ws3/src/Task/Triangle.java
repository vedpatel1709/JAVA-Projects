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

public class Triangle extends GeometricObject{
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	
	public Triangle() {
			// will create default triangle
	}
	
	public Triangle(double s1, double s2, double s3) {
			// overloaded constructor to create triangle with specified sides
		this.side1 = s1;
		this.side2 = s2;
		this.side3 = s3;
	}
	
	public double getSide1() {
		return side1;
	}
	
	public double getSide2() {
		return side2;
	}
	
	public double getSide3() {
		return side3;
	}
	
	public double getArea() {
		double s = this.getPerimeter() / 2;
		double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
		return area;
	}
	
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	
	public String toString() {
        return
            	("Valid Triangle Info: \n"  + "\nSide1     : " + getSide1() 
            + "\nSide2     : " + getSide2() + "\nSide3     : " + getSide3() 
            + "\nColor     : " + getColor() + "\nPerimieter: " + getPerimeter() 
            + "\nArea      : " + getArea()) + "\n\n";
    }
}
