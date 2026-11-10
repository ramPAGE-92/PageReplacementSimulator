package main.algorithms;

import java.util.LinkedList;
import java.util.Queue;
import main.models.PageStats;
import java.util.HashSet;

public class FIFO implements Algorithm {

    @Override
    public PageStats simulate(int frames, int[] referenceString) {
        HashSet<Integer> set = new HashSet<>(frames);
        Queue<Integer> queue = new LinkedList<>();
        int pageFaults = 0;
        int pageHits = 0;

        for (int i = 0; i < referenceString.length; i++) {
            int page = referenceString[i];
            
            System.out.print("Adım " + (i + 1) + " | Gelen Sayfa: [" + page + "] --> ");
            
            // Case 1: Page hit (page already exists in memory)
            if (set.contains(page)) {
                pageHits++;
                System.out.println("✅ PAGE HIT (Sayfa zaten RAM'de)");
            } 
            // Case 2: Page fault (page not in memory)
            else {
                pageFaults++;

                // if memory is full, remove the oldest page (First-In, First-Out)
                if (set.size() == frames) {
                    int oldestPage = queue.poll();
                    set.remove(oldestPage);
                    System.out.println("❌ PAGE FAULT (RAM Dolu! Çıkarılan Sayfa: " + oldestPage + ")");
                } else {
                    System.out.println("❌ PAGE FAULT (Zorunlu - Boş çerçeveye eklendi)");
                }

                // Add the new page to memory and queue
                set.add(page);
                queue.add(page);
            }
            
            // RAM'in o anki içini görselleştir
            System.out.print("Güncel RAM Durumu: [ ");
            Object[] currentRam = queue.toArray();
            for (int j = 0; j < frames; j++) {
                if (j < currentRam.length) {
                    System.out.print(currentRam[j] + " ");
                } else {
                    System.out.print("- "); // Boş çerçeveler için tire
                }
                if (j < frames - 1) System.out.print("| ");
            }
            System.out.println("]\n");
            
            // Sistemi uyutarak animasyon etkisi yaratma
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Return the page statistics
        return new PageStats(pageFaults, pageHits);
    }
}