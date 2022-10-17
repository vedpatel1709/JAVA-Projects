/**********************************************
Workshop 8
Course JAC444 NEE- 4
Last Name: Patel
First Name: Ved
ID: 149409203
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature: vedPatel
Date: 07/27/2022
**********************************************/
package work;

import java.util.Date;
import java.util.Random;

public class additionMatrix {

	// Creating two Matrixes
	static double MtrxOne[][] = new double[2000][2000];
	static double MtrxTwo[][] = new double[2000][2000];
		
	// Matrix values
	static double minNumber = 1;
	static double maxNumber = 2000;
	static Random Rndm = new Random();

	// parallelAddMatrix
	public static double[][] parallelAddMatrix(double[][] a, double[][] b) throws InterruptedException {
		double parallelMatrix[][] = new double[2000][2000];
		
		// Thread #1
		Thread Thrd1 = new Thread() {
			public void run() {
				for (int i = 0; i<500; i++) {
					for (int j = 0; j<500; j++) {
						parallelMatrix[i][j] = a[i][j] + b[i][j];
					}
				}

			}
		};
		
		// Thread #2
		Thread Thrd2 = new Thread() {
			public void run() {
				for (int i = 501; i<1000; i++) {
					for (int j = 501; j<1000; j++) {
						parallelMatrix[i][j] = a[i][j] + b[i][j];
					}
				}
			}
		};
		
		// Thread #3
		Thread Thrd3 = new Thread() {
			public void run() {
				for (int i = 1001; i<1500; i++) {
					for (int j = 1001; j<1500; j++) {
						parallelMatrix[i][j] = a[i][j] + b[i][j];
					}
				}
			}
		};
		
		// Thread #4
		Thread Thrd4 = new Thread() {
			public void run() {
				for (int i = 1501; i<2000; i++) {
					for (int j = 1501; j<2000; j++) {
						parallelMatrix[i][j] = a[i][j] + b[i][j];
					}
				}
			}
		};

		Thrd1.start();
		Thrd1.join();
		Thrd2.start();
		Thrd2.join();
		Thrd3.start();
		Thrd3.join();
		Thrd4.start();
		Thrd4.join();
		return parallelMatrix;

	}

	// SequentialAddMatrix
	public static double[][] sequentialAddMatrix(double[][] c, double[][] d) {
		double sequentialMatrix[][] = new double[2000][2000];

		for (int i = 0; i<2000; i++) {
			for (int j = 0; j<2000; j++) {
				sequentialMatrix[i][j] = c[i][j] + d[i][j];
			}
		}
		return sequentialMatrix;
	}

	// Main method
	public static void main(String[] args) throws InterruptedException {

		for (int i = 0; i<2000; i++) {
			for (int j = 0; j<2000; j++) {
				MtrxOne[i][j] = Math.round((Rndm.nextDouble() * (maxNumber - minNumber)) * 100);
				MtrxTwo[i][j] = Math.round((Rndm.nextDouble() * (maxNumber - minNumber)) * 100);
			}
		}

		// Calculating time for sequentialAddMatrix
		Date StartSq = new Date();
		double mtrx1[][] = sequentialAddMatrix(MtrxOne, MtrxTwo);
		Date EndSq = new Date();
		System.out.println("Calculated time for adding Sequential Matrix time in miliseconds: " + (EndSq.getTime() - StartSq.getTime()));

		// Calculating time for parallelAddMatrix
		Date StartPrl = new Date();
		double mtrx2[][] = parallelAddMatrix(MtrxOne, MtrxTwo);
		Date EndPrl = new Date();
		System.out.println("Calculated time for adding Parallel Matrix time in miliseconds: " + (EndPrl.getTime() - StartPrl.getTime()));
	}

}