// --== CS400 File Header Information ==--
// Name: Annie Won
// Email: jwon23@wisc.edu
// Notes to Grader: None

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class implements Front-end application for RestaurantReservation hashtable Map.
 * 
 */
public class RestaurantReservationApplication {
  private static RestaurantReservation<String, Person> r =
      new RestaurantReservation<String, Person>(6);
  private static Scanner in = new Scanner(System.in);

  /**
   * Print the confirm-reservation-menu
   * 
   */
  private static void printConfirmReservationMenu() {
    System.out.println("CONFIRM RESERVATION MENU\n=================");
    System.out.println("1) Get the full list");
    System.out.println("2) Search for name");
    System.out.println("3) Quit");
    System.out.println("0) Return to Menu");
    System.out.print("> ");
  }

  /**
   * Print the top-reservation-menu
   * 
   */
  private static void printTopMenu() {
    System.out.println("TRACKING APP MENU\n=================");
    System.out.println("1) Admin");
    System.out.println("2) Customer");
    System.out.println("3) Quit");
    System.out.print("> ");
  }

  /**
   * Print the menu for administrator
   * 
   */
  private static void printAdminMenu() {
    System.out.println("ADMIN FUNCTIONS\n===============");
    System.out.println("1) Make a reservation");
    System.out.println("2) Confirm reservation");
    System.out.println("3) Cancel reservation");
    System.out.println("4) Quit");
    System.out.println("0) Return to Menu");
    System.out.print("> ");
  }

  /**
   * Print the menu for customer
   * 
   */
  private static void printCustomerMenu() {
    System.out.println("CUSTOMER FUNCTIONS\n===============");
    System.out.println("1) Make a reservation");
    System.out.println("2) Confirm reservation");
    System.out.println("3) Cancel reservation");
    System.out.println("4) Quit");
    System.out.println("0) Return to Menu");
    System.out.print("> ");
  }

  /**
   * Make a reservation in the restaurant. It asks for name, if chair is needed, the number of the
   * guests, and the time.
   * 
   */
  private static void makeReservation() {
    String blank = in.nextLine();
    System.out.println("Enter the name: ");
    String name = in.next();
    System.out.println("What time do you want to make a reservation?");
    String time = in.next();
    System.out.println("Do you need dining chair for kids? ");
    boolean chairNeeded = false;
    String chairNeed = in.next();
    if (chairNeed.equalsIgnoreCase("yes") || chairNeed.equalsIgnoreCase("y")) {
      chairNeeded = true;
    } else {
      chairNeeded = false;
    }
    System.out.println("How many are the guests?");
    int peopleNumber = in.nextInt();
    Person p1 = new Person(name, chairNeeded, peopleNumber, time);
    r.put(name, p1);
    System.out.println("You're all set!");
  }

  /**
   * Cancel the reservation
   * 
   */
  private static void cancelReservation() {
    String n = in.nextLine();
    System.out.println("Enter the name: ");
    String name = in.next();
    if (r.containsKey(name)) {
      r.remove(name);
      System.out.println("Your reservation is canceled.");
    } else {
      System.out.println("We can't find your reservation.");
    }

  }

  /**
   * Get the full list of the people who made a reservation
   * 
   */
  private static void getFullList(Scanner in) {
    System.out.println(r.toString());
  }

  /**
   * Confirm reservation by checking if the person name exists in the hashtable
   * 
   * @param in get the user input that wants to be confirmed
   */
  private static void confirmReservation(Scanner in) {
    System.out.println("Enter the name: ");
    String name = in.next();
    if (r.containsKey(name)) {
      System.out.println("You are in the list.");
      System.out.println("Do you want to view details? (Yes: 1, No: 2)");
      int sign = in.nextInt();
      if (sign == 1) {
        System.out.println("Name: " + r.get(name).getName());
        System.out.println("ChairNeeded: " + r.get(name).getChairNeeded());
        System.out.println("PeopleNumber: " + r.get(name).getPeopleNumber());
        System.out.println("Time: " + r.get(name).getTime());
      }
    } else {
      System.out.println("We don't have your information.");
    }
  }

  /**
   * Write files in the dataset
   * 
   */
  private static void writeFile() {
    try {
      String str = "";
      FileWriter fw = new FileWriter(new File("Dataset.txt"));
      fw.write(r.toString());
      fw.close();
    } catch (IOException e) {
      System.out.println("File doens't exist.");
    }

  }

  /**
   * Administrator's application to implement administrator-menu
   * 
   */
  private static void admin() {
    printAdminMenu();
    int userIn = in.nextInt();
    switch (userIn) {
      case 0:
        break;
      case 1:
        makeReservation();
        break;
      case 2:
        printConfirmReservationMenu();
        userIn = in.nextInt();
        switch (userIn) {
          case 0:
            break;
          case 1:
            getFullList(in);
            break;
          case 2:
            confirmReservation(in);

            break;
          case 3:
            quit();
            break;
        }
        break;
      case 3:
        cancelReservation();
        break;
      case 4:
        quit();
        break;
    }

  }

  /**
   * Administrator's application to implement customer-menu
   * 
   */
  private static void customer() {
    printCustomerMenu();
    int userIn = in.nextInt();
    switch (userIn) {
      case 1:
        makeReservation();
        break;
      case 2:
        printConfirmReservationMenu();
        userIn = in.nextInt();
        switch (userIn) {
          case 0:
            break;
          case 1:
            getFullList(in);
            break;
          case 2:
            confirmReservation(in);

            break;
          case 3:
            quit();
            break;
        }
        break;
      case 3:
        cancelReservation();
        break;
      case 4:
        quit();
        break;
    }
  }

  /**
   * Quit the program
   * 
   */
  private static void quit() {
    System.out.println("Good-bye!");
    writeFile();
    System.exit(0);
  }

  /**
   * Driver method for Restaurant Reservation Application.
   * 
   */
  public static void main(String[] args) throws IOException {
    try {
      String[] arrs = null;
      int num = 0;
      Scanner sc = new Scanner(new File("Dataset.txt"));
      String s = "";
      while (sc.hasNextLine()) {
        s = sc.nextLine();
        arrs = s.split(" ");
        Person p =
            new Person(arrs[1], Boolean.parseBoolean(arrs[2]), Integer.parseInt(arrs[3]), arrs[4]);
        r.put(arrs[1], p);
        System.out.println(
            p.getName() + " " + p.getChairNeeded() + " " + p.getPeopleNumber() + " " + p.getTime());
        num++;
      }

    } catch (FileNotFoundException a) {
      System.out.println("File not found");
    }

    int userIn;

    while (true) {
      // TOP MENU
      try {
        printTopMenu();
        userIn = in.nextInt();
        switch (userIn) {
          case 0:
            break;
          case 1:
            admin();
            break;
          case 2:
            customer();
            break;
          case 3:
            quit();
            break;
        }
      } catch (InputMismatchException e) {
        in.nextLine();
        System.out.println("Invalid input");


      }

    }

  }
}


