import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Okno extends JPanel implements ActionListener{
    int WIDTH = 1000;
    int HEIGHT = 1000;
    int CELL = 50;
    int DELAY = 120;
    boolean play;
    Timer timer;
    Snake snake = new Snake(CELL, Color.BLACK, CELL, 'R', 100, 100, WIDTH, HEIGHT);
    Food food;

    public Okno(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setFocusable(true);
        this.setBackground(Color.yellow);
        this.addKeyListener(new MyKeyAdapter());
        start();
    }

    public void start(){
        play = true;
        food = new Food((int) (Math.random() * WIDTH / CELL) * CELL, (int) (Math.random() * HEIGHT / CELL) * CELL, CELL);
        timer = new Timer(DELAY, this);
        timer.start();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(play) draw(g);
        else {
            OKNOOVER oknoover = new OKNOOVER();
            this.setBackground(oknoover.getBackground());
            oknoover.draw(g);
        }
    }

    public void draw(Graphics g){
        for (int i = 0; i < WIDTH; i+=CELL)
            g.drawLine(i, 0, i, HEIGHT);
        for (int i = 0; i < HEIGHT; i+=CELL)
            g.drawLine(0, i, WIDTH, i);
        snake.draw(g);
        food.draw(g);
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            // 'R' - Right, 'L' - Left, 'U' - Up, 'D' - Down
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W -> {
                    if (snake.direction != 'D') snake.direction = 'U';
                }
                case KeyEvent.VK_A-> {
                    if (snake.direction != 'R') snake.direction = 'L';
                }
                case KeyEvent.VK_D-> {
                    if (snake.direction != 'L') snake.direction = 'R';
                }
                case KeyEvent.VK_S-> {
                    if (snake.direction != 'U') snake.direction = 'D';
                }
            }
        }
    }

    /**
     * Обновляется каждый кадр, следит за происходящим в игре
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (play) {
            snake.move();
            snake.checkWalls();
            play = snake.checkCollisions();
            if (snake.checkFood(food))
                food = new Food((int) (Math.random() * WIDTH / CELL) * CELL, (int) (Math.random() * HEIGHT / CELL) * CELL, CELL);
        }

        repaint(); // перерисовывает все объекты в игре
    }
}
