/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rbg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author andre
 */
public class GamePanel extends JPanel{
    private Board board;
    private int cellSize;
    private GameController controller;

    /**
     * Constructs a GamePanel with the specified board and game controller.
     * Initializes the panel layout and adds the board and control panels.
     *
     * @param board      the {@code Board} object representing the game state
     * @param controller the {@code GameController} used to handle user interactions
     */
    public GamePanel(Board board, GameController controller) {
        this.board = board;
        this.controller = controller;
        this.cellSize = Main.CELL_SIZE;
        setLayout(new BorderLayout());

        add(createBoardPanel(), BorderLayout.CENTER);
        add(createRowControlPanel(), BorderLayout.WEST);
        add(createColumnControlPanel(), BorderLayout.SOUTH);
    }

    /**
     * Creates a panel displaying the board with its current colors.
     * Each cell is represented as a JPanel with a border.
     *
     * @return a JPanel representing the board
     */
    private JPanel createBoardPanel() {
        JPanel boardPanel = new JPanel(new GridLayout(board.getSize(), board.getSize()));
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                JPanel cell = new JPanel();
                cell.setBackground(board.getColor(i, j));
                cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                boardPanel.add(cell);
            }
        }
        return boardPanel;
    }

    /**
     * Creates a panel with control buttons to shift rows left or right.
     * Each row has two buttons: left arrow (←) and right arrow (→).
     *
     * @return a JPanel with row control buttons
     */
    private JPanel createRowControlPanel() {
        JPanel rowControlPanel = new JPanel(new GridLayout(board.getSize(), 1));
        for (int i = 0; i < board.getSize(); i++) {
            int rowIndex = i;

            JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

            JButton shiftRowLeftButton = new JButton("←");
            shiftRowLeftButton.addActionListener(e -> controller.shiftRowLeft(rowIndex));
            buttonPanel.add(shiftRowLeftButton);

            JButton shiftRowRightButton = new JButton("→");
            shiftRowRightButton.addActionListener(e -> controller.shiftRowRight(rowIndex));
            buttonPanel.add(shiftRowRightButton);

            rowControlPanel.add(buttonPanel);
        }
        return rowControlPanel;
    }

    /**
     * Creates a panel with control buttons to shift columns up or down.
     * Each column has two buttons: up arrow (↑) and down arrow (↓).
     *
     * @return a JPanel with column control buttons
     */
    private JPanel createColumnControlPanel() {
        JPanel columnControlPanel = new JPanel(new GridLayout(1, board.getSize()));
        for (int j = 0; j < board.getSize(); j++) {
            int colIndex = j;

            JPanel buttonPanel = new JPanel(new GridLayout(2, 1));

            JButton shiftColUpButton = new JButton("↑");
            shiftColUpButton.addActionListener(e -> controller.shiftColumnUp(colIndex));
            buttonPanel.add(shiftColUpButton);

            JButton shiftColDownButton = new JButton("↓");
            shiftColDownButton.addActionListener(e -> controller.shiftColumnDown(colIndex));
            buttonPanel.add(shiftColDownButton);

            columnControlPanel.add(buttonPanel);
        }
        return columnControlPanel;
    }

    /**
     * Refreshes the game panel by updating the board display and revalidating the layout.
     * This method should be called when the board state changes (e.g., after shifting rows/columns).
     */
    public void refreshBoard() {
        removeAll();
        add(createBoardPanel(), BorderLayout.CENTER);
        add(createRowControlPanel(), BorderLayout.WEST);
        add(createColumnControlPanel(), BorderLayout.SOUTH);
        revalidate();
        repaint();
    }
}
