/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongview;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;

/**
 *
 * @author Justi
 */
public class GameView extends BorderPane {
    
    
    
    
    public GameView(){
     //PlayAreaView obj=new PlayAreaView();
        StatusView obj=new StatusView();
        CommandView object=new CommandView();
        this.setTop(obj);
        this.setBottom(object);
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
}
