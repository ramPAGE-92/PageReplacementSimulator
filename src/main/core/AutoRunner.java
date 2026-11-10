package main.core;

import main.utils.PageSequenceGenerator;
import main.io.DisplayManager;
import main.algorithms.*;
import main.models.PageStats;

public class AutoRunner {
    public static void main (String[] args) {
        int[] sequence1 = PageSequenceGenerator.generate(1000, 12, 0.80);

        System.out.println("First sequence: ");
        DisplayManager.displaySequence(sequence1);
        System.out.println("Length: 500   Range: 12   Locality Ratio: 0.75");

        DisplayManager.pressEnterToContinue();

        FIFO fifo = new FIFO();
        PageStats fifoStats = fifo.simulate(3, sequence1);
        System.out.printf("FIFO| Page Hits: %d   Page Faults: %d\n\n", fifoStats.pageHits, fifoStats.pageFaults);

        DisplayManager.pressEnterToContinue();
        
        LRU lru = new LRU();
        PageStats lruStats = lru.simulate(3, sequence1);
        System.out.printf("LRU| Page Hits: %d   Page Faults: %d\n\n", lruStats.pageHits, lruStats.pageFaults);

        DisplayManager.pressEnterToContinue();

        Optimal opt = new Optimal();
        PageStats optStats = opt.simulate(3, sequence1);
        System.out.printf("Optimal| Page Hits: %d   Page Faults: %d\n\n", optStats.pageHits, optStats.pageFaults);

        DisplayManager.pressEnterToContinue();

        System.out.println("------------------------------------");
        System.out.println("First Sequence Fİnal Results:\n");
        System.out.println("------------------------------------");
        System.out.printf("FIFO| Page Hits: %d   Page Faults: %d\n\n", fifoStats.pageHits, fifoStats.pageFaults);
        System.out.printf("LRU| Page Hits: %d   Page Faults: %d\n\n", lruStats.pageHits, lruStats.pageFaults);
        System.out.printf("Optimal| Page Hits: %d   Page Faults: %d\n\n", optStats.pageHits, optStats.pageFaults);

        DisplayManager.pressEnterToContinue();

        int[] sequence2 = PageSequenceGenerator.generate(1000, 12, 0.2);

        System.out.println("Second sequence: ");
        DisplayManager.displaySequence(sequence2);
        System.out.println("Length: 500   Range: 12   Locality Ratio: 0.2");

        DisplayManager.pressEnterToContinue();

        FIFO fifo2 = new FIFO();
        PageStats fifoStats2 = fifo2.simulate(3, sequence2);
        System.out.printf("FIFO| Page Hits: %d   Page Faults: %d\n\n", fifoStats2.pageHits, fifoStats2.pageFaults);

        DisplayManager.pressEnterToContinue();
        
        LRU lru2 = new LRU();
        PageStats lruStats2 = lru2.simulate(3, sequence2);
        System.out.printf("LRU| Page Hits: %d   Page Faults: %d\n\n", lruStats2.pageHits, lruStats2.pageFaults);

        DisplayManager.pressEnterToContinue();

        Optimal opt2 = new Optimal();
        PageStats optStats2 = opt2.simulate(3, sequence2);
        System.out.printf("Optimal| Page Hits: %d   Page Faults: %d\n\n", optStats2.pageHits, optStats2.pageFaults);

        DisplayManager.pressEnterToContinue();

        System.out.println("------------------------------------");
        System.out.println("Second Sequence Fİnal Results:\n");
        System.out.println("------------------------------------");
        System.out.printf("FIFO| Page Hits: %d   Page Faults: %d\n\n", fifoStats2.pageHits, fifoStats2.pageFaults);
        System.out.printf("LRU| Page Hits: %d   Page Faults: %d\n\n", lruStats2.pageHits, lruStats2.pageFaults);
        System.out.printf("Optimal| Page Hits: %d   Page Faults: %d\n\n", optStats2.pageHits, optStats2.pageFaults);
    
        DisplayManager.input.close();
    }
}