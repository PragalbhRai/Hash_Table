import java.util.*;

class Client {
    String name;
    int risk;

    Client(String n, int r) {
        name = n;
        risk = r;
    }

    public String toString() {
        return name + ":" + risk;
    }
}

public class Problem2 {

    static void bubbleSort(Client[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j].risk > arr[j + 1].risk) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    static void insertionSort(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].risk < key.risk) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Client[] arr = {
                new Client("A", 20),
                new Client("B", 50),
                new Client("C", 80)
        };

        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}