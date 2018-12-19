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
import thekongview.BarrelView;
import thekongview.HeroView;
import thekongview.PlayAreaView;

/**
 *
 * @author Justi
 */
public class AnimationController extends AnimationTimer {

    private PlayAreaView playareaview;
    private HeroView hero;
    public double gravity = 10;
    public boolean jump;
    public boolean falling;
    public long frame;
    public long frameIn;
    public final double speedPlayer = 2.0;
    long last;
    boolean goleft, goright, goup, godown;
    public int changer;
    public boolean rolling;
    private long lastValue = 0;
    public double timer;
    public boolean princesspace;
    public double pacetimer;
    public double lefttimer;
    public double righttimer;
    public double jumptimer;
    public double princemove;
    public boolean princessmovingleft = false;
    public double princesslefttimer;
    public double princetimer;

    public boolean reachedrightside;
    public boolean reachedleftside;
    public double constantmovement;

    public double barrelgravitynumber;
    public int rightorleft;
    public int barrelframe;
    public int barrelframedelay;
    public boolean barrelanimate;
    public boolean konganimate;
    public int kongframe;
    public int kongframedelay;

    public AnimationController(PlayAreaView playareaview) {
        this.playareaview = playareaview;
        //this.hero=playview.getHero();
        this.gravity = 10;
        this.falling = false;
        this.jump = false;
        this.frame = 0;
        this.frameIn = 0;
        this.last = 0;
        this.rolling = false;
        this.changer = 4;
        this.timer = 0;
        this.pacetimer = 0;
        this.lefttimer = 0;
        this.righttimer = 0;
        this.jumptimer = 0;
        this.princemove = 0;
        this.princessmovingleft = false;
        this.princesslefttimer = 0;
        this.princetimer = 0;
        this.constantmovement = 0;
        this.reachedleftside = false;
        this.reachedrightside = false;
        this.rightorleft = 0;//0 is right and 1 is left
        this.barrelframe = 0;
        this.barrelframedelay = 0;
        this.barrelanimate = false;

        this.konganimate = false;
    }

    @Override

    public void handle(long nsec) {

        upgrade();

    }

