import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;

public class FIFO implements Algorithm {

    @Override
    public PageStats simulate(int frames, int[] referenceString) {
        HashSet<Integer> set = new HashSet<>(frames);
        Queue<Integer> queue = new LinkedList<>();
        int pageFaults = 0;
        int pageHits = 0;

        for (int page : referenceString) {
            // Case 1: Page hit (page already exists in memory)
            if (set.contains(page)) {
                pageHits++;
            } 
            // Case 2: Page fault (page not in memory)
            else {
                pageFaults++;

                // if memory is full, remove the oldest page (First-In, First-Out)
                if (set.size() == frames) {
                    int oldestPage = queue.poll();
                    set.remove(oldestPage);
                }

                // Add the new page to memory and queue
                set.add(page);
                queue.add(page);
            }
        }

        // Return the page statistics
        return new PageStats(pageFaults, pageHits);
    }
}