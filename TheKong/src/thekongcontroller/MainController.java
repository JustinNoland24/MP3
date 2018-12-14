/*+
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongcontroller;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import thekongmodel.LevelCollection;
import thekongmodel.LevelData;
import thekongmodel.PlayerProfile;
import thekongmodel.PlayerProfileCollection;
import thekongmodel.SpriteDataCollection;
import thekongview.CommandView;
import thekongview.CommandView2;
import thekongview.GameView;
import thekongview.GameView2;
import thekongview.HeroView;
import thekongview.LevelView;
import thekongview.LoginView;
import thekongview.PlayAreaView;
import thekongview.StatusView;
import thekongview.StatusView2;

/**
 *
 * @author Justi
 */
public class MainController extends Application {

    public BooleanProperty upPressed = new SimpleBooleanProperty();
public BooleanProperty leftPressed = new SimpleBooleanProperty();
    private static String playerProfileConfigFileName;
    private static String spriteConfigFileName;
    private static String objectConfigFileName;
    private static PlayerProfileCollection playerCollection;
    private static SpriteDataCollection spriteCollection;
    private static LevelCollection levelCollection;
    private  PlayAreaView playareaview;

    @Override
    public void start(Stage primaryStage) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
this.leftPressed=leftPressed;
this.upPressed=upPressed;
        playerProfileConfigFileName = "PlayerProfileConfig.txt";
       spriteConfigFileName="SpriteConfig.txt"; 
       objectConfigFileName="ObjectConfig.txt";

        String filename = "PlayerProfileConfig.txt";
        this.playerCollection = new PlayerProfileCollection(filename);
        playerCollection = IOController.readPlayerProfiles(playerProfileConfigFileName);
   

        this.levelCollection = IOController.readObjectConfigFile(objectConfigFileName);

        LoginController loginCont = new LoginController(playerCollection);

        LevelData lvldata = new LevelData(levelCollection.getLevel(0).getWidth(), levelCollection.getLevel(0).getHeight(), levelCollection.getLevel(0).getBackgroundImageFileName());

