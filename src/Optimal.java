// Optimal Page Replacement Algorithm Implementation - Eylul
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

            // Case 1: Page hit (page already in memory)
            if (memory.contains(page)) {
                pageHits++;
            } 
            // Case 2: Page fault (page not in memory)
            else {
                pageFaults++;

                // If memory still has space, just add the page
                if (memory.size() < frames) {
                    memory.add(page);
                } 
                // Memory is full: find the optimal page to replace
                else {
                    int victimIndex = findPageToReplace(memory, referenceString, i + 1);
                    memory.set(victimIndex, page);
                }
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