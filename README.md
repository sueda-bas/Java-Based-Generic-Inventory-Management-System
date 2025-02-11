# 📦 Java-Based-Generic-Inventory-Management-System

This project is a **Java-based Inventory Management System** that uses **Generics** to manage items like Books, Toys, and Stationery efficiently. It supports operations such as **adding, removing, searching, and displaying items**.

## 📌 Features
- **Uses Java Generics**: Implements a type-safe inventory system for different item types.
- **Supports Various Item Categories**:
  - **Books**: Stored with name, author, barcode, and price.
  - **Toys**: Stored with name, color, barcode, and price.
  - **Stationery**: Stored with name, kind, barcode, and price.
- **Inventory Operations**:
  - **Add an item** (`ADD` command).
  - **Remove an item** by barcode (`REMOVE` command).
  - **Search by barcode or name** (`SEARCHBYBARCODE` and `SEARCHBYNAME`).
  - **Display all items**, grouped by category (`DISPLAY` command).
- **File-Based Input & Output**:
  - Reads inventory commands from `commands.txt`.
  - Writes results to `output.txt`.

## 🎮 How It Works
1. The program reads an inventory operation list from `commands.txt`.
2. It processes the operations using Generics to manage different item types.
3. The final inventory status and search results are written to `output.txt`.


## 🚀 Running the Program
Compile and run the program using:
```bash
javac8 Main.java
java8 Main commands.txt output.txt


