# TucTacToe

A professional-grade Tic-Tac-Toe application with a graphical user interface (GUI) and advanced Artificial Intelligence components. This project was developed as part of the **PLH 102 - Object-Oriented Programming** course at the **Technical University of Crete** (Spring 2022).

## 📌 Overview
TucTacToe is a Java-based application that implements the classic Tic-Tac-Toe game using the **Swing** library for its graphical interface. The project emphasizes proper software engineering practices, including the **Model-View-Controller (MVC)** architectural pattern, unit testing, and custom implementation of data structures and algorithms.

## 🚀 Features

### Game Modes
* **Player vs. Player:** Standard two-player mode.
* **Player vs. Computer:** Challenge an AI opponent.
* **Computer vs. Computer:** Watch two AI agents play against each other.

### Artificial Intelligence
The application includes distinct AI personalities:
* **Mr. Bean:** A casual opponent that selects moves randomly.
* **Hal:** A perfect player powered by a **Game Tree** and the **Minimax algorithm**, making it impossible to defeat.

### Persistent Data & Statistics
* **Player Profiles:** Stores player history including total games, wins, losses, and ties.
* **Hall of Fame:** Displays the top 10 players based on a custom scoring formula.
* **Data Persistence:** All player data and game history are serialized and saved locally to `tuctactoe.ser`.

### Advanced Scoring System
Player performance is calculated using a weighted formula (0-100 scale):

$$Score = 50 \times \frac{2 \times Wins + Ties}{Total Games}$$

## 🏗️ Technical Architecture

The codebase follows the **MVC** pattern to separate concerns:

* **Model:**
    * `Board`: Represents the game state (immutable design).
    * `Player`: Manages user profiles and history (recent/best games).
    * `GameRecord`: Archives finished game details.
    * `PlayerRoster`: Handles player lookup and registration.
* **View:**
    * `MainWindow`: The primary application container.
    * `GamePanel`: Renders the grid and player moves.
    * `HallOfFame`: Displays high scores.
* **Controller:**
    * Implements **Event-Condition-Action (ECA)** rules to manage game flow.
    * Manages state transitions (e.g., NotReady → Ready → InPlay → GameOver).

## 🛠️ Requirements
* **Language:** Java
* **GUI Library:** Swing.
* **Data Structures:** Custom implementations (lists, trees, maps) are used instead of standard Java Collections.

---
*Developed for the School of Electrical and Computer Engineering, Technical University of Crete.*
