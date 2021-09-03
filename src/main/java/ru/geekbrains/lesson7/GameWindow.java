package ru.geekbrains.lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 02.09.2021
 */

public class GameWindow extends JFrame {

    private int winWidth = 1024;
    private int winHeight = 768;
    private int winPosX = 300;
    private int winPosY = 100;

    private GameMap map;
    private JPanel gui;

    private JPanel gameControlDiv;
    private JButton btnStartGame;
    private JButton btnExitGame;

    private JPanel gameInfoDiv;

    private JPanel playerInfoDiv;

    private JPanel playerControllerDiv;

    private JPanel logDiv;

    GameWindow() {
        setupWindow();

        map = new GameMap();

        setupGui();

        add(gui, BorderLayout.EAST);
        add(map);


        setVisible(true);
    }

    private void setupGui() {
        gui = new JPanel();
        gui.setLayout(new GridLayout(5, 1));

        setupGameControl();
        setupPlayerController();
        this.setupGameInfo();
        this.setupLog();
        this.setupPlayerInfo();

        gui.add(gameControlDiv);
        gui.add(gameInfoDiv);
        gui.add(playerInfoDiv);
        gui.add(playerControllerDiv);
        gui.add(logDiv);
    }

    private void setupGameControl() {
        gameControlDiv = new JPanel();
        gameControlDiv.setLayout(new GridLayout(3,1));

        btnStartGame = new JButton("<html><s>Start Game</s></html>");
        btnExitGame = new JButton("<html><i>Exit Game</i></html>");

        gameControlDiv.add(new JLabel("== Game Menu =="));
        gameControlDiv.add(btnStartGame);
        gameControlDiv.add(btnExitGame);

        btnExitGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                System.exit(0);
            }

        });
    }

    private void setupGameInfo() {
        gameInfoDiv = new JPanel(new GridLayout(4, 1));
        gameInfoDiv.add(new JLabel("==Game Info=="));
        gameInfoDiv.add(new JLabel("Level: "));
        gameInfoDiv.add(new JLabel("Map size: "));
        gameInfoDiv.add(new JLabel("Count E: "));

    }

    private void setupPlayerInfo() {
        playerInfoDiv = new JPanel(new GridLayout(4, 1));
        playerInfoDiv.add(new JLabel("==Player Info=="));
        playerInfoDiv.add(new JLabel("Name: "));
        playerInfoDiv.add(new JLabel("Health points: "));
        playerInfoDiv.add(new JLabel("X, Y: "));
    }

    private void setupPlayerController() {
        playerControllerDiv = new JPanel();
        playerControllerDiv.setLayout(new BorderLayout());
        JButton btnUP = new JButton("Up");
        JButton btnDown = new JButton("Down");
        JButton btnLeft = new JButton("Left");
        JButton btnRight = new JButton("Right");
        playerControllerDiv.add(btnUP, BorderLayout.NORTH);
        playerControllerDiv.add(btnDown, BorderLayout.SOUTH);
        playerControllerDiv.add(btnLeft, BorderLayout.WEST);
        playerControllerDiv.add(btnRight, BorderLayout.EAST);

    }

    private void setupLog() {
        logDiv = new JPanel();
        logDiv.add(new JLabel("LOG"));
    }


    private void setupWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(winPosX, winPosY);
        setSize(winWidth, winHeight);
        setTitle("This is my Game");
        setResizable(true);
    }

}
