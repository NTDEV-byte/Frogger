import javax.swing.*;

public class Frogger {



        public static void main(String[] args){

                JFrame window = new JFrame("Frogger");
                window.setVisible(true);
                window.setResizable(false);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setLocationRelativeTo(null);
                window.add(new Map());
                window.pack();

        }


}
