import java.util.ArrayList;
import java.util.Scanner;

class Bus {
    private int totalSeats;
    private ArrayList<Boolean> seats;

    public Bus(int totalSeats) {
        this.totalSeats = totalSeats;
        seats = new ArrayList<>(totalSeats);
        for (int i = 0; i < totalSeats; i++) {
            seats.add(false);
        }
    }

    public void displayAvailableSeats() {
        System.out.println("Available Seats:");
        for (int i = 0; i < totalSeats; i++) {
            if (!seats.get(i)) {
                System.out.print(i + 1 + " ");
            }
        }
        System.out.println();
    }

    public boolean bookSeat(int seatNumber) {
        if (seatNumber <= 0 || seatNumber > totalSeats) {
            System.out.println("Invalid seat number.");
            return false;
        }

        if (seats.get(seatNumber - 1)) {
            System.out.println("Seat already booked. Please choose another seat.");
            return false;
        }

        seats.set(seatNumber - 1, true);
        System.out.println("Seat " + seatNumber + " booked successfully.");
        return true;
    }

    public boolean cancelSeat(int seatNumber) {
        if (seatNumber <= 0 || seatNumber > totalSeats) {
            System.out.println("Invalid seat number.");
            return false;
        }

        if (!seats.get(seatNumber - 1)) {
            System.out.println("Seat is not booked. Cannot cancel.");
            return false;
        }

        seats.set(seatNumber - 1, false);
        System.out.println("Seat " + seatNumber + " canceled successfully.");
        return true;
    }
}

public class BusReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the total number of seats in the bus: ");
        int totalSeats = scanner.nextInt();

        Bus bus = new Bus(totalSeats);

        while (true) {
            System.out.println("\n1. Display available seats\n2. Book a seat\n3. Cancel a seat\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bus.displayAvailableSeats();
                    break;
                case 2:
                    System.out.print("Enter the seat number to book: ");
                    int bookSeatNumber = scanner.nextInt();
                    bus.bookSeat(bookSeatNumber);
                    break;
                case 3:
                    System.out.print("Enter the seat number to cancel: ");
                    int cancelSeatNumber = scanner.nextInt();
                    bus.cancelSeat(cancelSeatNumber);
                    break;
                case 4:
                    System.out.println("Exiting the program. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
