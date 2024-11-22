/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rbg;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author andre
 */
public class Board {
    private int size;
    private Color[][] board;

    
    /**
     * Constructs a board with the specified size.
     * The board is initialized with random colors and shuffled until it is not in a solved state.
     *
     * @param size the size of the board (number of rows and columns)
     */
    public Board(int size) {
        this.size = size;
        this.board = new Color[size][size];
        initializeBoard();
        do {
            shuffleBoard();
        } while (isSolved()); 
    }

    /**
     * Initializes the board by filling it with a generated set of colors.
     * The colors repeat if there are more cells than colors.
     */
    private void initializeBoard() {
        List<Color> colors = generateColors(size);
        int colorIndex = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = colors.get(colorIndex);
                if (++colorIndex == colors.size()) {
                    colorIndex = 0;
                }
            }
        }
    }

    /**
     * Randomly shuffles the colors on the board to create a mixed-up initial state.
     */
    private void shuffleBoard() {
        List<Color> flattenedBoard = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                flattenedBoard.add(board[i][j]);
            }
        }
        Collections.shuffle(flattenedBoard);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = flattenedBoard.get(i * size + j);
            }
        }
    }

    /**
     * Retrieves the color at the specified row and column on the board.
     *
     * @param row the row index
     * @param col the column index
     * @return the color at the specified position
     */
    public Color getColor(int row, int col) {
        return board[row][col];
    }

    /**
     * Shifts all colors in the specified row to the left.
     * The leftmost color wraps around to the right end of the row.
     *
     * @param row the row index to shift
     */
    public void shiftRowLeft(int row) {
        Color first = board[row][0];
        System.arraycopy(board[row], 1, board[row], 0, size - 1);
        board[row][size - 1] = first;
    }

    /**
     * Shifts all colors in the specified row to the right.
     * The rightmost color wraps around to the left end of the row.
     *
     * @param row the row index to shift
     */
    public void shiftRowRight(int row) {
        Color last = board[row][size - 1];
        System.arraycopy(board[row], 0, board[row], 1, size - 1);
        board[row][0] = last;
    }

    /**
     * Shifts all colors in the specified column upwards.
     * The topmost color wraps around to the bottom of the column.
     *
     * @param col the column index to shift
     */
    public void shiftColumnUp(int col) {
        Color first = board[0][col];
        for (int i = 0; i < size - 1; i++) {
            board[i][col] = board[i + 1][col];
        }
        board[size - 1][col] = first;
    }

    /**
     * Shifts all colors in the specified column downwards.
     * The bottommost color wraps around to the top of the column.
     *
     * @param col the column index to shift
     */
    public void shiftColumnDown(int col) {
        Color last = board[size - 1][col];
        for (int i = size - 1; i > 0; i--) {
            board[i][col] = board[i - 1][col];
        }
        board[0][col] = last;
    }

    /**
     * Checks if the board is in a solved state.
     * A solved state means all cells in any row or column have the same color.
     *
     * @return true if the board is solved, otherwise false
     */
    public boolean isSolved() {
        for (int i = 0; i < size; i++) {
            if (!isRowHomogeneous(i) && !isColumnHomogeneous(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if all cells in the specified row have the same color.
     *
     * @param row the row index to check
     * @return true if all cells in the row are the same color, otherwise false
     */
    private boolean isRowHomogeneous(int row) {
        Color color = board[row][0];
        for (int j = 1; j < size; j++) {
            if (board[row][j] != color) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if all cells in the specified column have the same color.
     *
     * @param col the column index to check
     * @return true if all cells in the column are the same color, otherwise false
     */
    private boolean isColumnHomogeneous(int col) {
        Color color = board[0][col];
        for (int i = 1; i < size; i++) {
            if (board[i][col] != color) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the size of the board.
     *
     * @return the size of the board (number of rows/columns)
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Generates a list of random colors.
     *
     * @param numberOfColors the number of colors to generate
     * @return a list of random Color objects
     */
    private static List<Color> generateColors(int numberOfColors) {
        List<Color> colors = new ArrayList<>();
        for (int i = 0; i < numberOfColors; i++) {
            colors.add(new Color((int) (Math.random() * 0x1000000)));
        }
        return colors;
    }
}