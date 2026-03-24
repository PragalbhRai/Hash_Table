import java.util.*;

public class ParkingLot {

    String[] spots = new String[10];

    int hash(String plate) {
        return Math.abs(plate.hashCode()) % spots.length;
    }

    public void parkVehicle(String plate) {

        int index = hash(plate);

        while (spots[index] != null) {
            index = (index + 1) % spots.length;
        }

        spots[index] = plate;

        System.out.println("Parked at spot " + index);
    }

    public static void main(String[] args) {

        ParkingLot lot = new ParkingLot();

        lot.parkVehicle("ABC123");
        lot.parkVehicle("XYZ999");
    }
}