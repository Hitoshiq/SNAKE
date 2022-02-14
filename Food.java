import java.awt.*;

public class Food {
    Color COLOR;
    int x, y, cell;

    public Food(int x, int y, int cell) {
        this.COLOR = Color.RED;
        this.x = x;
        this.y = y;
        this.cell = cell; // размеры клетки
    }

    public void draw(Graphics g){
        g.setColor(this.COLOR);
        g.fillRect(this.x, this.y, this.cell, this.cell);
    }
}

