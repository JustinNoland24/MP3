/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongview;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;
import thekongcontroller.IOController;
import thekongmodel.PlayerProfileCollection;


/**
 *
 * @author Justi
 */
public class LoginView extends ChoiceDialog<String> {
    
   
    
    
    public LoginView(List<String> choices){ 
    
       String filename="PlayerProfileConfig.txt";
        PlayerProfileCollection playercoll=new PlayerProfileCollection(filename);
        playercoll=IOController.readPlayerProfiles(filename);
      choices = new ArrayList();
      //Label lab=new Label();
      for(int i=0;i<playercoll.getNumPlayerProfiles();i++){ 
 
          choices.add(playercoll.getPlayerProfile(i).getPlayerName());
 // ObservableList<String>list= FXCollections.observableList(choices);
 

   
 //this.contentTextProperty().setValue(filename);

      } 
      this.setSelectedItem(null/*"Please make a selection: "*/); 
      
      choices.add("Create a new Player");
       this.getItems().addAll(choices);
this.setTitle("CHOOSE PLAYER");
this.setHeaderText("OPTIONS");
this.setContentText("Select a player or Create:");

//Event obj=new Event();
//
//Node cancelbutton=this.getDialogPane().lookupButton(this.getDialogPane().getButtonTypes().get(1));
//
//cancelbutton.setOnMousePressed(obj);

//Button buttonOk=new Button("OK");
//Button buttoncancel=new Button("Cancel");
//this.getDialogPane().getButtonTypes().remove(1);
//this.getDialogPane().getChildren().add(buttoncancel);

//this.getDialogPane().getButtonTypes().add(buttonyes);


    ////FIXING CANCEL BUTTON
       final Button cancel = (Button) this.getDialogPane().lookupButton(ButtonType.CANCEL);
cancel.addEventFilter(ActionEvent.ACTION, (ActionEvent e) -> {
        
        System.out.println("Canceled");
   
        System.exit(0);
                });
        
//final Button cancel = (Button) this.getDialogPane().lookupButton(ButtonType.CANCEL);
//cancel.addEventFilter(ActionEvent.ACTION, event -> {
//        
//        System.out.println("Canceled");
//   
//        System.exit(0);
//                });


    final Button close = (Button) this.getDialogPane().lookupButton(ButtonType.CLOSE);
cancel.addEventFilter(ActionEvent.ACTION, event -> {
        
   System.out.println("WINDOW CLOSED");
        System.exit(0);
                });
        
Window  window = this.getDialogPane().getScene().getWindow();
window.setOnCloseRequest(event -> {
        System.out.println("WINDOW CLOSED");
       System.exit(0);
               });

// Traditional way to get the response value.
//Optional<String> selectedOption = this.showAndWait();
//
//if(selectedOption.equals("Create a new Player")) {
//    
//    
//    
// TextInputDialog dialog = new TextInputDialog("");
//dialog.setTitle("Create a new player");
//dialog.setHeaderText("Create your player");
//dialog.setContentText("Please enter your name:");
//
//// Traditional way to get the response value.
//Optional<String> result = dialog.showAndWait();
//if (result.isPresent()){
//    System.out.println("Your name: " + result.get());
//}
//
//// The Java 8 way to get the response value (with lambda expression).
//result.ifPresent(name -> System.out.println("Your name: " + name));   
    
    
    
}

// The Java 8 way to get the response value (with lambda expression).
//selectedOption.ifPresent(name -> System.out.println("Your name: " + name));
    
    
    
//public class Event implements EventHandler<MouseEvent>{
//    
//    @Override
//    public void handle(MouseEvent e){
//     Button obj=(Button) e.getSource();
//     
//     if(obj.getText()=="Cancel"){ 
//         
//         System.out.println("YOU CANCELED");
//         System.exit(0);
//         
//     }
//     
//        
//    }
//    
//}

// Traditional way to get the response value.
//Optional<String> result = this.showAndWait();
//if (result.isPresent()){
//    System.out.println("Your choice: " + result.get());
//}
//
//// The Java 8 way to get the response value (with lambda expression).
//result.ifPresent(letter -> System.out.println("Your choice: " + letter));
//        
//        
        
     
     
    public  String displayLoginView(){///Why does it return a string?
        this.show();
        
     return this.getResult();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
