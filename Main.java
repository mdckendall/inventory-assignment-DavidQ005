import java.util.ArrayList;
import java.util.Scanner;

class Inventory {
  String name;
  String serialNumber;
  int value;
  
  public Inventory(String name, String serialNumber, int value) {
    this.name = name;
    this.serialNumber = serialNumber;
    this.value = value;
  }
  
  @Override
  public String toString() {
    return name + "," + serialNumber + "," + value;
  }
}

class Main {
	public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Inventory> inventory = new ArrayList<Inventory>();
    int userChoice;
    String name;
    String serialNumber;
    int value;
    boolean quit = false;
    boolean found = false;

    do {
      System.out.println("Press 1 to add an item.\nPress 2 to delete an item.\nPress 3 to update an item.\nPress 4 to show all the item.\nPress 5 to quit the program.");

      userChoice = scanner.nextInt();
      scanner.nextLine();
  
      if (userChoice == 1) {
        System.out.println("Enter the name:");
        name = scanner.nextLine();
        System.out.println("Enter the serial number:");
        serialNumber = scanner.nextLine();
        System.out.println("Enter the value in dollars (whole number):");
        value = scanner.nextInt();
  
        Inventory i = new Inventory(name, serialNumber, value);
        inventory.add(i);
      }
      else if (userChoice == 2) {
        System.out.println("Enter the serial number of the item to delete:");
        serialNumber = scanner.nextLine();

        found = false;
        for (int i = 0; i < inventory.size(); i++) {
          if (inventory.get(i).serialNumber.equals(serialNumber)) {
            inventory.remove(inventory.get(i));
            found = true;
            break;
          }
        }

        if (!found) {
          System.out.println("Serial number does not exist");
        }
      }
      else if (userChoice == 3) {
        System.out.println("Enter the serial number of the item to change:");
        serialNumber = scanner.nextLine();
        System.out.println("Enter the new name:");
        name = scanner.nextLine();
        System.out.println("Enter the new value in dollars (whole number):");
        value = scanner.nextInt();

        found = false;
        for (int i = 0; i < inventory.size(); i++) {
          if (inventory.get(i).serialNumber.equals(serialNumber)) {
            Inventory change = new Inventory(name, serialNumber, value);
            inventory.set(i, change);
            found = true;
            break;
          }
        }

        if (!found) {
          System.out.println("Serial number does not exist");
        }
      }
      else if (userChoice == 4) {
        for (int i = 0; i < inventory.size(); i++) {
          System.out.println(inventory.get(i));
        }
      }
      else if (userChoice == 5) {
        quit = true;
      }
    } while (quit == false);
	}
}