package Base;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.JFrame;

import Instances.GameObject;
import Valuables.Vector2;

public class Renderer {
    JFrame window;
    Canvas canvas;
    Input input;
    Vector2 size = new Vector2(512, 512);
    String title = "Example";
    int TargetFPS = 300;

    Scene currentScene;

    public void SetTitle(String title){
        this.title = title;
        window.setTitle(title);
    }

    public void SetWindowSize(Vector2 size){
        window.setSize((int)size.X, (int)size.Y);
    }

    public void Run(){
        window = new JFrame();
        SetTitle(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension((int)size.X, (int)size.Y));
        canvas.setFocusable(false);
        
        input = new Input();
        window.addKeyListener(input);
        
        window.add(canvas);
        window.pack();

        window.setVisible(true);
        
        var gameThread = new Thread(new Runnable() {
            public void run(){
                Loop();
            }
        });
        gameThread.start();

        SetWindowSize(size);
        canvas.createBufferStrategy(3);
        window.setFocusable(true);
        window.requestFocus();
    }

    public void LoadScene(Scene scene){
        currentScene = scene;
        currentScene.Input = input;
        currentScene.OnStart();
    }

    private void Render(Scene scene) {
        BufferStrategy bs = canvas.getBufferStrategy();
        if (bs == null) {
            canvas.createBufferStrategy(3);
            return;
        }

        int w = window.getWidth();
        int h = window.getHeight();

        Graphics2D g2 = (Graphics2D) bs.getDrawGraphics();

        g2.setColor(Color.black);
        g2.fillRect(0, 0, w, h);

        AffineTransform transform = g2.getTransform();

        g2.translate(w / 2, h / 2);

        if (scene.currentCamera != null){
            g2.translate(-scene.currentCamera.position.X, -scene.currentCamera.position.Y);
        }

        g2.setColor(Color.WHITE); 
        g2.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (GameObject obj : scene.gameObjects){
            obj.OnDraw(g2);
        }

        g2.setTransform(transform);

        g2.dispose();
        bs.show();
    }

    void Loop() {
        long lastTime = System.nanoTime();
        
        while (window.isVisible()) {
            long currentTime = System.nanoTime();
            double deltaTime = (currentTime - lastTime) / 1000000000.0;
            lastTime = currentTime;

            if (currentScene != null) {
                currentScene.OnUpdate(deltaTime);
                for (GameObject obj : currentScene.gameObjects) {
                    obj.OnUpdate(deltaTime);
                }
                Render(currentScene);
            }

            double frameTimeSeconds = 1.0 / TargetFPS;
            while ((System.nanoTime() - lastTime) / 1000000000.0 < frameTimeSeconds) {
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {}
            }
        }
    }
}
