import java.util.ArrayList;
import java.util.List;

public class Optimal implements Algorithm {

    @Override
    public PageStats simulate(int frames, int[] referenceString) {
        List<Integer> memory = new ArrayList<>();
        int pageFaults = 0;
        int pageHits = 0;

        for (int i = 0; i < referenceString.length; i++) {
            int page = referenceString[i];
            
            System.out.print("Adım " + (i + 1) + " | Gelen Sayfa: [" + page + "] --> ");

            // Case 1: Page hit (page already in memory)
            if (memory.contains(page)) {
                pageHits++;
                System.out.println("✅ PAGE HIT (Sayfa zaten RAM'de)");
            } 
            // Case 2: Page fault (page not in memory)
            else {
                pageFaults++;

                // If memory still has space, just add the page
                if (memory.size() < frames) {
                    memory.add(page);
                    System.out.println("❌ PAGE FAULT (Zorunlu - Boş çerçeveye eklendi)");
                } 
                // Memory is full: find the optimal page to replace
                else {
                    int victimIndex = findPageToReplace(memory, referenceString, i + 1);
                    int evictedPage = memory.get(victimIndex); // Silinmeden önce kurbanın adını alıyoruz
                    memory.set(victimIndex, page);
                    System.out.println("❌ PAGE FAULT (RAM Dolu! Çıkarılan Sayfa: " + evictedPage + " [Gelecekte En Az İhtiyaç Duyulan])");
                }
            }
            
            // RAM'in o anki içini görselleştir
            System.out.print("Güncel RAM Durumu: [ ");
            for (int j = 0; j < frames; j++) {
                if (j < memory.size()) {
                    System.out.print(memory.get(j) + " ");
                } else {
                    System.out.print("- "); // Boş çerçeveler için tire
                }
                if (j < frames - 1) System.out.print("| ");
            }
            System.out.println("]\n");
            
            // Sistemi uyutarak animasyon etkisi yaratma
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Return the page statistics
        return new PageStats(pageFaults, pageHits);
    }

    // Helper method to find the page that will not be used for the longest period of time
    private int findPageToReplace(List<Integer> memory, int[] referenceString, int startIndex) {
        int farthestIndex = -1;
        int victimIndex = -1;

        for (int i = 0; i < memory.size(); i++) {
            int page = memory.get(i);
            int nextUse = -1;

            // Search future references for the next occurrence of this page
            for (int j = startIndex; j < referenceString.length; j++) {
                if (referenceString[j] == page) {
                    nextUse = j;
                    break;
                }
            }

            // If the page is never used again in the future, replace it immediately
            if (nextUse == -1) {
                return i;
            }

            // If the page is referenced furthest in the future, mark it as victim
            if (nextUse > farthestIndex) {
                farthestIndex = nextUse;
                victimIndex = i;
            }
        }

        return (victimIndex != -1) ? victimIndex : 0;
    }
}