        PlayerProfile playerprof = new PlayerProfile("");
        playerprof = loginCont.getLoginProfile();
        StatusView2 status = new StatusView2(playerprof.getPlayerName(), playerprof.getHighScore());
        CommandView2 command = new CommandView2();

       
         SpriteDataCollection sprite = IOController.readSpriteConfigFile(spriteConfigFileName);

    
      this.playareaview = new PlayAreaView(sprite, levelCollection.getLevel(0));
        GameView2 game = new GameView2(status, playareaview, command);

        
        Scene scene = new Scene(game);
        AnimationController animationcontrol=new AnimationController(playareaview);
//       AnimationController animationcontrol=new AnimationController(playareaview){
//        
//           @Override
//           public void handle(long nsecs){
//               
//               
//               if(playareaview.getHero().getCenterX()-playareaview.getHero().getBoundingRadius()<0){ //LEFT BOUND (X-AXIS)
//    
//   playareaview.getHero().setSpeed(0.2);
//   playareaview.getHero().setDirection(0.0);//Code that sets bounds
//  // playview.getHero().move();
//   playareaview.getHero().setSpeed(2.0);
//    //playview.getHero().move();
//    System.out.println("crashed");
//} 
//
//
//if(playareaview.getHero().getCenterX()+playareaview.getHero().getBoundingRadius()>playareaview.getLevelView().getWidth()){//RIGHT BOUND(X-AXIS)
//         //playview.getHero().setDirection(180);//Code that sets bounds
//         //playview.getHero().setX(180);
//         playareaview.getHero().setSpeed(0.2);
//       // playview.getHero().move();
//        playareaview.getHero().setX(480);
//        System.out.println("kaboom");
//        
//} 
//
//if(playareaview.getHero().getCenterY()-playareaview.getHero().getBoundingRadius()<0){ //UPWARD Y BOUND
//   
//    
//    playareaview.getHero().setSpeed(0.2);
//   playareaview.getHero().setDirection(90);//Code that sets bounds
//  // playview.getHero().move();
//   playareaview.getHero().setSpeed(2);
//    //playview.getHero().move();
//    System.out.println("DOWNWARDS YOU GO");
//    
//    
//}
//
//    
//  if(!heroOnladder(playareaview) && !heroOnFloor(playareaview) && !heroOnPlatform(playareaview) ){ 
//    
//     // playview.getHero().setX(playview.getHero().getX()+gravity);
//          playareaview.getHero().setY(playareaview.getHero().getY()+gravity);
//          
//          System.out.println("GRAVITY");
//      }
//  
//  if(playareaview.getHero().getDirection()==270){ //moving up //up key           //||playview.getHero().getDirection()==90){
//      //if(heroOnladder(playview)){
//      int dy=0;
//      playareaview.getHero().setY(playareaview.getHero().getY()-1);
//      //control.upPressed.set(true);
//         
//         System.out.println("GOING UP");
//  }
//  
//  
//  
//  if(playareaview.getHero().getDirection()==90){//moving down //downkey
//      int dy=0;
//     playareaview.getHero().setY(playareaview.getHero().getY()+1);
//      System.out.println("GOING DOWN");
//  } 
//  
// 
//  
//
//  
//
//  
//  if(playareaview.getHero().getDirection()==0/*0*/){ //Moving right  //right key
//   int dx=0;
//    playareaview.getHero().setX(playareaview.getHero().getX()+1);
//      
//     System.out.println("Moving RIGHT");
//  }
//  
//  if(playareaview.getHero().getDirection()==180){//moving left  //left key
//     int dx=0;
//      playareaview.getHero().setX(playareaview.getHero().getX()-1);
//      
//      System.out.println("MOVING LEFT");
//      
//  }
//  
//
//    if(jump){
//    if(frame-frameIn<10){
//        playareaview.getHero().setY(playareaview.getHero().getY()-gravity*2.5);
//    }else{
//        jump=false;
//    }
//}
// System.out.println(playareaview.getHero().getX());
//        playareaview.moveSprites();
//        
//} 
//
//       
//           @Override
//    public boolean heroOnladder(PlayAreaView playview){
//         
//        
//          for(int i=0;i<playview.getLevelView().getNumLadders();i++){
//if(playareaview.getHero().getBoundsInParent().intersects(playview.getLevelView().getLadder(i).getBoundsInLocal() )){ 
//    System.out.println("Touched ladder");
//       return true;
//}
//          }
//          return false;
//     } 
//    
//    
//           @Override
//           public boolean heroOnPlatform(PlayAreaView playview){
//    
//    for(int i=0;i<playview.getLevelView().getNumPlatforms();i++){
//     
//        if(playview.getHero().getY()>=playview.getLevelView().getPlatformView(i).getY()-playview.getHero().getBoundingRadius() *2 && playview.getHero().getY()<=playview.getLevelView().getPlatformView(i).getY()+playview.getLevelView().getPlatformView(i).getHeight()-playview.getHero().getBoundingRadius()*2){
//            
//        if(playview.getHero().getX() > playview.getLevelView().getPlatformView(i).getX() && playview.getHero().getX() < playview.getLevelView().getPlatformView(i).getX()+  playview.getLevelView().getPlatformView(i).getWidth() || playview.getHero().getX()+playview.getHero().getBoundingRadius()*2 > playview.getLevelView().getPlatformView(i).getX() && playview.getHero().getX()+playview.getHero().getBoundingRadius()*2<playview.getLevelView().getPlatformView(i).getX()+playview.getLevelView().getPlatformView(i).getWidth()){
//        return true;
//        }
//    }
//    }  
// return false;   
//}
//  
//
//    
//
//        
//           @Override
//      public boolean heroOnFloor(PlayAreaView playview){
//         if(playview.getHero().getY()+playview.getHero().getBoundingRadius() *2 >= playview.getHeight()){
//             return true;         
//     }
//             return false;
//      
//
//
//
//      }
//       } ;
// 

   
    

               
               
               
           
        
        
             
command.getStartButton().setOnAction(event->{
    animationcontrol.start();
    
});

 command.getEndButton().setOnAction(event->{
  System.exit(0);
 });
        
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.SPACE) {
                //animcontrol.handle(10);
                System.out.println("Pressed spacebar");

            }
        });
        
