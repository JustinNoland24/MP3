/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongcontroller;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import thekongmodel.LevelCollection;
import thekongmodel.LevelData;
import thekongmodel.PlayerProfile;
import thekongmodel.PlayerProfileCollection;
import thekongmodel.SpriteDataCollection;
import thekongview.CommandView2;
import thekongview.GameView2;
import thekongview.PlayAreaView;
import thekongview.StatusView2;

/**
 *
 * @author Justi
 */
public class MainControl extends Application {
     private static String playerProfileConfigFileName;
    private static String spriteConfigFileName;
    private static String objectConfigFileName;
    private static PlayerProfileCollection playerCollection;
    private static SpriteDataCollection spriteCollection;
    private static LevelCollection levelCollection;
    private  PlayAreaView playareaview;
    boolean goleft,goright,goup,godown;
    AnimationController animation;
    
  @Override
  public void start(Stage stage){
   
      
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
    animation=new AnimationController(playareaview);
 
  
//  AnimationController animation=new AnimationController(playareaview){
//     
//      
//      @Override
//      public void handle(long now){
//        upgrade();
//         
//      }
//       
//  };
     
      scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
      
          @Override
          public void handle(KeyEvent event){ 
              
              switch(event.getCode()){
              case UP:// animation.goup = true; 
                  
              animation.jump=true;
              animation.gravity=12.5;
              //playareaview.getHero().setY(playareaview.getHero().getY()+animation.gravity);
   // playareaview.getHero().setDirection(270);
     //    playareaview.getHero().setSpeed(5);
              break;
              
              
              case DOWN:animation.godown = true; 
                playareaview.getHero().setDirection(90);
           playareaview.getHero().setSpeed(5);
              break;
              
              
              case RIGHT: animation.goright = true;
//                playareaview.getHero().setDirection(0);
//           playareaview.getHero().setSpeed(5);
              break;
              
              
              case LEFT:animation.goleft = true;
//               playareaview.getHero().setDirection(180);
//           playareaview.getHero().setSpeed(5);
              break;
              
              
              
              
              }  
              // animation=new AnimationController(playareaview);
          }
          
          
  }); 
      
      
      
  scene.setOnKeyReleased(new EventHandler<KeyEvent>(){
     
      @Override
      public void handle(KeyEvent event){
          
          switch(event.getCode()){
              case UP: animation.goup = false;
              playareaview.getHero().setDirection(0);
              playareaview.getHero().setSpeed(0);
              break;
              
              case DOWN:animation.godown = false;
              playareaview.getHero().setDirection(0);
              playareaview.getHero().setSpeed(0);
              break;
              
              case RIGHT: animation.goright = false;
               playareaview.getHero().setDirection(0);
              playareaview.getHero().setSpeed(0);
              break;
              
              case LEFT:animation.goleft = false;
               playareaview.getHero().setDirection(0);
              playareaview.getHero().setSpeed(0);
              break;
              
          
          
      }
      }
      
  });
   
  
  stage.setScene(scene);
  stage.show();
  
   
  
  command.getStartButton().setOnAction(event->{
    animation.start();
    
});

 command.getEndButton().setOnAction(event->{
  System.exit(0);
 });
  
  
  
  }
//         public boolean heroOnladder(PlayAreaView playareaview){
//         
//        
//          for(int i=0;i<playareaview.getLevelView().getNumLadders();i++){
//if(playareaview.getHero().getBoundsInParent().intersects(playareaview.getLevelView().getLadder(i).getBoundsInLocal() )){ 
//    System.out.println("Touched ladder");
//       return true;
//}
//          }
//          return false;
//     } 
//    
    
//public boolean heroOnPlatform(PlayAreaView playareaview){
//    
//    for(int i=0;i<playareaview.getLevelView().getNumPlatforms();i++){
//     
//        if(playareaview.getHero().getY()>=playareaview.getLevelView().getPlatformView(i).getY()-playareaview.getHero().getBoundingRadius() *2 && playareaview.getHero().getY()<=playareaview.getLevelView().getPlatformView(i).getY()+playareaview.getLevelView().getPlatformView(i).getHeight()-playareaview.getHero().getBoundingRadius()*2){
//            
//        if(playareaview.getHero().getX() > playareaview.getLevelView().getPlatformView(i).getX() && playareaview.getHero().getX() < playareaview.getLevelView().getPlatformView(i).getX()+  playareaview.getLevelView().getPlatformView(i).getWidth() || playareaview.getHero().getX()+playareaview.getHero().getBoundingRadius()*2 > playareaview.getLevelView().getPlatformView(i).getX() && playareaview.getHero().getX()+playareaview.getHero().getBoundingRadius()*2<playareaview.getLevelView().getPlatformView(i).getX()+playareaview.getLevelView().getPlatformView(i).getWidth()){
//            System.out.println("MARIO ON PLATFORM");
//            
//        return true;
//        
//        }
//    }
//    }  
// return false;   
//}
//  
//  
//        
//      public boolean heroOnFloor(PlayAreaView playareaview){
//         if(playareaview.getHero().getY()+playareaview.getHero().getBoundingRadius() *2 >= playareaview.getHeight()){
//             System.out.println("MARIO ON FLOOR");
//             return true;         
//     }
//             return false;
//      
//
//      }
//

 

