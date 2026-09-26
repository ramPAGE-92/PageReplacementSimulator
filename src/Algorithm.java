public interface Algorithm {
    // Tüm algoritmaların (FIFO, LRU, Optimal) kullanacağı ortak metot
    PageStats simulate(int frames, int[] referenceString);
    
    
}