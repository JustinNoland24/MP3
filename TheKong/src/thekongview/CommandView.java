/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongview;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 *
 * @author Justi
 */
public class CommandView extends Pane {
   public final Button srtGame;
   public  final Button endGame;
    
    
    public CommandView(){
        this.srtGame=new Button("Start");
        this.endGame=new Button("End");
        //this.setPrefSize(100, 100);
       
        
        endGame.setOnAction(e->{ 
            System.out.println("GAME ENDED");
                System.exit(0);
        
        });
       
        
        
        HBox controlbuttons=new HBox();
        controlbuttons.getChildren().addAll(srtGame,endGame);
        this.getChildren().add(controlbuttons);
    }
    
    
    
    
    
    
    
    
    
}
