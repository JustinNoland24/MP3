/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongview;

import java.util.Optional;
import java.util.Scanner;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Window;
import javafx.util.Pair;
import thekongcontroller.IOController;
import thekongmodel.PlayerProfileCollection;

/**
 *
 * @author Justi
 */
public class StatusView extends Pane{///display the active player's name, the current score, the game's high score, and the current level.
    
    
    public StatusView(){ 
        String filename="PlayerProfileConfig.txt";
        PlayerProfileCollection profiledata=new PlayerProfileCollection(filename); 
        profiledata=IOController.readPlayerProfiles(filename);
        Label label =new Label();
        label.setText(profiledata.getActiveProfile().toString());
        
        this.getChildren().add(label);
       updateDisplaydata();/////////////************
    }
    
    public void updateDisplaydata(){       
        
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle("UPDATE");
alert.setHeaderText("CONFIRMING");
alert.setContentText("DO YOU WANT TO UPDATE INFORMATION?");

ButtonType buttonTypeYes = new ButtonType("Yes");
ButtonType buttonTypeNo = new ButtonType("No");
alert.getButtonTypes().setAll(buttonTypeYes,buttonTypeNo);

Window window=alert.getDialogPane().getScene().getWindow();
window.setOnCloseRequest(event->{
    System.out.println("Closed window");
   System.exit(0);
}
);


Optional<ButtonType> result = alert.showAndWait();/////////////////***********
if (result.get() == buttonTypeYes){ 
    System.out.println("YES");
  Dialog<ButtonType> dialog = new Dialog<>();
    ButtonType buttonTypefinish = new ButtonType("Finished");
ButtonType buttonTypecancel = new ButtonType("Cancel");
dialog.getDialogPane().getButtonTypes().addAll(buttonTypefinish,buttonTypecancel);    

    GridPane grid = new GridPane();
grid.setHgap(10);
grid.setVgap(10);
grid.setPadding(new Insets(20, 150, 10, 10));
    
     
     
     
     TextField name=new TextField();
    TextField currentscore =new TextField();
    TextField highscore=new TextField();
    TextField level=new TextField();
 //c/r
grid.add(name, 1, 0);
grid.add(new Label("Please enter your name: "), 0, 0);
grid.add(currentscore, 1, 1);
grid.add(new Label("Enter current score: "), 0, 1);
grid.add(highscore,1,2);
    grid.add(new Label("enter highscore: "), 0, 2);
    grid.add(level, 1, 3);
    grid.add(new Label("enter current level: "), 0, 3);
     
      dialog.getDialogPane().setContent(grid);
dialog.setTitle("Changing Information");
dialog.setHeaderText("Changes");


// Traditional way to get the response value.
Optional<ButtonType> clickbutton = dialog.showAndWait();
if (clickbutton.get()==buttonTypefinish){
    
    String filename="PlayerProfileConfig.txt";
        PlayerProfileCollection profiledata=new PlayerProfileCollection(filename);
        profiledata=IOController.readPlayerProfiles(filename);
    profiledata.getActiveProfile().setPlayerName(name.getText().trim());
    profiledata.getActiveProfile().setTotalScore(Integer.parseInt(currentscore.getText().trim()));
    profiledata.getActiveProfile().setHighScore(Integer.parseInt(highscore.getText().trim()));
   profiledata.getActiveProfile().setLevelsWon(Integer.parseInt(level.getText().trim()));
//   profiledata.getActiveProfile().setHighScore(30);
//   profiledata.getActiveProfile().setLevelsWon(20);
//   profiledata.getActiveProfile().setTotalScore(1000);
//   profiledata.getActiveProfile().setPlayerName("JIMMY");
    profiledata.getActiveProfile().setGamesPlayed(90);
    System.out.println(profiledata.getActiveProfile().toString());
    IOController.writePlayerProfiles(profiledata);
}
  
else if(clickbutton.get()==buttonTypecancel){  
    System.out.println("You pressed cancel");
     System.exit(0);
    // ... user chose CANCEL or closed the dialog

        
        
        
}     
} 
else if(result.get()==buttonTypeNo){ 
    System.out.println("You pressed No");
    //System.exit(0);///////*************
}
    
    }  
}  
    

