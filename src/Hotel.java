import java.util.Scanner;

public class Hotel
{
    FileIO fileIO = new FileIO();

    public void HotelManagement()
    {
        fileIO.readData();
        Scanner in = new Scanner(System.in);

        while (true)
        {
            System.out.println("Velkommen til booking system");
            System.out.println("-------------------------------");
            System.out.println("1. Registrer gæst");
            System.out.println("2. Se alle registrerede gæster");
            System.out.println("3. Vis alle værelser");
            System.out.println("4. Vis ledige værelser");
            System.out.println("5. Book et værelse");
            System.out.println("6. Vis alle bookings");
            System.out.println("7. Se menukort");
            //System.out.println("6. Bestil mad på værelset"); Vi fik det ikke til at fungere 100%, derfor er denne mulighed udkommenteret
            System.out.println("8. Check ud af værelse");
            System.out.println("9. Afbestil reservation");
            System.out.println("10. Gem & Afslut \n");
            System.out.print("Indtast dit valg: ");
            int choice = in.nextInt();
            switch (choice)
            {
                case 1:
                    fileIO.registerGuest();
                    break;
                case 2:
                    fileIO.showAllRegisteredGuests();
                    break;
                case 3:
                    fileIO.showAllRooms();
                    break;
                case 4:
                    fileIO.showAvailableRooms();
                    break;
                case 5:
                    fileIO.bookRoom();
                    break;
                case 6:
                    fileIO.showAllBookings();
                    //fileIO.orderFood();
                    break;
                case 7:
                    fileIO.showFoodMenu();
                    break;
                case 8:
                    fileIO.checkout();
                    break;
                case 9:
                    fileIO.cancelBooking();
                    break;
                case 10:
                    fileIO.saveData();
                    System.out.println("----------------------------------");
                    System.out.println("Tak for at benytte vores booking system");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ugyldigt valg!");
                    break;
            }
        }
    }
}
