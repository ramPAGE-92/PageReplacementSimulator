package main.core;

import java.util.Scanner;
import main.algorithms.Algorithm;
import main.algorithms.FIFO;
import main.algorithms.LRU;
import main.algorithms.Optimal;
import main.io.InputManager;
import main.models.PageStats;

public class InteractiveRunner {
    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== PAGE REPLACEMENT SIMULATOR ===");
        
        while (true) {
           
            int frames = inputManager.getFrameCount();
            int[] referenceString = inputManager.getReferenceString();
            
            System.out.println("\n===========================================");
            System.out.println("  ramPAGE - ALGORİTMA SEÇİM MENÜSÜ");
            System.out.println("===========================================");
            System.out.println("1 - FIFO (First-In, First-Out)");
            System.out.println("2 - LRU (Least Recently Used)");
            System.out.println("3 - Optimal");
            System.out.print("\nÇalıştırmak istediğiniz algoritmayı seçin (1/2/3): ");
            
            int secim = scanner.nextInt();
            System.out.println("\nSimülasyon hazırlanıyor...\n");
            
            switch (secim) {
                case 1:
                    Algorithm fifo = new FIFO();
                    PageStats fifoSonuc = fifo.simulate(frames, referenceString);
                    System.out.println("\n[SONUÇ] FIFO Page Hits: " + fifoSonuc.pageHits + "  |  Page Faults: " + fifoSonuc.pageFaults);
                    break;
                case 2:
                    Algorithm lru = new LRU();
                    PageStats lruSonuc = lru.simulate(frames, referenceString);
                    System.out.println("\n[SONUÇ] LRU Page Hits: " + lruSonuc.pageHits + "  |  Page Faults: " + lruSonuc.pageFaults);
                    break;
                case 3:
                    Algorithm optimal = new Optimal();
                    PageStats optimalSonuc = optimal.simulate(frames, referenceString);
                    System.out.println("\n[SONUÇ] Optimal Page Hits: " + optimalSonuc.pageHits + "  |  Page Faults: " + optimalSonuc.pageFaults);
                    break;
                default:
                    System.out.println("❌ Hatalı seçim yaptınız! Lütfen geçerli bir algoritma (1, 2 veya 3) seçin.");
                    break;
            }
            System.out.println("----------------------------");
            
            
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