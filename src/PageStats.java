public class PageStats {
    public int pageFaults = 0;
    public int pageHits = 0;
    
    PageStats(int pageFaults, int pageHits){
        this.pageFaults = pageFaults;
        this.pageHits = pageHits;
    }
}