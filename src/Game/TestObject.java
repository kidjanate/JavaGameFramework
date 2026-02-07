package Game;

import Instances.Sprite;

public class TestObject extends Sprite {
    double timer = 0;
    public TestObject(String path) {
        super(path);
    }

    @Override
    public void OnUpdate(double deltaTime){
        timer += deltaTime;
    }
}
