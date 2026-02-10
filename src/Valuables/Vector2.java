package Valuables;

public class Vector2 {
    public double X;
    public double Y;

    public Vector2(double x, double y){
        this.X = x;
        this.Y = y;
    }

    public static Vector2 Normalized(Vector2 x) {
        double magnitude = x.Magnitude();
        if (magnitude == 0) {
            return new Vector2(0, 0); 
        }
        return new Vector2(x.X / magnitude, x.Y / magnitude);
    }

    public static Vector2 Lerp(Vector2 a, Vector2 b, double t){
        t = Math.clamp(t, 0, 1);
        double newX = a.X + (b.X - a.X) * t;
        double newY = a.Y + (b.Y - a.Y) * t;

        return new Vector2(newX, newY);
    }

    public Vector2 Add(Vector2 x){
        return new Vector2(X + x.X, Y + x.Y);
    }

    public Vector2 Add(double x){
        return new Vector2(X + x, Y + x);
    }

    public double Magnitude(){
        return Math.sqrt(X * X + Y * Y);
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", X, Y);
    }
}
