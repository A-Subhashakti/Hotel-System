class Guest {
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
