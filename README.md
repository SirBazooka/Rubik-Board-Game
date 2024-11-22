# Rubik Board Game

A two-dimensional variant of the classic Rubik's Cube, implemented in Java using `JComponent`. The game challenges players to rearrange colors on an `n x n` board until each row or column consists of a single uniform color.

## Features

- **Customizable Board Size**: Choose between 2x2, 4x4, and 6x6 grids for varying difficulty levels.
- **Interactive Gameplay**: Move rows and columns cyclically to align colors.
- **Automatic Victory Detection**: The game recognizes when all rows or columns are homogeneous.
- **Step Counter**: Tracks the number of moves taken to solve the puzzle.
- **Auto-Restart**: After solving the game, a new randomized game starts automatically.

## How to Play

1. Select a board size (2x2, 4x4, or 6x6).
2. Use the controls to shift rows and columns cyclically.
3. Solve the game by making all rows or all columns a single color.
4. Once solved, a message box will display the number of steps taken, and the game will restart.

## Technologies Used

- **Programming Language**: Java
- **GUI Framework**: Swing (`JComponent`)

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/rubik-board-game.git
