import java.util.LinkedList;

public class LRU implements Algorithm {
    
    @Override
    public PageStats simulate(int frames, int[] referenceString) {
        LinkedList<Integer> memory = new LinkedList<>();
        int pageFaults = 0;
        int pageHits = 0;

        for (int i = 0; i < referenceString.length; i++) {
            int page = referenceString[i];
            
            System.out.print("Adım " + (i + 1) + " | Gelen Sayfa: [" + page + "] --> ");
            
            // Check if the page already exists in the memory
            if (memory.contains(page)) { 
                // Page Hit: Move the existing page to the end of the list (Most Recently Used)
                memory.remove(memory.indexOf(page));
                memory.addLast(page);
                pageHits++;
                System.out.println("✅ PAGE HIT (Sayfa güncellendi ve en sona alındı)");
            } else {
                pageFaults++;
                
                // Page Fault
                if (memory.size() == frames) {
                    // Remove the first element from the list (Least Recently Used)
                    int evictedPage = memory.removeFirst();
                    System.out.println("❌ PAGE FAULT (RAM Dolu! Çıkarılan Sayfa: " + evictedPage + " [En Eski Kullanılan])");
                } else {
                    System.out.println("❌ PAGE FAULT (Zorunlu - Boş çerçeveye eklendi)");
                }
                
                // Add the new page at the end of the list
                memory.addLast(page);
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

        // Return the number of Page Faults and Page Hits
        return new PageStats(pageFaults, pageHits);
    }
}