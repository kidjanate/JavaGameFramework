package Base;

import java.awt.List;
import java.util.ArrayList;

import Instances.Camera;
import Instances.GameObject;

public abstract class Scene {
    ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
    Camera currentCamera;
    Input Input;
    public void AddGameObject(GameObject gameObj){
        if (gameObjects.contains(gameObj)){
            return;
        }
        gameObj.Input = Input;
        gameObj.OnStart();
        gameObjects.add(gameObj);
    }
    public void SetCamera(Camera camera){
        AddGameObject(camera);
        currentCamera = camera;
    }
    public abstract void OnStart();
    public abstract void OnUpdate(double deltaTime);
}
