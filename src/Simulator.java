import java.util.Scanner;

public class Simulator {

    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== PAGE REPLACEMENT SIMULATOR ===");
        
        while (true) {
            // 1. Verileri alıyoruz
            int frames = inputManager.getFrameCount();
            int[] referenceString = inputManager.getReferenceString();
            
            System.out.println("\n--- SIMULATION RESULTS ---");
            
            // 2. Tüm algoritmaları sırasıyla çalıştırıp sonuçları ekrana basıyoruz
            
            // FIFO
            Algorithm fifo = new FIFO();
            PageStats fifoSonuc = fifo.simulate(frames, referenceString);
            System.out.println("[FIFO]    Page Hits: " + fifoSonuc.pageHits + "  |  Page Faults: " + fifoSonuc.pageFaults);
            
            // LRU
            Algorithm lru = new LRU();
            PageStats lruSonuc = lru.simulate(frames, referenceString);
            System.out.println("[LRU]     Page Hits: " + lruSonuc.pageHits + "  |  Page Faults: " + lruSonuc.pageFaults);
            
            // Optimal
            Algorithm optimal = new Optimal();
            PageStats optimalSonuc = optimal.simulate(frames, referenceString);
            System.out.println("[Optimal] Page Hits: " + optimalSonuc.pageHits + "  |  Page Faults: " + optimalSonuc.pageFaults);
            
            System.out.println("----------------------------");
            
            // 3. Tekrar denemek isteyip istemediğini soruyoruz
            System.out.print("\nWould you like to test another sequence? (Y/N): ");
            String devam = scanner.next();
            
            if (devam.equalsIgnoreCase("N")) {
                System.out.println("Shutting down simulator...");
                break;
            }
        }
        
        scanner.close();
    }
}