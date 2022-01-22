import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Okno extends JPanel implements ActionListener{
    int WIDTH = 1000;
    int HEIGHT = 1000;
    int CELL = 10;
    int DELAY = 60;
    boolean play;
    Timer timer;

    public Okno(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setFocusable(true);
        this.setBackground(Color.yellow);
        start();
    }

    public void start(){
        Snake snake = new Snake();
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

    }

    /**
     * Обновляется каждый кадр, следит за происходящим в игре
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        repaint(); // перерисовывает все объекты в игре
    }
}
