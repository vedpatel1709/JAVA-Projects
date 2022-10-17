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

public abstract class GeometricObject {		// abstract class
	private String color= "while";		// default value white
	private Boolean filled;
	
	public GeometricObject(){
		
	}
	
	protected GeometricObject(String color, boolean filled){}	// protected overloaded constructor
	
	// getters(accesser) and setters (mutator)
	public String getColor() {
		return color;
	}

	public void setColor(String newColor) {
		color = newColor;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean newFilled) {
		filled = newFilled;
	}
	
	public abstract double getArea();	// getArea()

    public abstract double getPerimeter();	//getPerimeter()

}
