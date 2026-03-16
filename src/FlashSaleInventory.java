import java.util.*;

public class FlashSaleInventory {

    private HashMap<String, Integer> stock = new HashMap<>();
    private LinkedHashMap<Integer, String> waitingList = new LinkedHashMap<>();

    public void addProduct(String productId, int quantity) {
        stock.put(productId, quantity);
    }

    public synchronized String purchaseItem(String productId, int userId) {

        int currentStock = stock.getOrDefault(productId, 0);

        if (currentStock > 0) {
            stock.put(productId, currentStock - 1);
            return "Success. Remaining: " + (currentStock - 1);
        } else {
            waitingList.put(userId, productId);
            return "Added to waiting list. Position: " + waitingList.size();
        }
    }

    public int checkStock(String productId) {
        return stock.getOrDefault(productId, 0);
    }

    public static void main(String[] args) {

        FlashSaleInventory inv = new FlashSaleInventory();
        inv.addProduct("IPHONE15", 2);

        System.out.println(inv.purchaseItem("IPHONE15", 1));
        System.out.println(inv.purchaseItem("IPHONE15", 2));
        System.out.println(inv.purchaseItem("IPHONE15", 3));
    }
}