scene.setOnKeyReleased(new EventHandler<KeyEvent>(){
    
    @Override
    public void handle(KeyEvent event){ 
        
          switch(event.getCode()){
       case UP: playareaview.getHero().setDirection(1);
                playareaview.getHero().setSpeed(0);
                System.out.println("UP");
                break;
                
                
                case DOWN:  playareaview.getHero().setDirection(1);
                  playareaview.getHero().setSpeed(0);
                  System.out.println("DOWN");
               break;
               
               
                case RIGHT:    playareaview.getHero().setSpeed(0);
                   playareaview.getHero().setDirection(1);
                   System.out.println("RIGHT");
                break;
                
                
                case LEFT:  playareaview.getHero().setSpeed(0);                     
                   playareaview.getHero().setDirection(1);
                System.out.println("LEFT");
                break;
    }
    
    }   
});

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) { 
         
            switch(event.getCode()){
                
                case UP: playareaview.getHero().setDirection(270);
                playareaview.getHero().setSpeed(5);
                System.out.println("UP");
                break;
                
                
                case DOWN:  playareaview.getHero().setDirection(90);
                  playareaview.getHero().setSpeed(.2);
                  System.out.println("DOWN");
               break;
               
               
                case RIGHT:    playareaview.getHero().setSpeed(4);
                   playareaview.getHero().setDirection(0.0);
                  
                   System.out.println("RIGHT");
                break;
                
                
                case LEFT:  playareaview.getHero().setSpeed(5);                     
                   playareaview.getHero().setDirection(180.0);
                System.out.println("LEFT");
                break;
                
                
                
                
                
                
                
                
                
                
                
                
            }

//                if (event.getCode() == KeyCode.RIGHT) { 
//                    
//           
//              //  if(/*play.getHero().getCenterX()-play.getHero().getBoundingRadius()>=-10 &&*/ playareaview.getHero().getCenterX()+playareaview.getHero().getBoundingRadius()<=500){//&& play.getHero().getCenterY()+play.getHero().getBoundingRadius()<=100 && play.getHero().getCenterY()-play.getHero().getBoundingRadius()>=0 &&play.getHero().getCenterY()+play.getHero().getBoundingRadius()<=100){ 
//                   
//                    //sprite.getHeroData().setStartingSpeed(21);
//                    
//                    
//                    
//                    playareaview.getHero().setSpeed(4);
//                   playareaview.getHero().setDirection(0.0);
////            
//                   // play.getHero().setX(play.getHero().getCenterX()-play.getHero().getBoundingRadius());
//                   // play.getHero().setY(play.getHero().getCenterY()-play.getHero().getBoundingRadius());
//                   // play.getHero().move();
//                //AnimationController animationcontrol=new AnimationController(playareaview);
//                    //animationcontrol.handle(0);
//                    
//                
//                
//                    System.out.println("Right key pressed");
//                    
//                }
//
//                if (event.getCode() == KeyCode.LEFT) {     
////
//          playareaview.getHero().setSpeed(5);
//                     
//                   playareaview.getHero().setDirection(180.0);
//                   
//
//
//                    
//                    System.out.println("Left key pressed");
//leftPressed.set(true);
//
//        
//                    
//                } 
//                if (event.getCode() == KeyCode.UP) { 
//                    // if(playareaview.getHero().getCenterY()+playareaview.getHero().getBoundingRadius()>=20){
//                    
//                         playareaview.getHero().setDirection(270);
//                   playareaview.getHero().setSpeed(5);
////                   // play.getHero().move();
//                   System.out.println("up Pressed");
//                  upPressed.set(true);
//                   // animationcontrol.handle(0);
//                     
//                          
////                           animationcontrol.handle(0);
////                           animationcontrol.handle(0);
////                           animationcontrol.handle(0);
////                           animationcontrol.handle(0);
////                           animationcontrol.handle(0);
////                           animationcontrol.handle(0);
//
//
//
//                }
//                 if (event.getCode() == KeyCode.DOWN) {  
//                     // if(playareaview.getHero().getCenterY()-playareaview.getHero().getBoundingRadius()<=480){
//                    playareaview.getHero().setDirection(90);
//                    playareaview.getHero().setSpeed(.2);
//                    //play.getHero().move();
//                    
//                   // animationcontrol.handle(0);
//                    
//                    System.out.println("down Pressed");
//
//                    
//                    
//                     // }
//                     
//                     
//                 }
//                 
//                 
//                 
//                 
//                  AnimationController animationcontrol=new AnimationController(playareaview);
//               //animationcontrol.handle(0);
//              
//             // animationcontrol.start();
//            }
            }
            });
//       
//  
        primaryStage.setScene(scene);
        primaryStage.show();
        
        

    }

    public void savePlayerData() {

        // IOController.writePlayerProfiles(playerCollection);
        //  this.playerCollection=IOController.readPlayerProfiles(playerProfileConfigFileName);
        //System.out.println(playerCollection);
        
    }

    public static void main(String[] args) {
        playerProfileConfigFileName = "PlayerProfileConfig.txt";
        spriteConfigFileName = "SpriteConfig.txt";
        objectConfigFileName = "ObjectConfig.txt";

        
       playerCollection = IOController.readPlayerProfiles(playerProfileConfigFileName);
        spriteCollection = IOController.readSpriteConfigFile(spriteConfigFileName);
        levelCollection = IOController.readObjectConfigFile(objectConfigFileName);
        args = new String[]{playerCollection.toString(), spriteCollection.toString(), levelCollection.toString()};
        for (int i = 0; i < 3; i++) {

            System.out.println(args[i]);
        }
        launch(args);

    } 
    
   
}
