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

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class FormInfo extends BorderPane {
    public TextField fName = new TextField(); 							//taking First Name field
    public TextField lName = new TextField(); 							//taking Last Name Field
    public TextField city = new TextField();						    // taking city
    public ComboBox < String > province = new ComboBox < String > (); 	// Options for the Province
    public TextField zip = new TextField(); 							//Postal Code

    //  	Buttons 
    public Button add = new Button("Add");
    public Button first = new Button("First");
    public Button next = new Button("Next");
    public Button previous = new Button("Previous");
    public Button last = new Button("Last");
    public Button update = new Button("Update");
    
    public FlowPane btnFP = new FlowPane(5, 5);
    public HBox btnHBox = new HBox(5);

    //	Default constructor
    public FormInfo() {
        drawAddressBook();
    }

    public void drawAddressBook() {

        province.getItems().addAll("ON", "MB", "NB", "QC", "BC");        //province choices

        // Set the Columns for the first name, last name city and postal code
        fName.setPrefColumnCount(10);
        lName.setPrefColumnCount(10);
        city.setPrefColumnCount(10);
        province.setMaxWidth(10);
        zip.setPrefColumnCount(4);

        // Set width for the Buttons
        add.setMinWidth(70);
        first.setMinWidth(70);
        next.setMinWidth(70);
        previous.setMinWidth(70);
        last.setMinWidth(70);
        update.setMinWidth(70);

        // rows spaces
        btnFP.setPadding(new Insets(11.5, 11.5, 11.5, 11.5));
        btnFP.setHgap(15);
        btnFP.setVgap(20);

        // Labels
        btnFP.getChildren().addAll(
            new Label("First Name:"), fName,
            new Label("Last Name:"), lName,
            new Label("City:"), city,
            new Label("Province:"), province,
            new Label("Postal Code:"), zip
        );

        // Place nodes in the box
        btnHBox.getChildren().addAll(add, first, next, previous, last, update);

        btnHBox.setAlignment(Pos.CENTER);
        setCenter(btnFP);
        setBottom(btnHBox);
    }
}