    public void upgrade() {

        if (konganimate) {
            kongframedelay++;
            if (kongframedelay >= 40) {
                kongframe++;
                if (kongframe >= 4) {
                    kongframe = 0;
                }
                kongframedelay = 0;
            }

        }

        if (kongframe == 1) {
            playareaview.getKong().setViewport(playareaview.getKong().getFacingForwardViewPort());
        }
        if (kongframe == 2) {
            playareaview.getKong().setViewport(playareaview.getKong().getMovingLeftViewPort());
        }
        if (kongframe == 3) {
            playareaview.getKong().setViewport(playareaview.getKong().getMovingRightViewPort());
        }
        if (kongframe == 4) {
            playareaview.getKong().setViewport(playareaview.getKong().getThrowingBarrelViewPort());
        }

        if (playareaview.getHero().getCenterX() - playareaview.getHero().getBoundingRadius() < 0) { //LEFT BOUND (X-AXIS)

            playareaview.getHero().setSpeed(0.2);
            playareaview.getHero().setX(0);
            System.out.println(" reached left limit");
        }

        if (playareaview.getHero().getCenterX() + playareaview.getHero().getBoundingRadius() > playareaview.getLevelView().getWidth()) {//RIGHT BOUND(X-AXIS)
            playareaview.getHero().setSpeed(.2);

            playareaview.getHero().setX(480);

        }

        if (playareaview.getHero().getCenterY() - playareaview.getHero().getBoundingRadius() < 0) { //UPWARD Y BOUND
            playareaview.getHero().setDirection(90);

        }

        if (godown) {

        }

        if (goright) {

            righttimer += 1;
            playareaview.getHero().setViewport(playareaview.getHero().getRunningRightViewPortTwo());
            if (righttimer >= 2) {
                playareaview.getHero().setViewport(playareaview.getHero().getRunningRightViewPortOne());
                righttimer = 0;
            }
            playareaview.getHero().setX(playareaview.getHero().getX() + gravity);

        }

        if (goleft) {

            lefttimer += 1;

            playareaview.getHero().setViewport(playareaview.getHero().getRunningLeftViewPortOne());
            if (lefttimer >= 2) {
                playareaview.getHero().setViewport(playareaview.getHero().getRunningLeftViewPortTwo());
                lefttimer = 0;
            }
            playareaview.getHero().setX(playareaview.getHero().getX() - gravity);

        }

        if (princesspace) {
            princemove += .1;
            pacetimer += .002;

            if (princemove >= 1 && princemove < 3) {
                playareaview.getPrincess().setViewport(playareaview.getPrincess().getWalkingRightViewPortOne());
            }

            if (pacetimer <= .1999) {//

                playareaview.getPrincess().setX(playareaview.getPrincess().getX() + pacetimer);
            }

            if (princemove > 3 && princemove < 4) {
                playareaview.getPrincess().setViewport(playareaview.getPrincess().getWalkingRightViewPortTwo());
                princemove = .1;

            }
            ////MOVING RIGHT

            //STOPS AND TURNS PRINCESS
            if (pacetimer > .2 && pacetimer < .21) { //once timer hits .2 then stop princess 

                playareaview.getPrincess().setX(playareaview.getPrincess().getX());//stop 

                //make princess pause
                playareaview.getPrincess().setViewport(playareaview.getPrincess().getWalkingLeftViewPortOne());//turn
                princesspace = false;
                princessmovingleft = true;

                pacetimer = 0;
                princemove = 0;

            }
        }

        if (princessmovingleft) {

            princetimer += .1;
            princesslefttimer += .002;

            if (princesslefttimer >= .1 && princesslefttimer <= .24) {//when princesslefttimer gets to  .1 then thats when we move the princess to the left
                playareaview.getPrincess().setX(playareaview.getPrincess().getX() - princesslefttimer);

            }

            if (princetimer >= 1 && princetimer < 3) {
                playareaview.getPrincess().setViewport(playareaview.getPrincess().getWalkingLeftViewPortOne());
            }

            if (princetimer > 3 && princetimer < 4) {
                playareaview.getPrincess().setViewport(playareaview.getPrincess().getWalkingLeftViewPortTwo());
                princetimer = .1;

            }

            //Stop and turn the princess
            if (princesslefttimer > .25 && princesslefttimer < .27) {
                playareaview.getPrincess().setX(playareaview.getPrincess().getX());
                playareaview.getPrincess().setViewport(playareaview.getPrincess().getWalkingRightViewPortOne());

                princesspace = true;
                princessmovingleft = false;
                princesslefttimer = 0;
                princetimer = 0;
            }

        }

        if (rolling) {
            BarrelView barrel = new BarrelView(playareaview.getBarrelData());
            playareaview.addBarrel(barrel);

            constantmovement += 1;
            for (int i = 0; i < 1; i++) {//Testing with one barrel

                playareaview.getBarrel(i).setViewport(playareaview.getBarrel(i).getRollingViewPortOne());

                if (rightorleft == 0) {//going right=0

                    playareaview.getBarrel(i).setX(playareaview.getBarrel(i).getX() + constantmovement);///?????

                    constantmovement = 0;
                }

                if (rightorleft == 1) {//going left=1 

                    playareaview.getBarrel(i).setX(playareaview.getBarrel(i).getX() - constantmovement);///?????

                    constantmovement = 0;
                }

                if (!Barrelisonplatform(playareaview)) {//if barrel isnt on platform then gravity
                    barrelgravitynumber += 1;

                    if (rightorleft == 0) {//going to the right diagonally
                        playareaview.getBarrel(i).setDirection(0 + barrelgravitynumber);
                        playareaview.getBarrel(i).setSpeed(.5);
                        constantmovement = 0;

                    }

                    if (rightorleft == 1) {//going to the left diagonally
                        playareaview.getBarrel(i).setDirection(180 - barrelgravitynumber);
                        playareaview.getBarrel(i).setSpeed(.5);
                        constantmovement = 0;

                    }
                } else if (Barrelisonplatform(playareaview)) {//when it touches a platform set barrrel to current position 
                    barrelgravitynumber = 0;

                    System.out.println("Touching");
                }

                if (Barreliscolliding(playareaview) && Barrelisonplatform(playareaview)) {
                    if (reachedrightside) {
                        constantmovement = 0;
                        rightorleft = 1;

                    }
                    if (reachedleftside) {
                        constantmovement = 0;
                        rightorleft = 0;

                    }

                }
                if (barrelframe == 1) {
                    playareaview.getBarrel(i).setViewport(playareaview.getBarrel(i).getRollingViewPortOne());
                }
                if (barrelframe == 2) {
                    playareaview.getBarrel(i).setViewport(playareaview.getBarrel(i).getRollingViewPortTwo());
                }
                if (barrelframe == 3) {
                    playareaview.getBarrel(i).setViewport(playareaview.getBarrel(i).getRollingViewPortThree());
                }
                if (barrelframe == 4) {
                    playareaview.getBarrel(i).setViewport(playareaview.getBarrel(i).getRollingViewPortFour());
                }
            }
            if (barrelanimate) {
                barrelframedelay++;
                if (barrelframedelay >= 3) {
                    barrelframe++;
                    if (barrelframe >= 4) {
                        barrelframe = 0;
                    }
                    barrelframedelay = 0;
                }

            }

        }

        if (!heroOnladder(playareaview) && !heroOnFloor(playareaview) && !heroOnPlatform(playareaview)) {

            if (jump) {

                jumptimer += 1;

                playareaview.getHero().setViewport(playareaview.getHero().getRunningRightViewPortTwo());
                System.out.println(jumptimer + " jump timer");

                if (jumptimer >= 2) {
                    playareaview.getHero().setViewport(playareaview.getHero().getRunningRightViewPortOne());
                    System.out.println("timer is equal to one");
                    jumptimer = 0;
                }
                gravity -= 1;
                playareaview.getHero().setY(playareaview.getHero().getY() - gravity);

            }

            if (gravity <= 0.0) {
                jump = false;
                goup = false;

                falling = true;

            }

            if (falling) {
                gravity += 3;

                playareaview.getHero().setY(playareaview.getHero().getY() + gravity);

            }
        }

        playareaview.moveSprites();
    }

