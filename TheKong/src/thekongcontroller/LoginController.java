/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import thekongmodel.PlayerProfile;
import thekongmodel.PlayerProfileCollection;
import thekongview.LoginView;

/**
 *
 * @author Justi
 */
public class LoginController {
    
    private PlayerProfileCollection profiles;
    
    
    public LoginController(PlayerProfileCollection profiles){
        String filename="PlayerProfileConfig.txt";
       //this.profiles=new PlayerProfileCollection(filename);
       this.profiles=profiles;
       // getLoginProfile();
        //this.profiles=IOController.readPlayerProfiles(filename);
        
    }
    
    public PlayerProfile getLoginProfile(){// display and allow to select a player
       
     String filename="PlayerProfileConfig.txt";
        PlayerProfileCollection playercoll=new PlayerProfileCollection(filename);
        PlayerProfile playerprof=new PlayerProfile("");
        List<String> choices=new ArrayList();
                                            //doesnt return choices but instantiates it//*****
   LoginView login=new LoginView(choices);
       playercoll=IOController.readPlayerProfiles(filename);
        
//        for(int i=0;i<8;i++){
//            playerprof=new PlayerProfile(login.getItems().get(i));
//           // choices.add(playercoll.getPlayerProfile(i).getPlayerName());
//          
//        }
         //login.displayLoginView();////////////////***********
      //  String show=login.displayLoginView();
        Optional<String> selectedOption=login.showAndWait();
        if(selectedOption.isPresent() && !selectedOption.get().equals("Create a new Player")){/////*******
          
      
            playerprof=new PlayerProfile(selectedOption.get());//////////***********
            this.profiles=IOController.readPlayerProfiles(filename);
            System.out.println("Your name is "+selectedOption.get());
            return playercoll.getPlayerProfile(login.getItems().indexOf(login.getSelectedItem()));
      
            
            
        }
        if(selectedOption.isPresent() && selectedOption.get().equals("Create a new Player") /*&& selectedOption.isPresent()*/){
            
            profiles=new PlayerProfileCollection(filename);
            profiles=IOController.readPlayerProfiles(filename);
            
          
            
            TextInputDialog input=new TextInputDialog();
            input.setTitle("Create a new player");
input.setHeaderText("Create your player");
input.setContentText("Please enter your name:");
            Optional<String> name = input.showAndWait();
            playerprof=new PlayerProfile(name.get());
            
this.profiles.addPlayerProfile(playerprof);
 //LoginController log=new LoginController(profiles);/////////////******** 
             System.out.println("Your name is  "+ name.get());
             //this.profiles.setPlayerProfile(playerprof, 0);//=IOController.readPlayerProfiles(filename);
             IOController.writePlayerProfiles(profiles);///basically saves and adds new player to the file
             System.out.println(profiles);
            return playerprof;
            
         
        } 
       
        if(!selectedOption.isPresent()){
         
          
            
            System.out.println("TRY AGAIN");
           
            
           showLoginErrorAndExit(); 
        return this.getLoginProfile();
        
            
            }     
        
        
        ////FIX CANCEL BUTTON
         
     
        
        
      
         
        return playerprof;
    }
    
    
    public void showLoginErrorAndExit(){
        
        Alert alert = new Alert(AlertType.ERROR);
alert.setTitle("ERROR MESSAGE");
alert.setHeaderText("TRY AGAIN");
alert.setContentText("WRONG INPUT TRY AGAIN!!");

alert.showAndWait();
        
    }
    
      
    
}
