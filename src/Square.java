import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private TicTacToeViewer window;
    private boolean isWinningSquare;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col, TicTacToeViewer window) {
        this.row = row;
        this.col = col;
        this.window = window;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    public void draw(Graphics g) {
        //
        if (isWinningSquare) {
            g.setColor(Color.green);
            g.fillRect(104 + (col * 100), 104 + (row * 100), 96, 96);
            g.setColor(Color.red);
        }
        if(marker.equals(window.getBackend().O_MARKER)) {
            g.drawImage(window.getImages()[0], 106 + (col * 100), 106 + (row * 100), 90, 90, window);
        } else if (marker.equals(window.getBackend().X_MARKER)) {
            g.drawImage(window.getImages()[1], 106 + (col * 100), 106 + (row * 100), 90, 90, window);
        }

    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }
}
