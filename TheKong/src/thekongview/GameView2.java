/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongview;

import javafx.scene.layout.BorderPane;

/**
 *
 * @author chris
 */
public class GameView2 extends BorderPane{
    public GameView2(StatusView2 statusView, PlayAreaView playAreaView, CommandView2 commandView) {
        this.setTop(statusView);
        this.setCenter(playAreaView);
        this.setBottom(commandView);
    }
}
