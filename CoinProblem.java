import java.util.*;

public class CoinProblem {
    public static void main(String[] args) {
        int amount = 1988;
        
        // Pakistani denominations in descending order
        int[] denominations = {5000, 1000, 500, 100, 50, 20, 10, 5, 2, 1};
        
        System.out.println("Total Amount: Rs. " + amount);
        System.out.println("Denomination Breakdown:");

        int totalNotes = 0;

        for (int bill : denominations) {
            if (amount >= bill) {
                int count = amount / bill;
                amount = amount % bill;
                
                totalNotes += count;
                System.out.println("Rs. " + bill + " x " + count);
            }
        }

        System.out.println("Total units of currency used: " + totalNotes);
    }
}
