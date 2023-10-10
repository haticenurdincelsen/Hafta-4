import java.util.Random;

public class Snake extends Obstacle{
    public Snake(){
        super("Yılan",4, 0, 12, 0);
    }

    @Override
    public int getDamage() {
        Random r = new Random();
        return r.nextInt(3, 7);
    }

}





