/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongcontroller;

import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import thekongmodel.LevelCollection;
import thekongmodel.LevelData;
import thekongmodel.SpriteDataCollection;
import thekongview.HeroView;
import thekongview.PlayAreaView;

/**
 *
 * @author Justi
 */
public class AnimationController extends AnimationTimer {
   private PlayAreaView playareaview; 
   private HeroView hero;
   public  double gravity=10; 
   public boolean jump;
   public boolean falling;
   public long frame;
   public long frameIn;
   public final double speedPlayer=2.0;
   long last;
   boolean goleft,goright,goup,godown;
   public int changer;
   
   private long lastValue=0;
   public AnimationController(PlayAreaView playareaview){ 
    this.playareaview=playareaview;
   //this.hero=playview.getHero();
   this.gravity=10;
   this.falling=false;
   this.jump=false;
   this.frame=0;
   this.frameIn=0;
    this.last=0;
   } 
    
    
    
   @Override
    
    public void handle(long nsec){  
        
        upgrade();
        
        
        
        
        
        
        
        
        
        
    }
        









 public void upgrade(){
          
          if(playareaview.getHero().getCenterX()-playareaview.getHero().getBoundingRadius()<0){ //LEFT BOUND (X-AXIS)
    
   playareaview.getHero().setSpeed(0.2);
 playareaview.getHero().setX(0);
    System.out.println("crashed");
}  
 
          
  
             
          if(playareaview.getHero().getCenterX()+playareaview.getHero().getBoundingRadius()>playareaview.getLevelView().getWidth()){//RIGHT BOUND(X-AXIS)
         playareaview.getHero().setSpeed(0.2);
     
        playareaview.getHero().setX(480);
        System.out.println("kaboom");
        
} 
          
          if(playareaview.getHero().getCenterY()-playareaview.getHero().getBoundingRadius()<0){ //UPWARD Y BOUND
              playareaview.getHero().setDirection(90);
              System.out.println("executed 1");
          }
          
//         if(playareaview.getHero().getCenterY()+playareaview.getHero().getBoundingRadius()>playareaview.getLevelView().getHeight()){ //DOWN Y BOUND
//           // if( playareaview.getHero().getY()+playareaview.getHero().getBoundingRadius() *2 >= playareaview.getHeight()){
//             
//             //playareaview.getHero().setY(playareaview.getHeight());
//             System.out.println("executed 2");
//         }
//         
         
//         
//      if(goup){ 
//playareaview.getHero().setDirection(270);
////            System.out.println("goup");
////          if(!jump){
////             jump=true; 
////              System.out.println("jumping is now true"); 
////            
////          }
////          
////playareaview.getHero().setY(playareaview.getHero().getY()-gravity);
////       playareaview.getHero().setDirection(270);
//        playareaview.getHero().setSpeed(5);
// //System.out.println(heroOnFloor(playareaview)+" rrrr");
//                    System.out.println("GOING UP");
//         
//                    
//         
        // }
         
////          if(jump){
////              gravity-=.1;
////              playareaview.getHero().setY(playareaview.getHero().getY()-gravity);
////          }
////     
////          if(gravity<=0.0){
////              jump=false;
////              falling =true;
////              
////          } 
////          
////          
////          if(falling){
////              gravity+=.1;
////              playareaview.getHero().setY(playareaview.getHero().getY()+gravity);
////          }
         
        if(godown){ 
            //playareaview.getHero().setY(playareaview.getHero().getY()+1);
      // playareaview.getHero().setDirection(90);
        //   playareaview.getHero().setSpeed(5);
//               playareaview.getHero().setY(playareaview.getHero().getY()+1);
          // System.out.println(playareaview.getHero().getY());
          //System.out.println(heroOnFloor(playareaview)+ " rrrr");
              System.out.println("GOING DOWN");
          }
         
          
        
        if(goright){ 
           // int one=1;
           playareaview.getHero().setX(playareaview.getHero().getX()+gravity);
              //playareaview.getHero().setDirection(playareaview.getHero().getDirection()+gravity);
         //playareaview.getHero().setX(playareaview.getHero().getX()+1);
//          playareaview.getHero().setDirection(0);
//         playareaview.getHero().setSpeed(5); 
          
//         if(jump){
//             playareaview.getHero().setSpeed(5);
//          }
//System.out.println(playareaview.getHero().getX());
//System.out.println(heroOnFloor(playareaview)+ " rrr");
System.out.println(playareaview.getHero().getSpeed()+" speed right");
             System.out.println("GOING RIGHT");
        }
       
        if(goleft){ 
           
           playareaview.getHero().setX(playareaview.getHero().getX()-gravity);
            //playareaview.getHero().setDirection(180);
         //playareaview.getHero().setDirection(playareaview.getHero().getDirection()-gravity);
        // playareaview.getHero().setSpeed(5);
           // System.out.println(playareaview.getHero().getX());
      //   System.out.println(heroOnFloor(playareaview)+" rrrr");
         System.out.println(playareaview.getHero().getSpeed()+" speed left");
              System.out.println("GOING LEFT");
        } 
        
        
        
//         if(jump){ 
//               
//
//            gravity-=1;
//              playareaview.getHero().setY(playareaview.getHero().getY()-gravity);
//              
//             // System.out.println(heroOnFloor(playareaview)+" rrr");
//              System.out.println("jumping");
//              System.out.println(gravity);
//          }
//     
//          if(gravity<=0.0){
//             jump=false;
//              goup=false;
//              
//             falling =true;
//             System.out.println("gravity<=0!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//               
//          } 
//          
//          
//          if(falling){
//             gravity+=.1;
//                  //playareaview.getHero().setSpeed(0);
//              //playareaview.getHero().setDirection(90);
//              playareaview.getHero().setY(playareaview.getHero().getY()+gravity);
//          
//          }
//        
//        
//        
//        
        
        
        
        
       
       if(!heroOnladder(playareaview) && !heroOnFloor(playareaview) && !heroOnPlatform(playareaview) ){ 
         
            if(jump){ 
            // playareaview.getHero().setSpeed(5);
              //playareaview.getHero().setDirection(270);

            gravity-=1;
              playareaview.getHero().setY(playareaview.getHero().getY()-gravity);
              
             // System.out.println(heroOnFloor(playareaview)+" rrr");
              System.out.println("jumpppppppppppppppppppppppppppppinnnnnnnnnnnnnnnnnnggggggggggggggggg");
             // System.out.println(playareaview.getHero().getDirection()+" direction");
             // System.out.println(playareaview.getHero().getSpeed()+" speed");
              System.out.println(gravity+ " gravity");
             //System.out.println(playareaview.getHero().getY()+" y pos");
             //System.out.println(playareaview.getHero().getSpeed());
          }
     
          if(gravity<=0.0){
             jump=false;
              goup=false;
//              
//                 playareaview.getHero().setSpeed(0);
//              playareaview.getHero().setDirection(0);
             falling =true;
              System.out.println("gravity<=0!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
               
          } 
          
          
          if(falling){
             gravity+=3;
              //  playareaview.getHero().setSpeed(1);
            // playareaview.getHero().setDirection(90);
              playareaview.getHero().setY(playareaview.getHero().getY()+gravity);
          
              //playareaview.getHero().setSpeed(3);
              
            System.out.println("falling");
//              System.out.println(playareaview.getHero().getSpeed());
//              
//              System.out.println(heroOnFloor(playareaview)+" rrr");
              
          }
       }  
          
//          if(heroOnFloor(playareaview)){//if hero is on floor or lands on floor
//           playareaview.getHero().setY(playareaview.getHeight()-(playareaview.getHero().getBoundingRadius()*2)+1);   
//          playareaview.getHero().setSpeed(0);
//          playareaview.getHero().setDirection(0);
//           
//           if(jump){
//               playareaview.getHero().setDirection(270);
//               playareaview.getHero().setSpeed(2);
//              playareaview.getHero().setY(playareaview.getHero().getY()-gravity);
//           }
//           
//           if(falling){
//               playareaview.getHero().setDirection(90);
//              playareaview.getHero().setSpeed(1);
//               
//              
//              System.out.println(" ffffffffffffffffffffffffffffffffffffffff");
//           }
//           
//           
 
         // }
           
//          if(goup && goright){
     
          //playareaview.getHero().setY(playareaview.getHero().getY()+gravity);
         //playareaview.getHero().setDirection(playareaview.getHero().getDirection()+gravity);
         //playareaview.getHero().setSpeed(5);
//         
//          System.out.println(playareaview.getHero().getDirection()+ " direction");
//          System.out.println(playareaview.getHero().getSpeed()+ " Speed");
//          System.out.println(playareaview.getHero().getX()+ " X cord");
          //System.out.println("GRAVITY");
      // }
          
       
//      }else if (goup && goleft){
//                  playareaview.getHero().setX(playareaview.getHero().getX()-gravity);
//         playareaview.getHero().setY(playareaview.getHero().getY()+gravity);
//           System.out.println("LEFT GRAVITY");
//          }
//        }
        
//        if(goup && goleft){ 
//           // System.out.println(playareaview.getHero().getDirection()+" DIRECTION");
//            playareaview.getHero().setSpeed(5);
//           // playareaview.getHero().setX(playareaview.getHero().getX()-gravity);
//             playareaview.getHero().setY(playareaview.getHero().getY()-gravity);
//             System.out.println(playareaview.getHero().getY()+" Left Direction");
//            System.out.println("going up and to the left");
//        }
//        
        
        
//        if(goup && goright){ 
//          System.out.println(playareaview.getHero().getDirection()+" DIRECTION");
//            playareaview.getHero().setSpeed(5);
//           // playareaview.getHero().setX(playareaview.getHero().getX()+gravity);
//          playareaview.getHero().setY(playareaview.getHero().getY()-gravity);
//       
//            System.out.println(playareaview.getHero().getY()+" right Direction");
//            System.out.println("going up and to the right");
//        }
        
//        //System.out.println(playareaview.getHero().getBoundsInParent().getMinX());
////      System.out.println(playareaview.getLevelView().getWidth());
         //System.out.println(playareaview.getHero().getY()+" LAYOUT Y ");
//        System.out.println(playareaview.getHero().getX()+" LAYOUT X ");
////         System.out.println(playareaview.getHero().getCenterY()+" CENTER Y");
//        System.out.println(playareaview.getHero().getCenterX()+" CENTER X ");
////       System.out.println(playareaview.getHero().getBoundsInParent()+ " bound parent");
////       System.out.println(playareaview.getHero().getBoundingRadius()+" Bounding radius");
////       System.out.println(playareaview.getHero().getBoundsInLocal()+" bound local");

//System.out.println(playareaview.getLevelView().getPlatformView(7).getWidth()+" Height");
//System.out.println(playareaview.getLevelView().getPlatformView(8).getY()+" Y COORDINATE");
//System.out.println(heroOnFloor(playareaview));
//System.out.println(heroOnladder(playareaview));
//System.out.println(heroOnPlatform(playareaview));
//playareaview.getHero().move();
       playareaview.moveSprites();
      }


 
 
 
 
   public boolean heroOnladder(PlayAreaView playareaview){
         
        
          for(int i=0;i<playareaview.getLevelView().getNumLadders();i++){
if(playareaview.getHero().getBoundsInParent().intersects(playareaview.getLevelView().getLadder(i).getBoundsInLocal() )){  
    //playareaview.getHero().setY(playareaview.getLevelView().getLadder(i).getY()-playareaview.getHero().getBoundingRadius());
    System.out.println("Touched ladder");
       return true;
}
          }
          return false;
     } 
    
    
public boolean heroOnPlatform(PlayAreaView playareaview){
    
    for(int i=0;i<playareaview.getLevelView().getNumPlatforms();i++){
     
        if(playareaview.getHero().getY()>=playareaview.getLevelView().getPlatformView(i).getY()-playareaview.getHero().getBoundingRadius() *2 && playareaview.getHero().getY()<=playareaview.getLevelView().getPlatformView(i).getY()+playareaview.getLevelView().getPlatformView(i).getHeight()-playareaview.getHero().getBoundingRadius()*2){
            
        if(playareaview.getHero().getX() > playareaview.getLevelView().getPlatformView(i).getX() && playareaview.getHero().getX() < playareaview.getLevelView().getPlatformView(i).getX()+  playareaview.getLevelView().getPlatformView(i).getWidth() || playareaview.getHero().getX()+playareaview.getHero().getBoundingRadius()*2 > playareaview.getLevelView().getPlatformView(i).getX() && playareaview.getHero().getX()+playareaview.getHero().getBoundingRadius()*2<playareaview.getLevelView().getPlatformView(i).getX()+playareaview.getLevelView().getPlatformView(i).getWidth()){ 
            
            playareaview.getHero().setDirection(0);
         playareaview.getHero().setSpeed(0);
            
          playareaview.getHero().setY(playareaview.getLevelView().getPlatformView(i).getY()-playareaview.getHero().getBoundingRadius()*2);
            System.out.println("MARIO ON PLATFORM");
           
            if(jump){
                playareaview.getHero().setDirection(270);
                playareaview.getHero().setSpeed(5);
            }

if(godown){ 
    //falling=true;
    
     playareaview.getHero().setDirection(90);
                playareaview.getHero().setSpeed(5);
                playareaview.getHero().setY(playareaview.getHero().getY()+gravity);
}
            
        return true;
        
        }
    }
    } 
    //System.out.println("Marios off platform");
 return false;   
}
  
  
        
      public boolean heroOnFloor(PlayAreaView playareaview){
         if(playareaview.getHero().getY()+playareaview.getHero().getBoundingRadius() *2 >= playareaview.getHeight()){
             playareaview.getHero().setY(playareaview.getHeight()-(playareaview.getHero().getBoundingRadius()*2)+1);
             
        playareaview.getHero().setSpeed(0);
       playareaview.getHero().setDirection(0);
            System.out.println("MARIO ON FLOOR");
            // System.out.println(playareaview.getHeight()+" height ");
             //System.out.println(playareaview.getHero().getY()+" y pos ");
             
             if(falling){
                 falling = false;
             }else{
                 if(!falling && !! jump){
                     gravity=0.0;
                     falling=true;
                 }
             }
             
             
            if(jump){  
               //playareaview.getHero().setDirection(270);
               // playareaview.getHero().setSpeed(5); 
                gravity=10;
                 gravity-=1;
                 playareaview.getHero().setY(playareaview.getHero().getY()-gravity); 
                 System.out.println(gravity+ " the amount of gravity");
                 //System.out.println(playareaview.getHero().getDirection()+" directionssss");
                 System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
             } 
            
            if(gravity<=0.0){
                jump=false;
                goup=false;
                falling=true;
                //System.out.println("gravity");
            }
             
            if(falling){
                gravity+=3;
//                playareaview.getHero().setDirection(90);
//                playareaview.getHero().setSpeed(2);
                playareaview.getHero().setY(playareaview.getHero().getY()+gravity);
            }
             return true;         
     }
//         if(godown){
//              //playareaview.getHero().setY(playareaview.getHeight()+playareaview.getHero().getBoundingRadius());
//         }
         
         System.out.println("Mario's off floor");
             return false;
      

      }


 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
}






























        
       // HeroView hero=playview.getHero();
        
//       MainController control=new MainController();
//
//if(playview.getHero().getCenterX()-playview.getHero().getBoundingRadius()<0){ //LEFT BOUND (X-AXIS)
//    
//   playview.getHero().setSpeed(0.2);
//   playview.getHero().setDirection(0.0);//Code that sets bounds
//  // playview.getHero().move();
//   playview.getHero().setSpeed(2.0);
//    //playview.getHero().move();
//    System.out.println("crashed");
//} 
//
//
//if(playview.getHero().getCenterX()+playview.getHero().getBoundingRadius()>playview.getLevelView().getWidth()){//RIGHT BOUND(X-AXIS)
//         //playview.getHero().setDirection(180);//Code that sets bounds
//         //playview.getHero().setX(180);
//         playview.getHero().setSpeed(0.2);
//       // playview.getHero().move();
//        playview.getHero().setX(480);
//        System.out.println("kaboom");
//        
//} 
//
//if(playview.getHero().getCenterY()-playview.getHero().getBoundingRadius()<0){ //UPWARD Y BOUND
//   
//    
//    playview.getHero().setSpeed(0.2);
//   playview.getHero().setDirection(90);//Code that sets bounds
//  // playview.getHero().move();
//   playview.getHero().setSpeed(2);
//    //playview.getHero().move();
//    System.out.println("DOWNWARDS YOU GO");
//    
//    
//}
//
//    
////    if(playview.getHero().getCenterY()+playview.getHero().getBoundingRadius()>playview.getLevelView().getHeight()){ //DOWNWARD Y BOUND
////        
////        playview.getHero().setSpeed(0.2);
////   playview.getHero().setDirection(270);//Code that sets bounds
////  // playview.getHero().move();
////   playview.getHero().setSpeed(2.0);
////    //playview.getHero().move();
////    System.out.println("UPWARDS YOU G1O");
////    } 
////    if(!heroOnladder(playview) && !heroOnFloor(playview) && !heroOnPlatform(playview)){
////    if(playview.getHero().getSpeed()==0){//means going left
////     
////        playview.getHero().setX(playview.getHero().getX()-gravity);
////          playview.getHero().setY(playview.getHero().getY()+gravity);
////          
////          System.out.println("Jumping Left!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
////    }
////    }
//    
//    
//  if(!heroOnladder(playview) && !heroOnFloor(playview) && !heroOnPlatform(playview) ){ 
//    
//      playview.getHero().setX(playview.getHero().getX()+gravity);
//          playview.getHero().setY(playview.getHero().getY()+gravity);
//          
//          System.out.println("GRAVITY");
//      }
//  
//  if(playview.getHero().getDirection()==270){ //moving up //up key           //||playview.getHero().getDirection()==90){
//      //if(heroOnladder(playview)){
//      int dy=0;
//      playview.getHero().setY(playview.getHero().getY()-1);
//      //control.upPressed.set(true);
//         
//         System.out.println("GOING UP");
//  }
//  
//  
////  if( playview.getHero().getDirection()==180){
////      playview.getHero().setDirection(270);
////       playview.getHero().setX(playview.getHero().getX()-gravity);
////          playview.getHero().setY(playview.getHero().getY()+gravity); 
////          System.out.println("LLLLLL");
////  }
////  
//  
//  if(playview.getHero().getDirection()==90){//moving down //downkey
//      int dy=0;
//     playview.getHero().setY(playview.getHero().getY()+1);
//      System.out.println("GOING DOWN");
//  } 
//  
// 
//  
//
//  
////     /* }*/}else {
////          playview.getHero().setSpeed(0);
////          playview.getHero().setDirection(0);
////          System.out.println("No speed and direction");
////      }
//  
//  if(playview.getHero().getDirection()==0/*0*/){ //Moving right  //right key
//   int dx=0;
//    playview.getHero().setX(playview.getHero().getX()+1);
//      
//     System.out.println("Moving RIGHT");
//  }
//  
//  
//  
//  if(playview.getHero().getDirection()==180){//moving left  //left key
//     int dx=0;
//      playview.getHero().setX(playview.getHero().getX()-1);
//      
//      System.out.println("MOVING LEFT");
//      control.leftPressed.set(true);
//  }
//  
//  
//  
////  if(control.leftPressed.get()){
////       playview.getHero().setX(playview.getHero().getX()-gravity);
////          playview.getHero().setY(playview.getHero().getY()+gravity);
////          System.out.println("&&");
////  
////      if(control.upPressed.get()){
////         playview.getHero().setX(playview.getHero().getX()-gravity);
////          playview.getHero().setY(playview.getHero().getY()+gravity);
////      
////      System.out.println("Both keys pressed!!!!!!!!!!!!!!!!!!!!!!!!!");
////  }
//    
//
//    if(jump){
//    if(frame-frameIn<10){
//        playview.getHero().setY(playview.getHero().getY()-gravity*2.5);
//    }else{
//        jump=false;
//    }
//}
// 
//    
//     
//   //
//
//               
////if((nsec-last)>10){ 
////System.out.println(playview.getHero().getX());
//        playview.moveSprites();
//        //frame+=1;
//} 
////last=nsec;
////    }
//
//    public boolean heroOnladder(PlayAreaView playview){
//         
//        
//          for(int i=0;i<playview.getLevelView().getNumLadders();i++){
//if(this.playview.getHero().getBoundsInParent().intersects(playview.getLevelView().getLadder(i).getBoundsInLocal() )){ 
//    System.out.println("Touched ladder");
//       return true;
//}
//          }
//          return false;
//     } 
//    
//    
//public boolean heroOnPlatform(PlayAreaView playview){
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
//   // System.out.println("Colliiiisssion!!!!!!!!!!!!!!!!!!!!!");
//    
//
//        
//      public boolean heroOnFloor(PlayAreaView playview){
//         if(playview.getHero().getY()+playview.getHero().getBoundingRadius() *2 >= playview.getHeight()){
//             return true;         
//     }
//             return false;
//      
////if(playview.getHero().getCenterY()-playview.getHero().getBoundingRadius()<=0){///Y AXIS
//// playview.getHero().setSpeed(0.2);
////   //playview.getHero().setY(playview.getHero().getY()+6);   
////     playview.getHero().setDirection(90);
////} 
////if(playview.getHero().getCenterY()+playview.getHero().getBoundingRadius()>=playview.getLevelView().getHeight()){//UP Y-AXis
////    
////      playview.getHero().setSpeed(0.2);
////   playview.getHero().setDirection(270);
////   
////}else if (playview.getHero().getCenterY()-playview.getHero().getBoundingRadius()>=0 || playview.getHero().getCenterY()+playview.getHero().getBoundingRadius()<=playview.getLevelView().getHeight()  ){
////  // playview.getHero().setDirection(270);
////     playview.getHero().setY(2+6);
////}
////
//
//
//
//      }
//              } 
// 
////         playview.getHero().setY(playview.getHero().getY()+6);   
////    System.out.println("gravity");
////     }
//     //playview.getHero().setX(playview.getHero().getCenterX()-playview.getHero().getBoundingRadius());   
//    
//
//
//
//
// 
//
////      this.playview.moveSprites(); 
////   System.out.println("AnimationController called");
//         
//   
//        // lastValue=nsec;
//    
//   
//    
