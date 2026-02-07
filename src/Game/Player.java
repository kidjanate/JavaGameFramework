package Game;

import Instances.Camera;
import Instances.Sprite;
import Valuables.Vector2;
import java.awt.event.KeyEvent;

public class Player extends Sprite {
    float PlayerSpeed = 5;

    Camera camera;
    public Player(Camera camera) {
        super("smallrock.png");
        this.camera = camera;
    }

    @Override
    public void OnStart(){
        System.out.println("Player start");
    }

    @Override
    public void OnUpdate(double deltaTime){
        if (Input.GetKey(KeyEvent.VK_D)){
            position.X += deltaTime * PlayerSpeed;
        }
        if (Input.GetKey(KeyEvent.VK_A)){
            position.X -= deltaTime * PlayerSpeed;
        }
        if (Input.GetKey(KeyEvent.VK_W)){
            position.Y -= deltaTime * PlayerSpeed;
        }
        if (Input.GetKey(KeyEvent.VK_S)){
            position.Y += deltaTime * PlayerSpeed;
        }

        camera.position = Vector2.Lerp(camera.position, position, 0.1 * deltaTime);
        System.out.println(camera.position);
    }
}
