import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Snake {
    int SIZE;
    Color COLOR;
    int SPEED;
    char direction;
    int WIDTH, HEIGHT;
    ArrayList<Integer> bodyX;
    ArrayList<Integer> bodyY;

    public Snake(int cell, Color color, int speed, char direction, int x, int y, int width, int height){
        this.SIZE = cell;
        this.COLOR = color;
        this.SPEED = speed;
        this.direction = direction;
        this.WIDTH = width;
        this.HEIGHT = height;
        this.bodyX = new ArrayList<>(Arrays.asList(x, x - this.SIZE, x - 2 * this.SIZE));
        this.bodyY = new ArrayList<>(Arrays.asList(y, y, y));
    }

    /**
     * Рисует змейку
     * @param g объект, который рисует змею
     */
    public void draw(Graphics g){
        for (int i = 0; i < bodyX.size(); i++)
            g.fillRect(this.bodyX.get(i), this.bodyY.get(i), this.SIZE, this.SIZE);
    }

    /**
     * Змейка двигается на 1 блок
     */
    public void move(){
//      части тела следуют за головой
        for (int i = bodyX.size() - 1; i > 0; i--) {
            this.bodyX.set(i, this.bodyX.get(i - 1));
            this.bodyY.set(i, this.bodyY.get(i - 1));
        }

//      двигаем голову
        switch (this.direction) {
            case 'R' -> {
                this.bodyX.set(0, this.bodyX.get(0)        +  this.SPEED);
            }
            case 'L' -> {
                this.bodyX.set(0, this.bodyX.get(0)       -   this.SPEED);
            }
            case 'U' -> {
                this.bodyY.set(0, this.bodyY.get(0)       -  this.SPEED);
            }
            case 'D' -> {
                this.bodyY.set(0, this.bodyY.get(0)       +  this.SPEED);
            }
        }
    }

    /**
     * Тп в противоположную сторону при выход за пределы экрана
     */
    public void checkWalls(){
        if (this.bodyX.get(0) >= this.WIDTH){
            this.bodyX.set(0, 0);
        }
        if (this.bodyX.get(0) < 0){
            this.bodyX.set(0, this.WIDTH);
        }
        if (this.bodyY.get(0) >= this.HEIGHT){
            this.bodyY.set(0, 0);
        }
        if (this.bodyY.get(0) < 0){
            this.bodyY.set(0, this.HEIGHT);
        }
    }


    public boolean checkCollisions(){
        for (int i = 1; i < this.bodyX.size(); i++){
            if(Objects.equals(this.bodyY.get(0), this.bodyY.get(i)) && Objects.equals(this.bodyX.get(0), this.bodyX.get(i))){
                 return false;
            }
        }
        return true;
    }

    public boolean checkFood(Food food){
        if (this.bodyY.get(0) == food.y && this.bodyX.get(0) == food.x ){
            this.bodyX.add(100000);
            this.bodyY.add(100000);
            return true;
        }
        return false;
    }
}