//       public void upgrade(){
//          
//          if(playareaview.getHero().getCenterX()-playareaview.getHero().getBoundingRadius()<0){ //LEFT BOUND (X-AXIS)
//    
//   playareaview.getHero().setSpeed(0.2);
// playareaview.getHero().setX(0);
//    System.out.println("crashed");
//}  
// 
//          
//  
//             
//          if(playareaview.getHero().getCenterX()+playareaview.getHero().getBoundingRadius()>playareaview.getLevelView().getWidth()){//RIGHT BOUND(X-AXIS)
//         playareaview.getHero().setSpeed(0.2);
//     
//        playareaview.getHero().setX(480);
//        System.out.println("kaboom");
//        
//} 
//          
//          if(playareaview.getHero().getCenterY()-playareaview.getHero().getBoundingRadius()<0){ //UPWARD Y BOUND
//              playareaview.getHero().setDirection(90);
//              System.out.println("executed 1");
//          }
//          
////         if(playareaview.getHero().getCenterY()+playareaview.getHero().getBoundingRadius()>playareaview.getLevelView().getHeight()){ //DOWN Y BOUND
////           // if( playareaview.getHero().getY()+playareaview.getHero().getBoundingRadius() *2 >= playareaview.getHeight()){
////             
////             //playareaview.getHero().setY(playareaview.getHeight());
////             System.out.println("executed 2");
////         }
////         
//         
//         
//        if(goup){ 
//          if(!animation.jump){
//             animation.jump=true; 
//            
//          }
//          
////            playareaview.getHero().setY(playareaview.getHero().getY()-1);
////         playareaview.getHero().setDirection(270);
////        playareaview.getHero().setSpeed(5);
// //System.out.println(heroOnFloor(playareaview)+" rrrr");
//                    System.out.println("GOING UP");
//         
//                    
//         
//          }
//         
//////          if(jump){
//////              gravity-=.1;
//////              playareaview.getHero().setY(playareaview.getHero().getY()-gravity);
//////          }
//////     
//////          if(gravity<=0.0){
//////              jump=false;
//////              falling =true;
//////              
//////          } 
//////          
//////          
//////          if(falling){
//////              gravity+=.1;
//////              playareaview.getHero().setY(playareaview.getHero().getY()+gravity);
//////          }
//         
//        if(godown){ 
//            //playareaview.getHero().setY(playareaview.getHero().getY()+1);
//      // playareaview.getHero().setDirection(90);
//        //   playareaview.getHero().setSpeed(5);
////               playareaview.getHero().setY(playareaview.getHero().getY()+1);
//          // System.out.println(playareaview.getHero().getY());
//          //System.out.println(heroOnFloor(playareaview)+ " rrrr");
//              System.out.println("GOING DOWN");
//          }
//         
//          
//        
//        if(goright){ 
//           // int one=1;
//             playareaview.getHero().setX(playareaview.getHero().getX()+animation.gravity);
//              //playareaview.getHero().setDirection(playareaview.getHero().getDirection()+gravity);
//         //playareaview.getHero().setX(playareaview.getHero().getX()+1);
//            //playareaview.getHero().setDirection(0);
//           //playareaview.getHero().setSpeed(5);
////System.out.println(playareaview.getHero().getY());
////System.out.println(heroOnFloor(playareaview)+ " rrr");
//System.out.println(playareaview.getHero().getSpeed());
//              System.out.println("GOING RIGHT");
//        }
//       
//        if(goleft){ 
//           
//            playareaview.getHero().setX(playareaview.getHero().getX()-animation.gravity);
//            
//         //playareaview.getHero().setDirection(playareaview.getHero().getDirection()-gravity);
//         playareaview.getHero().setSpeed(5);
//            
//      //   System.out.println(heroOnFloor(playareaview)+" rrrr");
//         System.out.println(playareaview.getHero().getSpeed());
//              System.out.println("GOING LEFT");
//        } 
//        
//        
//        
//       
//       if(!heroOnladder(playareaview) /*&& !heroOnFloor(playareaview)*/ && !heroOnPlatform(playareaview) ){ 
//         
//            if(animation.jump){ 
//               
//                //playareaview.getHero().setDirection(270);
//              animation.gravity-=.1;
//              playareaview.getHero().setY(playareaview.getHero().getY()-animation.gravity);
//              
//             // System.out.println(heroOnFloor(playareaview)+" rrr");
//              System.out.println("jumping");
//          }
//     
//          if(animation.gravity<=0.0){
//              animation.jump=false;
//              goup=false;
//              
//              animation.falling =true;
//             // System.out.println("gravity<=0!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//               
//          } 
//          
//          
//          if(animation.falling){
//              animation.gravity+=.1;
//                  //playareaview.getHero().setSpeed(0);
//              //playareaview.getHero().setDirection(90);
//              playareaview.getHero().setY(playareaview.getHero().getY()+animation.gravity);
//          
//              //playareaview.getHero().setSpeed(3);
//              
//             System.out.println("falling");
////              System.out.println(playareaview.getHero().getSpeed());
////              
////              System.out.println(heroOnFloor(playareaview)+" rrr");
//              
//          }
//           
//          
//          
//           
////          if(goup && goright){
//     
//          //playareaview.getHero().setY(playareaview.getHero().getY()+gravity);
//         //playareaview.getHero().setDirection(playareaview.getHero().getDirection()+gravity);
//         //playareaview.getHero().setSpeed(5);
////         
////          System.out.println(playareaview.getHero().getDirection()+ " direction");
////          System.out.println(playareaview.getHero().getSpeed()+ " Speed");
////          System.out.println(playareaview.getHero().getX()+ " X cord");
//          System.out.println("GRAVITY");
//       }
//          
//       
////      }else if (goup && goleft){
////                  playareaview.getHero().setX(playareaview.getHero().getX()-gravity);
////         playareaview.getHero().setY(playareaview.getHero().getY()+gravity);
////           System.out.println("LEFT GRAVITY");
////          }
////        }
//        
////        if(goup && goleft){ 
////           // System.out.println(playareaview.getHero().getDirection()+" DIRECTION");
////            playareaview.getHero().setSpeed(5);
////           // playareaview.getHero().setX(playareaview.getHero().getX()-gravity);
////             playareaview.getHero().setY(playareaview.getHero().getY()-gravity);
////             System.out.println(playareaview.getHero().getY()+" Left Direction");
////            System.out.println("going up and to the left");
////        }
////        
//        
//        
////        if(goup && goright){ 
////          System.out.println(playareaview.getHero().getDirection()+" DIRECTION");
////            playareaview.getHero().setSpeed(5);
////           // playareaview.getHero().setX(playareaview.getHero().getX()+gravity);
////          playareaview.getHero().setY(playareaview.getHero().getY()-gravity);
////       
////            System.out.println(playareaview.getHero().getY()+" right Direction");
////            System.out.println("going up and to the right");
////        }
//        
////        //System.out.println(playareaview.getHero().getBoundsInParent().getMinX());
//////      System.out.println(playareaview.getLevelView().getWidth());
//         //System.out.println(playareaview.getHero().getY()+" LAYOUT Y ");
////        System.out.println(playareaview.getHero().getX()+" LAYOUT X ");
//////         System.out.println(playareaview.getHero().getCenterY()+" CENTER Y");
////        System.out.println(playareaview.getHero().getCenterX()+" CENTER X ");
//////       System.out.println(playareaview.getHero().getBoundsInParent()+ " bound parent");
//////       System.out.println(playareaview.getHero().getBoundingRadius()+" Bounding radius");
//////       System.out.println(playareaview.getHero().getBoundsInLocal()+" bound local");
//
////System.out.println(playareaview.getLevelView().getPlatformView(7).getWidth()+" Height");
////System.out.println(playareaview.getLevelView().getPlatformView(8).getY()+" Y COORDINATE");
////System.out.println(heroOnFloor(playareaview));
////System.out.println(heroOnladder(playareaview));
////System.out.println(heroOnPlatform(playareaview));
////playareaview.getHero().move();
//       playareaview.moveSprites();
//      }
      
  
    
    
  public static void main(String []args){
      launch(args);
  }  
  
}
