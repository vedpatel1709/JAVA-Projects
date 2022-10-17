package application;

import java.util.Scanner;
class Temp {

	public static final ArrayProcessor SumArray = array -> {
		double sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	};

	public static final ArrayProcessor AvgArray = array -> {
		double avg = 0;
		avg = SumArray.apply(array) / array.length;
		return avg;
	};

	public static final ArrayProcessor MaxValue = array -> {
		double max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (max < array[i])
			{
				max = array[i];
			}
		}
		return max;
	};
	
	public static final ArrayProcessor MinValue = array -> {
		double min = array[0];
		for (int i = 0; i < array.length; i++) {
			if (min > array[i])
			{
				min = array[i];
			}
		}
		return min;
	};

	public static ArrayProcessor countArray(double value) {
		return array -> {
			int count = 0;
			for (int i = 0; i < array.length; i++) {
				if (array[i] == value)
				{
					count++;
				}
			}
			return count;
		};
	}
	
public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
        
        double[] arr1 = {1,1,1,1,12,2,2,2,3,3,,4,5,6,7,8,9,0,1.1,345,12,14,15};
        
        System.out.print("Array values: ");        
        for(int i=0; i< arr1.length; i++) {        	
        	System.out.print(arr1[i] + " ");
        }

        System.out.println("Sum of values	: " + String.format("%7.2f", SumArray.apply(arr1)));
        System.out.println("Average value in array	: " + String.format("%7.2f", AvgArray.apply(arr1)));
        System.out.println("Minimum value in array 	: " + String.format("%7.2f", MinValue.apply(arr1)));
        System.out.println("Maximum value in array 	: " + String.format("%7.2f", MaxValue.apply(arr1)));
 
        System.out.print("Enter value to find count in array : ");
        double count = 0;
        count = input.nextDouble();
        System.out.println("Count of " + count +" in list	: " + countArray(count).apply(arr1) );        
    }
}