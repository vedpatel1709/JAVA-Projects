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

// Class Banks
public class Banks {	
	
	// main method
  public static void main(String[] args) {

    Scanner Input = new Scanner(System.in);
    
    System.out.print("Number of banks: ");
    int BanksCount = Input.nextInt();
    
    int[] Banks = new int[BanksCount];
    double[] BankBalances = new double[BanksCount];
    double[][] BankLoan = new double[BanksCount][BanksCount];

    System.out.print("Minimum asset limit: ");
    double MaxAssetLimit = Input.nextDouble();

    for (int i = 0; i < Banks.length; i++) {

      System.out.println("For Bank # " + i);
      System.out.print("   Balance: ");
      BankBalances[i] = Input.nextDouble();

      System.out.print("   Number of banks Loaned: ");
      int noOfBanksBankLoaned = Input.nextInt();
      for (int j = 0; j < noOfBanksBankLoaned; j++) {

        System.out.print("     Bank ID who gets the Loan: ");
        int BankID = Input.nextInt();

        System.out.print("     Loaned Amount: ");
        BankLoan[i][BankID] = Input.nextDouble();
      }
    }

    double[] ValueAssets = new double[BanksCount];
    boolean[] IsBankSafe = new boolean[BanksCount];
    
    for (int i = 0; i < BanksCount; i++) {
      IsBankSafe[i] = true;
    }

    System.out.print("\nUnSafe Banks Are ");
    boolean IsBankUnSafe = true;
    while (IsBankUnSafe) {
      IsBankUnSafe = false;

      for (int i = 0; i < Banks.length; i++) {
        ValueAssets[i] = BankBalances[i];

        for (int j = 0; j < Banks.length; j++) {
          ValueAssets[i] += BankLoan[i][j];
        }

        if (IsBankSafe[i] && ValueAssets[i] < MaxAssetLimit) {
          IsBankSafe[i] = false;
          IsBankUnSafe = true;
          System.out.print("Bank " + i + " ");

          for (int m = 0; m < Banks.length; m++) {
            BankLoan[m][i] = 0;
          }
        }
      }
    }
  }
}