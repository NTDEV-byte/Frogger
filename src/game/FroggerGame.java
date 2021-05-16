package game;

import javax.swing.*;

public class FroggerGame {

        public static Input inputHandler = new Input();

        public static void main(String[] args){

                JFrame window = new JFrame("Frogger");
                window.setVisible(true);
                window.setResizable(false);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setLocationRelativeTo(null);
                window.add(new Map());
                window.addKeyListener(FroggerGame.inputHandler);
                window.pack();

        }


}
