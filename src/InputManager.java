import java.util.Scanner;

public class InputManager {
    private Scanner scanner;

    public InputManager() {
        scanner = new Scanner(System.in);
    }

    // Kullanıcıdan frame (çerçeve) sayısını alır
    public int getFrameCount() {
        System.out.print("Please enter the number of frames: ");
        int frameCount = scanner.nextInt();
        scanner.nextLine(); 
        return frameCount;
    }

    // Kullanıcıdan referans dizisini alır (aralarında boşluk bırakarak)
    public int[] getReferenceString() {
        System.out.print("Enter the reference string separated by spaces (e.g., 7 0 1 2 0): ");
        String input = scanner.nextLine();
        
        // Girilen metni boşluklardan bölüp int dizisine çevirir
        String[] stringArray = input.trim().split("\\s+");
        int[] referenceString = new int[stringArray.length];
        
        for (int i = 0; i < stringArray.length; i++) {
            referenceString[i] = Integer.parseInt(stringArray[i]);
        }
        
        return referenceString;
    }
}