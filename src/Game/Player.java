package Game;

import Instances.Camera;
import Instances.Sprite;
import Valuables.Vector2;
import java.awt.event.KeyEvent;

public class Player extends Sprite {
    float PlayerSpeed = 300;

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
        Vector2 moveDirection = new Vector2(0, 0);
        if (Input.GetKey(KeyEvent.VK_D)){
            moveDirection.X += 1;
        }
        if (Input.GetKey(KeyEvent.VK_A)){
            moveDirection.X -= 1;
        }
        if (Input.GetKey(KeyEvent.VK_W)){
            moveDirection.Y -= 1;
        }
        if (Input.GetKey(KeyEvent.VK_S)){
            moveDirection.Y += 1;
        }
        moveDirection = Vector2.Normalized(moveDirection);
        moveDirection = new Vector2(moveDirection.X * deltaTime * PlayerSpeed, moveDirection.Y * deltaTime * PlayerSpeed);
        position = position.Add(moveDirection);

        camera.position = Vector2.Lerp(camera.position, position, 8 * deltaTime);
    }
}
