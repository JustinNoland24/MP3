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
    private PlayAreaView playareaview;
    boolean goleft, goright, goup, godown;
    AnimationController animation;

    @Override
    public void start(Stage stage) {

        playerProfileConfigFileName = "PlayerProfileConfig.txt";
        spriteConfigFileName = "SpriteConfig.txt";
        objectConfigFileName = "ObjectConfig.txt";
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
        animation = new AnimationController(this.playareaview);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {

                switch (event.getCode()) {
                    case UP:// animation.goup = true; 

                        animation.jump = true;
                        animation.gravity = 12.5;
                        
                        break;

                    case DOWN:
                        animation.godown = true;
                        playareaview.getHero().setDirection(90);
                        playareaview.getHero().setSpeed(5);
                        break;

                    case RIGHT:
                        animation.goright = true;

                        break;

                    case LEFT:
                        animation.goleft = true;

                        break;

                }

            }

        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {

                switch (event.getCode()) {
                    case UP:
                        animation.goup = false;
                        playareaview.getHero().setDirection(0);
                        playareaview.getHero().setSpeed(0);
                        break;

                    case DOWN:
                        animation.godown = false;
                        playareaview.getHero().setDirection(0);
                        playareaview.getHero().setSpeed(0);
                        break;

                    case RIGHT:
                        animation.goright = false;
                        playareaview.getHero().setDirection(0);
                        playareaview.getHero().setSpeed(0);
                        break;

                    case LEFT:
                        animation.goleft = false;
                        playareaview.getHero().setDirection(0);
                        playareaview.getHero().setSpeed(0);
                        break;

                }
            }

        });

        stage.setScene(scene);
        stage.show();

        command.getStartButton().setOnAction(event -> { 
            animation.rolling=true;
            animation.princesspace=true;
            animation.barrelanimate=true;
            animation.konganimate=true;
            animation.start();
            

        });

        command.getEndButton().setOnAction(event -> {
            System.exit(0);
        });

    }

    public static void main(String[] args) {
        launch(args);
    }

}
