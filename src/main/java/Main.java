import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  private static List<Product> productList = new ArrayList<>();
   private static List<Membership> membershipList = new ArrayList<>();
  private static Scanner scanner;

  public static void main(String[] args) {
    scanner = new Scanner(System.in);
    do {
      int choice = displayMenu();
      if (choice == 1) {
        addNewProduct();
      } else if (choice == 2) {
        displayProducts();
        } else if (choice == 3) {
          addNewMembership();
        } else if (choice == 4) {
          displayMemberships();
        } else if (choice == 5) {
          break;
      }
    } while (true);
  }

  private static int displayMenu() {

    int choice = 0;

    while (true) {
      System.out.println("Menu:");
      System.out.println("1. Add a product");
      System.out.println("2. List all products");
      System.out.println("3. Add a membership");
      System.out.println("4. List all memberships");
      System.out.println("5. Exit");
      System.out.print("Enter your choice: ");
      choice = scanner.nextInt();
      // consume the newline character
      scanner.nextLine(); // Consume the newline character after scanner.nextInt()
      if (choice >= 1 && choice <= 3) {
        break;
      }
    }

    return choice;

  }

  private static void addNewMembership() {
    System.out.println("Enter membership type: ");
    String type = scanner.nextLine();
    System.out.println("Enter membership cost: ");
    double cost = scanner.nextDouble();
    scanner.nextLine();

    Membership newMembership = new Membership(type, cost);
    membershipList.add(newMembership);

    System.out.println("Membership added successfully!");
  }

  private static void displayMemberships() {
    System.out.println("Memberships:");
    for (Membership membership : membershipList) {
      System.out.println("Type: " + membership.getType());
      System.out.println("Cost: $" + membership.getCost());
      System.out.println("Sales Tax: $" + membership.calculateSalesTax());
      System.out.println("----------------------");
    }
  }
  // private static void addNewProduct() {
  //   System.out.println("Enter the name of the product: ");
  //   String name = scanner.nextLine();
  //   System.out.println("Enter the price of the product: ");
  //   double price = scanner.nextDouble();
  //   scanner.nextLine(); // consume the newline character remaining in the buffer
  //   System.out.println("Enter the SKU of the product: ");
  //   String sku = scanner.nextLine();

  //   Product product = new Product(name, price, sku);

  //   productList.add(product);
  //   System.out.println("Product added successfully!");
  // }

  private static void addNewProduct() {
      System.out.println("Enter the name of the product: ");
      String name = scanner.nextLine();
      System.out.println("Enter the price of the product: ");
      double price = scanner.nextDouble();
      scanner.nextLine(); // consume the newline character remaining in the buffer
      System.out.println("Enter the SKU of the product: ");
      String sku = scanner.nextLine();

      while(true) {
        System.out.println("Choose the type of product: ");
        System.out.println("1. Physical Product");
        System.out.println("2. Digital Product");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Enter the size of the physical product: ");
            String size = scanner.nextLine();
            System.out.println("Enter the weight of the physical product: ");
            double weight = scanner.nextDouble();
            scanner.nextLine(); // consume the newline character remaining in the buffer
            System.out.println("Enter the color of the physical product: ");
            String color = scanner.nextLine();

            PhysicalProduct physicalProduct = new PhysicalProduct(name, price, sku, size, weight, color);
            productList.add(physicalProduct);
            System.out.println("Physical product added successfully!");
            break;
        } else if (choice == 2) {
            System.out.println("Enter the format of the digital product: ");
            String format = scanner.nextLine();
            System.out.println("Enter the download link of the digital product: ");
            String downloadLink = scanner.nextLine();

            DigitalProduct digitalProduct = new DigitalProduct(name, price, sku, format, downloadLink);
            productList.add(digitalProduct);
            System.out.println("Digital product added successfully!");
            break;
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
      }
  }
  private static void displayProducts() {
    System.out.println("List of Products:");
    for (Product product : productList) {
      System.out.println("Name: " + product.getName());
      System.out.println("Price: $" + product.getPrice());
      System.out.println("SKU: " + product.getSku());
      System.out.println("-------------------");
    }
  }
  // public static void displayProducts(ArrayList<Product> productList) {
  //   for (Product p : productList) {
  //     p.displayDetails();
  //     System.out.println();
  //   }
  // }

  public static void displayProducts(ArrayList<Product> productList) {
    for (int i = 0; i < productList.size(); i++) {
      Product p = productList.get(i);
      // print out the index
      System.out.println("Product #" + i);
      p.displayDetails();
      System.out.println();
    }

    Scanner scanner = new Scanner(System.in);
    System.out.println("Choose an option:");
    System.out.println("1. Exit");
    System.out.println("2. Edit a product");
    System.out.println("3. Delete a product");
    int option = scanner.nextInt();

    if (option == 2) {
      System.out.print("Enter the index of the product you want to edit: ");
      int index = scanner.nextInt();
      if (index >= 0 && index < productList.size()) {
        Product productToEdit = productList.get(index);
        editProduct(productToEdit);
      } else {
        System.out.println("Invalid index.");
      }
    } else if (option == 3) {
      System.out.print("Enter the index of the product you want to delete: ");
      int index = scanner.nextInt();
      if (index >= 0 && index < productList.size()) {
        productList.remove(index);
        System.out.println("Product deleted.");
      } else {
        System.out.println("Invalid index.");
      }
    }
  }


  public static void editProduct(Product p) {
    p.editDetails();
  }

  private static void displayTaxableItems() {
    ArrayList<ITaxable> taxableItems = new ArrayList<>();

    // Add all Product instances to the taxableItems list
    // for (Product product : productList) {
    //   taxableItems.add(product);
    // }

    // Add all Membership instances to the taxableItems list
    for (Membership membership : membershipList) {
      taxableItems.add(membership);
    }

    // Display details of each taxable item
    System.out.println("Taxable Items:");
    for (ITaxable item : taxableItems) {   
      System.out.println("Sales Tax: $" + item.calculateSalesTax());
      System.out.println("----------------------");
    }
  }

  
}
