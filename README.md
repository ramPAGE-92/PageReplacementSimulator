# Page Replacement Simulator

**Page Replacement Simulator** is a learning and analysis tool that shows how an operating system manages RAM when its capacity is full.

Memory management normally happens invisibly inside the OS kernel, which makes it hard to understand or compare. This simulator makes it visible: you give it a workload, and it shows exactly how well different page replacement algorithms perform.

## What Problem Does It Solve?
An operating system has a difficult memory question to answer all the time: When RAM is full and a new page is needed, which page should be thrown out? A poor choice means the system keeps reloading pages from disk and slows down. This is the **page replacement problem**.

There is no single best answer in practical scenarios. This simulator lets you run the classic algorithms on the same input and compare the results directly to see these trade-offs.

## What Can You Do With It?
**Simulate page replacement**  
Provide a sequence of page requests (reference string) and a number of memory frames. The simulator replays the sequence and evaluates the performance of three core algorithms simultaneously:

| Algorithm | Idea |
|---|---|
| **FIFO** | Evict the page that arrived first. |
| **LRU** | Evict the page that has not been used for the longest time. |
| **Optimal** | Evict the page that will not be needed for the longest time (theoretical best, used as a benchmark). |

You get the total page fault count and page hit count for each algorithm in a neat comparative view.

## Who Is It For?
- Students learning operating systems who want to see textbook algorithms run on real input instead of working them out by hand.
- Instructors who need a quick way to demonstrate the difference between algorithms.
- Anyone who wants to experiment with how workload and memory frame sizes affect performance.

## A Quick Example
Reference string `7 0 1 2 0 3 0 4 2 3` with `3` frames:

| Algorithm | Page Faults | Hits |
|---|---|---|
| **FIFO** | 9 | 1 |
| **LRU** | 8 | 2 |
| **Optimal** | 6 | 4 |

*Optimal never does worse than the others. The gap between it and FIFO or LRU shows how much a real algorithm loses by not knowing the future.*

## Running It
Requirements: Java Development Kit (JDK) 8 or later, Git.

    git clone https://github.com/ramPAGE-92/PageReplacementSimulator.git
    cd PageReplacementSimulator

1. Compile all the Java files:
    javac *.java

2. Start the application:
    java Simulator

## Built With
Java (100% Pure OOP).  
The code is organized cleanly using interfaces. Every algorithm implements a shared Algorithm interface, returning a structured PageStats object, meaning new algorithms can be easily added without touching the core simulator logic.

## Team
| Name | Student No. |
|---|---|
| Ege Tuğrul | 202303001092 |
| Faruk Tanyeri | 202303001071 |
| Enes Kanal | 202303001029 |
| Eylül Azra Karlıdağ | 202403001052 |

*Developed for the Operating Systems course at Doğuş Üniversitesi.*
