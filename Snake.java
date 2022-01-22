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
    int WIDTH, HEIGHT;

    public Snake(int cell, Color color, int speed, char direction, int x, int y, int width, int height){
        this.SIZE = cell;
        this.COLOR = color;
        this.SPEED = speed;
        this.direction = direction;
        this.x = x;
        this.y = y;
        this.WIDTH = width;
        this.HEIGHT = height;
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
    public void move(){
        switch (this.direction) {
            case 'R' -> {
                this.x += this.SPEED;
            }
            case 'L' -> {
                this.x -= this.SPEED;
            }
            case 'U' -> {
                this.y -= this.SPEED;
            }
            case 'D' -> {
                this.y += this.SPEED;
            }

        }
    }

    /**
     * Тп в противоположную сторону при выход за пределы экрана
     */
    public void checkWalls(){ 
        if (this.x >= this.WIDTH){
            this.x = 0;
        }
        if (this.x < 0){
            this.x = this.WIDTH;
        }
        if (this.y >= this.HEIGHT){
            this.y = 0;
        }
        if (this.y < 0){
            this.y = this.HEIGHT;
        }

    }

}

