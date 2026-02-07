package Game;

import Base.Scene;
import Instances.Camera;

public class TestScene extends Scene {
    @Override
    public void OnStart() {
        Camera cam = new Camera();
        SetCamera(cam);

        var player = new Player(cam);
        AddGameObject(player);

        var rock = new TestObject("smallrock.png");
        AddGameObject(rock);
    }

    @Override
    public void OnUpdate(double deltaTime) {
        
    }
}