    public boolean heroOnladder(PlayAreaView playareaview) {

        for (int i = 0; i < playareaview.getLevelView().getNumLadders(); i++) {
            if (playareaview.getHero().getBoundsInParent().intersects(playareaview.getLevelView().getLadder(i).getBoundsInLocal())) {

                return true;
            }
        }
        return false;
    }

    public boolean heroOnPlatform(PlayAreaView playareaview) {

        for (int i = 0; i < playareaview.getLevelView().getNumPlatforms(); i++) {

            if (playareaview.getHero().getY() >= playareaview.getLevelView().getPlatformView(i).getY() - playareaview.getHero().getBoundingRadius() * 2 && playareaview.getHero().getY() <= playareaview.getLevelView().getPlatformView(i).getY() + playareaview.getLevelView().getPlatformView(i).getHeight() - playareaview.getHero().getBoundingRadius() * 2) {

                if (playareaview.getHero().getX() > playareaview.getLevelView().getPlatformView(i).getX() && playareaview.getHero().getX() < playareaview.getLevelView().getPlatformView(i).getX() + playareaview.getLevelView().getPlatformView(i).getWidth() || playareaview.getHero().getX() + playareaview.getHero().getBoundingRadius() * 2 > playareaview.getLevelView().getPlatformView(i).getX() && playareaview.getHero().getX() + playareaview.getHero().getBoundingRadius() * 2 < playareaview.getLevelView().getPlatformView(i).getX() + playareaview.getLevelView().getPlatformView(i).getWidth()) {

                    playareaview.getHero().setDirection(0);
                    playareaview.getHero().setSpeed(0);

                    playareaview.getHero().setY(playareaview.getLevelView().getPlatformView(i).getY() - playareaview.getHero().getBoundingRadius() * 2);

                    if (jump) {
                        playareaview.getHero().setDirection(270);
                        playareaview.getHero().setSpeed(5);
                    }

                    if (godown) {

                        playareaview.getHero().setDirection(90);
                        playareaview.getHero().setSpeed(5);
                        playareaview.getHero().setY(playareaview.getHero().getY() + gravity);
                    }

                    return true;

                }
            }
        }

        return false;
    }

