package com.mycompany.rbg;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author andre
 */ 
public class Main extends JFrame {
    static final int CELL_SIZE = 120;

    /**
     * Constructs the Main frame for the game.
     * Sets up the window properties, displays the board size selection screen, and initializes the frame size.
     */
    public Main() {
        setTitle("Rubik Board Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        showBoardSizeSelection();
        setSize(300,300);
    }

    /**
     * Displays a dialog panel for the user to select the size of the game board.
     * Provides options for 2x2, 4x4, and 6x6 board sizes.
     * Initializes the board size and starts the game based on the user's selection.
     */
    private void showBoardSizeSelection() {
        JPanel panel = new JPanel(new GridLayout(4, 1));
        JLabel label = new JLabel("Select Board Size", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(label);

        JButton btn2x2 = new JButton("2x2");
        btn2x2.setFont(new Font("Arial", Font.BOLD, 20));
        btn2x2.addActionListener(e -> startGame(2));
        panel.add(btn2x2);

        JButton btn4x4 = new JButton("4x4");
        btn4x4.setFont(new Font("Arial", Font.BOLD, 20));
        btn4x4.addActionListener(e -> startGame(4));
        panel.add(btn4x4);

        JButton btn6x6 = new JButton("6x6");
        btn6x6.setFont(new Font("Arial", Font.BOLD, 20));
        btn6x6.addActionListener(e -> startGame(6));
        panel.add(btn6x6);

        setContentPane(panel);
        setVisible(true);
    }

    /**
     * Starts a new game with the specified board size.
     * Initializes the GameController and updates the window content to display the game panel.
     *
     * @param size the size of the board (e.g., 2 for 2x2, 4 for 4x4, 6 for 6x6)
     */
    private void startGame(int size) {
        GameController controller = new GameController(size, this);
        setContentPane(controller.getGamePanel());
        resizeWindowForBoard(size);
        revalidate();
        repaint();
    }

    /**
     * Resizes the game window based on the selected board size.
     * The window size is adjusted to fit the cells and provide spacing for controls.
     *
     * @param size the size of the board (number of rows/columns)
     */
    private void resizeWindowForBoard(int size) {
        int windowSize = CELL_SIZE * size + 80;
        setSize(windowSize, windowSize);
        setLocationRelativeTo(null); 
    }

    /**
     * Restarts the game by displaying the board size selection screen.
     * This method is typically called after a game ends.
     */
    public void restart() {
        showBoardSizeSelection();
    }
}

