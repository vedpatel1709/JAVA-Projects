/**********************************************
Workshop 5
Course: JAC444 - 4
Last Name: Patel
First Name: Ved
ID: 149409203
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature: Ved Patel
Date: 25th June 2022
**********************************************/
package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;
import java.io.RandomAccessFile;

public class MainForm extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
    FormInfo readData = new FormInfo();

    final int firstName = 31;		// first name
    final int lastName = 32;		// last name
    final int cityName = 20;		// city name
    final int stateName = 2;		// state name
    final int zipCode = 6; 		// Postal Code
    int count = 0;

    public void start(Stage primaryStage) {
        //	Buttons
        readData.add.setOnAction(e -> add());
        readData.first.setOnAction(e -> first());
        readData.next.setOnAction(e -> next());
        readData.previous.setOnAction(e -> previous());
        readData.last.setOnAction(e -> last());
        readData.update.setOnAction(e -> update());

        // 	creating a new box
        Scene scene = new Scene(readData, 460, 200);
        primaryStage.setTitle("Address Book");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    	//	Adding new address in the file
      public void add() {
        try (RandomAccessFile newfile = new RandomAccessFile("src/application/AddressBook.txt", "rw");)
        { newfile.seek(newfile.length());
            write(newfile);
        } catch (FileNotFoundException ex) {
            System.out.println("error");
        } catch (IOException ex) {
            System.out.println("error");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("error");
        }
    }

       //  first Addresss in the file
      public void first() {
        try (
            RandomAccessFile newfile = new RandomAccessFile("src/application/AddressBook.txt", "rw");)
        {
               	newfile.seek(0);
                read(newfile);
                System.out.println("Go to the First Adress");
                count = 1;
        } catch (IOException ex) {
            System.out.println("error");
        }
    }

    // Next Button 
    public void next() {
        try (
            RandomAccessFile newfile = new RandomAccessFile("src/application/AddressBook.txt", "rw");
        ) {
            if (count * 91 < newfile.length()) {
            	newfile.seek(count * 91);
                read(newfile);
                count++;
                System.out.println("Next is " + count);
            } else {
                System.out.println("Can't go next, Last Address!");
            }
        } catch (IOException ex) {
            System.out.println("error");
        }
    }

    // previous person
    public void previous() {
        try (RandomAccessFile newfile = new RandomAccessFile("src/application/AddressBook.txt", "rw");)
        {   
        	if (count > 1){ 
        	count--;
        	}
            else {
                count = 1;
            }
            newfile.seek((count * 91) - 91);
            read(newfile);
            
            System.out.println("Previous Address:" + count);
        } catch (IOException ex) {
            System.out.println("error");
        }
    }

    //Last Person data
    public void last() {
        try (RandomAccessFile newfile = new RandomAccessFile("src/application/AddressBook.txt", "rw");)
        {   count = ((int) newfile.length()) / 91;
            newfile.seek((count * 91) - 91);
            read(newfile);
            System.out.println("Last Address:" + count);
        } catch (IOException ex) {
            System.out.println("error");
        }
    }

    // Update the data
    public void update() {
        try (RandomAccessFile newfile = new RandomAccessFile("src/application/AddressBook.txt", "rw");)
        {  	newfile.seek((count * 91) - 91);
            write(newfile);
            System.out.println("Address Updated" + count);
        } catch (FileNotFoundException ex) {
            System.out.println("ierror");
        } catch (IOException ex) {
            System.out.println("error");
        }
    }

    // Fix length string for storing each attribute in the address
    public byte[] fixedLength(byte[] x, int n) {
        byte[] length = new byte[n];
        for (int i = 0; i < x.length; i++) {
        	length[i] = x[i];
        }
        return length;
    }

    // Write Function
    public void write(RandomAccessFile newfile) throws IOException {
    	newfile.write(fixedLength(readData.fName.getText().getBytes(), firstName));
    	newfile.write(fixedLength(readData.lName.getText().getBytes(), lastName));
    	newfile.write(fixedLength(readData.city.getText().getBytes(), cityName));
    	newfile.write(fixedLength(readData.province.getValue().getBytes(), stateName));
    	newfile.write(fixedLength(readData.zip.getText().getBytes(), zipCode));
        System.out.println("Address Saved!");
    }

    	// Read Function
    public void read(RandomAccessFile newfile) throws IOException {
        
        byte[] f_Name = new byte[firstName];
        int input = newfile.read(f_Name);
        readData.fName.setText(new String(f_Name));
        
        byte[] l_name = new byte[lastName];
        input = newfile.read(l_name);
        readData.lName.setText(new String(l_name));

        byte[] n_city = new byte[cityName];
        input += newfile .read(n_city);
        readData.city.setText(new String(n_city));

        byte[] s_name = new byte[stateName];
        input += newfile .read(s_name);
        readData.province.setPromptText(new String(s_name));

        byte[] n_zipCode = new byte[zipCode];
        input += newfile .read(n_zipCode);
        readData.zip.setText(new String(n_zipCode));
    }

}