    public boolean heroOnFloor(PlayAreaView playareaview) {
        if (playareaview.getHero().getY() + playareaview.getHero().getBoundingRadius() * 2 >= playareaview.getHeight()) {
            playareaview.getHero().setY(playareaview.getHeight() - (playareaview.getHero().getBoundingRadius() * 2) + 1);

            playareaview.getHero().setSpeed(0);
            playareaview.getHero().setDirection(0);

            if (falling) {
                falling = false;
            } else {
                if (!falling && ! !jump) {
                    gravity = 0.0;
                    falling = true;
                }
            }

            if (jump) {

                gravity = 10;
                gravity -= 1;
                playareaview.getHero().setY(playareaview.getHero().getY() - gravity);

                if (gravity <= 0.0) {
                    jump = false;
                    goup = false;
                    falling = true;

                }

                if (falling) {
                    gravity += 3;

                    playareaview.getHero().setY(playareaview.getHero().getY() + gravity);
                }
                return true;
            }
        }

        return false;
    }

    
    public boolean Barrelisonplatform(PlayAreaView playareaview) {

        for (int i = 0, j = 0; j < playareaview.getLevelView().getNumPlatforms() && i < 1; j++) {//&& j<playareaview.getLevelView().getNumPlatforms();i++){//number of barrels

            if (playareaview.getBarrel(i).getBoundsInParent().intersects(playareaview.getLevelView().getPlatformView(j).getBoundsInLocal())) {

                if (rightorleft == 1) {
                    playareaview.getBarrel(i).setSpeed(.5);
                    playareaview.getBarrel(i).setDirection(180);
                    System.out.println("going left");
                } else if (rightorleft == 0) {
                    playareaview.getBarrel(i).setSpeed(.5);// why does it work with these specific numbers

                    playareaview.getBarrel(i).setDirection(200);
                    System.out.println("going right");
                }
                return true;

            }
        }

        return false;
    }

    public boolean Barreliscolliding(PlayAreaView playareaview) {

        for (int i = 0; i < 1; i++) {
            if (playareaview.getBarrel(i).getCenterX() - playareaview.getBarrel(i).getBoundingRadius() * 2 < 0) {// whenever barrels reaches the left side stop it

                playareaview.getBarrel(i).setSpeed(.5);
                playareaview.getBarrel(i).setDirection(0);

                rightorleft = 0;

                reachedleftside = true;
                return true;
            }

            if (playareaview.getBarrel(i).getCenterX() + playareaview.getBarrel(i).getBoundingRadius() * 2 > playareaview.getLevelView().getWidth()) {//whenever barrels reaches the right side
                playareaview.getBarrel(i).setSpeed(.5);
                playareaview.getBarrel(i).setDirection(180);

                rightorleft = 1;

                reachedrightside = true;
                return true;
            }

            if (playareaview.getBarrel(i).getCenterY() + playareaview.getBarrel(i).getBoundingRadius() > playareaview.getLevelView().getHeight()) { //Barrel bounded bottom
                playareaview.getBarrel(i).setDirection(0);
                playareaview.getBarrel(i).setSpeed(0);
                playareaview.getHero().setDirection(180);
                System.out.println("BOUNDED BOTTOM");
            }

        }

        return false;
    }

}
