package main.utils;

import java.util.ArrayList;
import java.util.Random;

public class PageSequenceGenerator {
    public static int[] generate(int length, int range, double localityRatio) {
        int[] sequence = new int[length];
        Random random = new Random();

        // Calculate working set size
        int workingSetSize = Math.max(2, range / 4);

        // Initialize working set using ArrayList
        ArrayList<Integer> workingSet = new ArrayList<Integer>();

        // Fill working set with unique random pages
        while (workingSet.size() < workingSetSize) {
            int page = random.nextInt(range) + 1;
            if (!workingSet.contains(page)) {
                workingSet.add(page);
            }
        }

        // Generate page request sequence
        for (int i = 0; i < length; i++) {
            double randVal = random.nextDouble();

            if (randVal < localityRatio && !workingSet.isEmpty()) {
                // Select page from active working set (Temporal Locality)
                int randomIndex = random.nextInt(workingSet.size());
                sequence[i] = workingSet.get(randomIndex);
            } else {
                // Generate new random page
                int newPage = random.nextInt(range) + 1;
                sequence[i] = newPage;

                // 10% chance to replace a page in working set (Locality Shift)
                if (random.nextDouble() < 0.1 && !workingSet.isEmpty()) {
                    int removeIndex = random.nextInt(workingSet.size());
                    workingSet.remove(removeIndex);
                    workingSet.add(newPage);
                }
            }
        }

        return sequence;
    }
}