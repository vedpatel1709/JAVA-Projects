package Task;
import java.util.Scanner;

// Task 2

public class TestClassT2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
        try {		// Creating object with valid triangle values
        	System.out.print("Enter three sides of the triangle: ");
        	
    		double s12 = input.nextDouble(); 
    		double s22 = input.nextDouble(); 
    		double s32 = input.nextDouble(); 
    		
        	TriangleT2 triangle2 = new TriangleT2( s12, s22, s32);
            System.out.println(triangle2.toString());
        } 
        catch (TriangleException ex) {
            System.out.println(ex);
        }

        try {		// Creating object with Invalid triangle values
        	System.out.print("Enter three sides of the triangle: ");
    		double s121 = input.nextDouble(); 
    		double s221 = input.nextDouble(); 
    		double s321 = input.nextDouble();
    		
    		TriangleT2 triangle3 = new TriangleT2(s121, s221, s321);
            System.out.println(triangle3.toString());
        } 
        catch (TriangleException ex) {
            System.out.println(ex);
        }
	}

}
