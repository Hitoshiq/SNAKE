import javax.swing.*;
import java.awt.*;

/**
 * РИСУЕТ ОКНО ОВЕРА
 */
public class OKNOOVER extends JLabel {
    int WIDTH = 1000;
    int HEIGHT = 1000;
    int TEXTHEIGHT = 100;

    public OKNOOVER() {
        this.setBackground(Color.BLACK);
        this.setText("GAME OVER");
    }

    /**
     * РИСУЕМ ТЕКСТ GAME OVER
     * @param g компонент Graphics для рисовки объектов в окне
     */
    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.setFont(new Font("Times New Roman", Font.BOLD, TEXTHEIGHT));
        FontMetrics metrics = getFontMetrics(g.getFont()); // текст с размерами, цветом и шрифтом
        g.drawString(this.getText(),
                (WIDTH - metrics.stringWidth(this.getText())) / 2,
                (HEIGHT - metrics.stringWidth(this.getText())) / 2);
    }
}
