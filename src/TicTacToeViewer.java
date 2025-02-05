import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class

    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 500;

    private Image[] images = {
            new ImageIcon("Resources/O.png").getImage(),
            new ImageIcon("Resources/X.png").getImage()
    };

    private TicTacToe backend;
    private String resultText;

    public TicTacToeViewer(TicTacToe backend) {
        this.backend = backend;
        resultText = "";

        // Setup the window and the buffer strategy.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tic Tac Toe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public Image[] getImages() {
        return images;
    }

    public void setResultText(String resultText) {
        this.resultText = resultText;
    }

    public TicTacToe getBackend() {
        return backend;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
        g.setColor(Color.black);
        g.fillRect(200, 100, 5, 300);
        g.fillRect(300, 100, 5, 300);
        g.fillRect(100, 200, 300, 5);
        g.fillRect(100, 300, 300, 5);
        g.setColor(Color.red);
        g.setFont(new Font("arial", Font.PLAIN, 36));

        for(int i = 0; i < 3; i++) {
            g.drawString("" + i, 140 + (100 * i), 80);
        }
        for(int i = 0; i < 3; i++) {
            g.drawString("" + i, 80, 160 + (100 * i));
        }

        g.setColor(Color.black);
        g.setFont(new Font("arial", Font.PLAIN, 50));
        g.drawString(resultText, 120, 450);


        Square[][] board = backend.getBoard();

        for (Square[] row : board) {
            for (Square square : row) {
                square.draw(g);
            }
        }
    }
}
