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

public class TriangleException extends Exception{
    
    public TriangleException(double s1, double s2, double s3) {
        System.out.println("Invalid Triangle: \n" + "side1 = " + s1 + "\nside2 = " + s2 + "\nside3 = " + s3);
        if(!(s1+s2>s3))
        {
        	if(s1<s2)
        		System.out.println("Invalid side value: " + s1);
        	else
        		System.out.println("Invalid side value: " + s2);
        }
        
        else if(!(s2+s3>s1))
        {
        	if(s3<s2)
        		System.out.println("Invalid side value: " + s3);
        	else
        		System.out.println("Invalid side value: " + s2);
        }
        
        else if(!(s1+s3>s2))
        {
        	if(s1<s3)
        		System.out.println("Invalid side value: " + s1);
        	else
        		System.out.println("Invalid side value: " + s3);
        }
    }
}
