import java.time.LocalDateTime;
import java.util.*;

public class Hotel {

   static class Guest {
    int roomId;
    String name, contact;
    String inTime, outTime;

    Guest(int id, String n, String c) {
        roomId = id;
        name = n;
        contact = c;
        inTime = java.time.LocalDateTime.now().toString();
        outTime = "Not Checked Out";
    }
}


    static ArrayList<Guest> guests = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int roomId = 101;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1.Check-In  2.View  3.Search  4.Check-Out  5.Delete  6.Exit");
            switch (sc.nextInt()) {

                case 1 -> checkIn();
                case 2 -> viewAll();
                case 3 -> search();
                case 4 -> checkOut();
                case 5 -> delete();
                case 6 -> System.exit(0);

                default -> System.out.println("Invalid Choice");
            }
        }
    }


    static void checkIn() {
        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Contact: ");
        String contact = sc.nextLine();

        guests.add(new Guest(roomId++, name, contact));
        System.out.println("Room Allocated Successfully!");
    }

    
    static void viewAll() {
        if (guests.isEmpty()) {
            System.out.println("No Records Found");
            return;
        }
        guests.forEach(g ->
            System.out.println(g.roomId + " | " + g.name + " | " + g.outTime)
        );
    }

    
    static void search() {
        Guest g = findGuest();
        if (g != null)
            System.out.println(g.name + " | " + g.contact + " | " + g.inTime + " | " + g.outTime);
        else
            System.out.println("Room Not Found");
    }

    
    static void checkOut() {
        Guest g = findGuest();
        if (g != null && g.outTime.equals("Not Checked Out")) {
            g.outTime = LocalDateTime.now().toString();
            System.out.println("Checked Out Successfully");
        } else {
            System.out.println("Invalid Operation");
        }
    }

    
    static void delete() {
        Guest g = findGuest();
        if (g != null) {
            guests.remove(g);
            System.out.println("Record Deleted");
        } else {
            System.out.println("Room Not Found");
        }
    }

    static Guest findGuest() {
        System.out.print("Enter Room ID: ");
        int id = sc.nextInt();
        for (Guest g : guests)
            if (g.roomId == id) return g;
        return null;
    }
}
