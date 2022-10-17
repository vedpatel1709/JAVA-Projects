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

public class ReverseThread extends Thread {

	// main method
    public static void main(String[] args) {
        ReverseThread RevThread = new ReverseThread(1);
        RevThread.start();
    }

    int Count = 0;

    // Reverse Thread count
    public ReverseThread(int count) {
        this.Count = count;
    }

    // Run method
    public void run() {
        if (Count < 51) {
            ReverseThread RevThread = new ReverseThread(Count + 1);
            RevThread.start();

            try {
                RevThread.join();
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from thread! :" + "Thread #" + Count);
        }
    }

}