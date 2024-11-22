/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rbg;

import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class GameController {
    private Board board;
    private GamePanel gamePanel;
    private int moveCount;
    private Main app;

    /**
     * Constructs a GameController with the specified board size and main application.
     * Initializes the game board, panel, and move counter.
     *
     * @param size the size of the board (number of rows/columns)
     * @param app  the main application instance used to display messages and restart the game
     */
    public GameController(int size, Main app) {
        this.board = new Board(size);
        this.app = app;
        this.moveCount = 0;
        this.gamePanel = new GamePanel(board, this);
    }

    /**
     * Returns the game panel associated with this controller.
     *
     * @return the GamePanel object representing the game interface
     */
    public GamePanel getGamePanel() {
        return gamePanel;
    }

    /**
     * Shifts the specified row to the left and updates the game state.
     * Increments the move counter and checks if the puzzle is solved.
     *
     * @param row the index of the row to shift left
     */
    public void shiftRowLeft(int row) {
        board.shiftRowLeft(row);
        moveCount++;
        checkGameEnd();
        gamePanel.refreshBoard();
    }

    /**
     * Shifts the specified row to the right and updates the game state.
     * Increments the move counter and checks if the puzzle is solved.
     *
     * @param row the index of the row to shift right
     */
    public void shiftRowRight(int row) {
        board.shiftRowRight(row);
        moveCount++;
        checkGameEnd();
        gamePanel.refreshBoard();
    }

    /**
     * Shifts the specified column up and updates the game state.
     * Increments the move counter and checks if the puzzle is solved.
     *
     * @param col the index of the column to shift up
     */
    public void shiftColumnUp(int col) {
        board.shiftColumnUp(col);
        moveCount++;
        checkGameEnd();
        gamePanel.refreshBoard();
    }

    /**
     * Shifts the specified column down and updates the game state.
     * Increments the move counter and checks if the puzzle is solved.
     *
     * @param col the index of the column to shift down
     */
    public void shiftColumnDown(int col) {
        board.shiftColumnDown(col);
        moveCount++;
        checkGameEnd();
        gamePanel.refreshBoard();
    }

    /**
     * Checks if the game board is in a solved state.
     * If solved, displays a congratulation message to the user and restarts the game.
     */
    private void checkGameEnd() {
        if (board.isSolved()) {
            gamePanel.refreshBoard();
            JOptionPane.showMessageDialog(app, "Congratulations! You solved the puzzle in " + moveCount + " moves.");
            app.restart();
        }
    }
}