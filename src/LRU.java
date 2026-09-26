import java.util.LinkedList;

public class LRU implements Algorithm {
    private LinkedList<Integer> memory = new LinkedList<>();

    public PageStats simulate(int frames, int[] referenceString){
        int pageFaults = 0, pageHits = 0;
        boolean hasSpace;

        for(int page : referenceString){
            hasSpace = memory.size() < frames;
            
            //Check if the page is already exists in the memory
            if(memory.contains(page)){ 
                //Page Hit: Move the existing page to the end of the list (Most Recently Used)
                memory.remove(memory.indexOf(page));
                memory.addLast(page);
                pageHits++;
            }
            else{
                //Page Fault: Remove the first element from the list (Least Recently Used)
                if(!hasSpace)
                    memory.removeFirst();

                //Add the new page at the and of the list
                memory.addLast(page);
                pageFaults++;
            }
        }

        //Return the number of Page Faults and Page Hits
        return new PageStats(pageFaults, pageHits);
    }
}