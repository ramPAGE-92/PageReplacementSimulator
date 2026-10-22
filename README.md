# Page Replacement Simulator

## Overview
This project is a Java-based terminal simulator developed for the Operating Systems course at Doğuş Üniversitesi. It evaluates and compares the performance of various Page Replacement Algorithms by calculating total page hits and page faults for a given reference string.

## Supported Algorithms
* FIFO (First-In, First-Out)
* LRU (Least Recently Used)
* Optimal (Optimal Page Replacement)

## Team Members
* Ege Tuğrul - 202303001092
* Faruk Tanyeri - 202303001071
* Enes Kanal - 202303001029
* Eylül Azra Karlıdağ - 202403001052

## How to Compile and Run
1. Open your terminal or command prompt.
2. Navigate to the folder containing the project files.
3. Compile all Java files using the following command:
   javac *.java

4. Run the main simulator class:
   java Simulator

## Usage
Upon executing the program, you will be prompted to provide the environment setup:
1. Frame Count: Enter the number of available memory frames (e.g., 3).
2. Reference String: Enter the sequence of page requests separated by spaces (e.g., 7 0 1 2 0 3 0 4 2 3).

The simulator will process the sequence and display a comparative table of Page Hits and Page Faults for all supported algorithms simultaneously.
