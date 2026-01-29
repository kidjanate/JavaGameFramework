import Base.Game;
import Base.Renderer;
import Game.TestScene;
import Instances.Instance;
import Instances.Sprite;

public class Main {
    public static void main(String[] args) {
        var renderer = new Renderer();
        renderer.Run();
        renderer.LoadScene(new TestScene());
    }
}