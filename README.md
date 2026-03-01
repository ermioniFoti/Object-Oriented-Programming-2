# TucTacToe - Professional Tic-Tac-Toe with GUI & AI

A feature-rich Tic-Tac-Toe application developed in Java using the **Swing** library. This project was created as the second assignment for the **PLH 102 - Object-Oriented Programming** course at the **Technical University of Crete** (Spring 2021).

## 🎮 Project Overview
[cite_start]TucTacToe is more than just a simple game; it is a complete software system implementing advanced AI algorithms, persistent data storage, and a dynamic Graphical User Interface (GUI) following the **Model-View-Controller (MVC)** architectural pattern[cite: 112, 117, 268].

## 🚀 Key Features
* [cite_start]**Multiple Game Modes:** * Human vs. Human[cite: 142].
    * [cite_start]Human vs. Computer (AI)[cite: 143].
    * [cite_start]Computer vs. Computer (AI Battle)[cite: 144].
* **Advanced AI Opponents:**
    * **Mr. [cite_start]Bean:** A casual AI that plays using random moves[cite: 170, 171].
    * [cite_start]**Hal:** An unbeatable AI that uses a "Game Tree" and the **Minimax** algorithm (with optional Alpha-Beta pruning) to play perfectly[cite: 170, 172, 246, 265].
* [cite_start]**Hall of Fame:** A persistent ranking system displaying the top 10 players based on a custom performance formula[cite: 154, 168].
* [cite_start]**Persistent Statistics:** Saves player profiles, win/loss/tie ratios, and the 5 best/most recent games to a local file (`tuctactoe.ser`) using Java Serialization[cite: 146, 151, 156, 162].


## 🏗️ Technical Architecture (MVC)
[cite_start]The project is strictly organized to ensure separation of concerns[cite: 268]:
* [cite_start]**Model:** Handles game logic, the 3x3 board state (implemented as an immutable class), and data structures for player rosters[cite: 270, 293, 295].
* [cite_start]**View:** A graphical interface built with Java Swing, featuring custom panels for the game board, the Hall of Fame, and player statistics [cite: 273, 355-357].
* [cite_start]**Controller:** Manages user events (ECA rules) and governs the application's state transitions (NotReady, Ready, InPlay, GameOver)[cite: 276, 435, 455].


## 🛠️ Development & Best Practices
* [cite_start]**Unit Testing:** The project includes extensive unit tests to verify the domain model and AI correctness[cite: 185, 485].
* [cite_start]**Custom Framework:** All data structures (lists, trees, etc.) and algorithms (searching, sorting) are implemented from scratch rather than using built-in Java collections[cite: 141].
* [cite_start]**Version Control:** Developed collaboratively using **Git** and GitHub[cite: 176, 178].

## 📊 Scoring Formula
Player scores are calculated on a scale of 0 to 100 using the following logic:
[cite_start]$$\sigma ko\rho=50\times\frac{2*wins+ties}{total\_games}$$ [cite: 154, 155]

---
*Developed by the School of Electrical and Computer Engineering, Technical University of Crete.*
