import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Okno extends JPanel implements ActionListener{
    int WIDTH = 1000;
    int HEIGHT = 1000;
    int CELL = 50;
    int DELAY = 60;
    boolean play;
    Timer timer;
    Snake snake = new Snake(CELL, Color.BLACK, CELL, 'R', 100, 100);

    public Okno(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setFocusable(true);
        this.setBackground(Color.yellow);
        start();
    }

    public void start(){
        snake.x = 0;
        snake.y = 0;
        play = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        for (int i = 0; i < WIDTH; i+=CELL)
            g.drawLine(i, 0, i, HEIGHT);
        for (int i = 0; i < HEIGHT; i+=CELL)
            g.drawLine(0, i, WIDTH, i);
        snake.draw(g);
    }

    /**
     * Обновляется каждый кадр, следит за происходящим в игре
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        repaint(); // перерисовывает все объекты в игре
    }
}

