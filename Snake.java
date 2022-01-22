import java.awt.*;
import java.util.ArrayList;

public class Snake {
    int SIZE = new Okno().CELL;
    Color COLOR = Color.BLACK;
    ArrayList<Snake> bodyParts = new ArrayList<>();
    int x;
    int y;
    int SPEED = 1;
    int DIRECTION;

    /**
     * Змейка двигается на 1 блок
     */
    public void move(){}

    /**
     * Меняем направление движения в случае нажатия кнопок на клавиатуре
     */
    public void changeDirection(){}
}
