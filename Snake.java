import java.awt.*;
import java.util.ArrayList;

public class Snake {
    int SIZE;
    Color COLOR;
    ArrayList<Snake> bodyParts = new ArrayList<>();
    int x;
    int y;
    int SPEED;
    char direction;

    public Snake(int cell, Color color, int speed, char direction, int x, int y){
        this.SIZE = cell;
        this.COLOR = color;
        this.SPEED = speed;
        this.direction = direction;
        this.x = x;
        this.y = y;
    }

    /**
     * Рисует змейку
     * @param g объект, который рисует змею
     */
    public void draw(Graphics g){
        g.fillRect(this.x, this.y, this.SIZE, this.SIZE);
    }

    /**
     * Змейка двигается на 1 блок
     */
    public void move(){}

    /**
     * Меняем направление движения в случае нажатия кнопок на клавиатуре
     */
    public void changeDirection(){}


}

