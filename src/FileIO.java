import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class FileIO implements IO
{
    ArrayList<Guest> guests = new ArrayList<>();
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Booking> bookings = new ArrayList<>();
    ArrayList<Food> foodOrder = new ArrayList<>();

    public ArrayList<Food> getFoodOrder()
    {
        return foodOrder;
    }

    public void registerGuest()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Fulde navn: ");
        String name = in.nextLine();
        System.out.print("Køn (M/K): ");
        String gender = in.next();
        in.nextLine();
        System.out.print("Nationalitet: ");
        String country = in.nextLine();
        System.out.print("Kontakt (e-mail eller tlf): ");
        String contact = in.next();
        Guest guest = new Guest(name, gender, country, contact);
        guests.add(guest);
    }

    public void showAvailableRooms()
    {
        for (int i = 0; i < rooms.size(); i++)
        {
            if(!rooms.get(i).isStatus())
            {
                System.out.println(rooms.get(i).toString());
            }
        }
    }

    public void bookRoom()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Indtast fulde navn: ");
        String name  = in.nextLine();
        if(findGuest(name) != null)
        {
            Guest guest = findGuest(name);
            System.out.print("Indtast værelsesnummer: ");
            int roomNum = in.nextInt();
            if(isAvailable(roomNum))
            {
                System.out.print("Indtast antal dage: ");
                int days = in.nextInt();
                System.out.print("Indtast startdato (dd/mm/åååå): ");
                String start = in.next();
                System.out.print("Indtast slutdato (dd/mm/åååå): ");
                String end = in.next();
                for (int i = 0; i < rooms.size(); i++)
                {
                    if(rooms.get(i).getRoomNumber() == roomNum)
                    {
                        rooms.get(i).setStatus(true);
                        Room room = getRoom(roomNum);
                        bookings.add(new Booking(room, guest, days, start, end));
                        System.out.println("Værelse er nu reserveret!");
                        return;
                    }
                }
            }
            else
            {
                System.out.println("Værelsesnummer "+roomNum+" er ikke tilgængelig!");
            }
        }
        else
        {
            System.out.println("Gæst er ikke registreret!");
        }
    }

    public void showAllBookings()
    {
        for (int i = 0; i < bookings.size(); i++)
        {
            System.out.println(bookings.get(i).toString());
        }
    }

    public void showAllRooms()
    {
        for (int i = 0; i < rooms.size(); i++)
        {
            System.out.println(rooms.get(i).toString());
        }
    }

    public boolean isAvailable(int roomNum)
    {
        for (int i = 0; i < rooms.size(); i++)
        {
            if (rooms.get(i).getRoomNumber() == roomNum && rooms.get(i).isStatus() == false)
            {
                return true;
            }
        }
        return false;
    }

    public void orderFood()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Indtast værelsesnummer: ");
        int roomNum = in.nextInt();
        for (int i = 0; i < bookings.size(); i++)
        {
            if(bookings.get(i).getRoom().getRoomNumber() == roomNum)
            {
                System.out.print("Indtast varer til bestilling: ");
                String items = in.next();
                foodOrder.get(i).placeOrder(items);
                bookings.get(i).setFood(new Food(9,foodOrder.get(i).getFoodItem(), foodOrder.get(i).getFoodPrice()));
                System.out.println("Ordren er afgivet!");
                return;
            }
        }
        System.out.println("Beklager, dette værelse er ikke reserveret!");
    }

    public void showFoodMenu()
    {
        for (int i = 0; i < foodOrder.size(); i++)
        {
            System.out.println(foodOrder.get(i).toString());
        }
    }

    public void checkout()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Indtast værelsesnummer: ");
        int roomNum = in.nextInt();
        for (int i = 0; i < bookings.size(); i++)
        {
            if(bookings.get(i).getRoom().getRoomNumber() == roomNum)
            {
                String receipt = bookings.get(i).getReceipt();
                bookings.remove(i);
                System.out.println(receipt);
                for (int j = 0; j < rooms.size(); j++)
                {
                    if (rooms.get(j).getRoomNumber() == roomNum)
                    {
                        rooms.get(j).setStatus(false);
                        break;
                    }
                }
                return;
            }
        }
        System.out.println("Beklager, dette værelse er ikke reserveret!");
    }

    public void cancelBooking()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Indtast værelsesnummer: ");
        int roomNum = in.nextInt();
        for (int i = 0; i < bookings.size(); i++)
        {
            if(bookings.get(i).getRoom().getRoomNumber() == roomNum)
            {
                bookings.remove(i);
                for (int j = 0; j < rooms.size(); j++)
                {
                    if (rooms.get(j).getRoomNumber() == roomNum)
                    {
                        rooms.get(i).setStatus(false);
                        break;
                    }
                }
                System.out.println("Booking er nu annulleret!");
                return;
            }
        }
        System.out.println("Beklager, dette værelse er ikke reserveret!");
    }

    public void showAllRegisteredGuests()
    {
        for (int i = 1; i < guests.size(); i++)
        {
            System.out.println(guests.get(i).toString());
        }
    }

    public Guest findGuest(String name)
    {
        for (Guest guest : guests)
        {
            if(guest.getName().equalsIgnoreCase(name))
            {
                return guest;
            }
        }
        return null;
    }

    public Room getRoom(int roomNum)
    {
        for (Room room : rooms)
        {
            if(room.getRoomNumber() == roomNum)
            {
                return room;
            }
        }
        return null;
    }

    @Override
    public void saveData()
    {
        try {
            PrintWriter pw = new PrintWriter(new File("src/guests.csv"));
            for (Guest guest : guests)
            {
                pw.write(guest.getName()+","+guest.getGender()+","+guest.getCountry()+","+guest.getContact());
                pw.write("\n");
            }
            pw.close();
            pw = new PrintWriter(new File("src/food.csv"));
            for (Food food : foodOrder)
            {
                pw.write(food.getFormattedFood());
                pw.write("\n");
            }
            pw.close();
            pw = new PrintWriter(new File("src/rooms.csv"));
            for (Room room : rooms)
            {
                pw.write(room.getFormattedRoom());
                pw.write("\n");
            }
            pw.close();
            pw = new PrintWriter(new File("src/bookings.csv"));
            for (Booking booking : bookings)
            {
                pw.write(booking.getFormattedBooking());
                pw.write("\n");
            }
            pw.close();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void readData()
    {
        try {
            Scanner in = new Scanner(new File("src/guests.csv"));
            while(in.hasNextLine())
            {
                String[] line = in.nextLine().split(",");
                guests.add(new Guest(line[0], line[1], line[2], line[3]));
            }

            in = new Scanner(new File("src/food.csv"));
            while(in.hasNextLine())
            {
                String[] line = in.nextLine().split(",");
                foodOrder.add(new Food(Integer.parseInt(line[0]), line[1], Double.parseDouble(line[2])));
            }

            in = new Scanner(new File("src/rooms.csv"));
            while(in.hasNextLine())
            {
                String[] line = in.nextLine().split(",");
                String facilities = "";
                for (int i = 5; i < line.length; i++)
                {
                    facilities += line[i]+" ";
                }
                rooms.add(new Room(Integer.parseInt(line[0]), line[1], line[2], Double.parseDouble(line[3]),
                        Boolean.parseBoolean(line[4]), facilities));
            }
            in = new Scanner(new File("src/bookings.csv"));
            while(in.hasNextLine())
            {
                String[] line = in.nextLine().split(",");
                Room room = getRoom(Integer.parseInt(line[0]));
                Guest guest = findGuest(line[1]);
                bookings.add(new Booking(room, guest, Integer.parseInt(line[2]), line[3], line[4]));
            }

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }
    }
}