import Base.Renderer;
import Game.TestScene;

public class Main {
    public static void main(String[] args) {
        var renderer = new Renderer();
        renderer.Run();
        renderer.LoadScene(new TestScene());
    }
}