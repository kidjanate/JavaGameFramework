package Instances;
import java.awt.Graphics2D;
import java.util.UUID;

import Base.Input;

public abstract class Instance{
    public String ID;
    public String name = "Unnamed Object";
    public Input Input;

    public Instance(){
        var uuid = UUID.randomUUID();
        this.ID = uuid.toString();
    }

    public abstract void OnStart();
    public abstract void OnUpdate(double deltaTime);
    public abstract void OnDraw(Graphics2D g2);
}