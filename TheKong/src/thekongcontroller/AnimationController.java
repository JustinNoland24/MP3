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
    public double gravity = 10;
    public boolean jump;
    public boolean falling;
    public long frame;
    public long frameIn;
    public final double speedPlayer = 2.0;
    long last;
    boolean goleft, goright, goup, godown;
    public int changer;

    private long lastValue = 0;

    public AnimationController(PlayAreaView playareaview) {
        this.playareaview = playareaview;
        //this.hero=playview.getHero();
        this.gravity = 10;
        this.falling = false;
        this.jump = false;
        this.frame = 0;
        this.frameIn = 0;
        this.last = 0;
    }

    @Override

    public void handle(long nsec) {

        upgrade();

    }

    public void upgrade() {

        if (playareaview.getHero().getCenterX() - playareaview.getHero().getBoundingRadius() < 0) { //LEFT BOUND (X-AXIS)

            playareaview.getHero().setSpeed(0.2);
            playareaview.getHero().setX(0);

        }

        if (playareaview.getHero().getCenterX() + playareaview.getHero().getBoundingRadius() > playareaview.getLevelView().getWidth()) {//RIGHT BOUND(X-AXIS)
            playareaview.getHero().setSpeed(0.2);

            playareaview.getHero().setX(480);

        }

        if (playareaview.getHero().getCenterY() - playareaview.getHero().getBoundingRadius() < 0) { //UPWARD Y BOUND
            playareaview.getHero().setDirection(90);

        }

        if (godown) {

        }

        if (goright) {

            playareaview.getHero().setX(playareaview.getHero().getX() + gravity);

            System.out.println(playareaview.getHero().getSpeed() + " speed right");
            System.out.println("GOING RIGHT");
        }

        if (goleft) {

            playareaview.getHero().setX(playareaview.getHero().getX() - gravity);

        }

        if (!heroOnladder(playareaview) && !heroOnFloor(playareaview) && !heroOnPlatform(playareaview)) {

            if (jump) {

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

            System.out.println("Mario's off floor");
            return false;

        }
        return false;
    }
}
