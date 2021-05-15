import java.awt.*;
import java.awt.event.KeyEvent;

public class Frog extends Entity{

    private Input input = FroggerGame.inputHandler;
    public static final int STEP_SIZE = 8;


            public Frog(int x, int y, Color color){
                    super(x,y,8,8,color);
            }


    @Override
    public void update() {

        if(input.isKeyDown(KeyEvent.VK_UP)){
            bounds.y-=STEP_SIZE;
        }
        if(input.isKeyDown(KeyEvent.VK_RIGHT)){
            bounds.x+=STEP_SIZE;
        }

        if(input.isKeyDown(KeyEvent.VK_DOWN)){
            bounds.y+=STEP_SIZE;
        }

        if(input.isKeyDown(KeyEvent.VK_LEFT)){
            bounds.x-=STEP_SIZE;
        }
    }
}
