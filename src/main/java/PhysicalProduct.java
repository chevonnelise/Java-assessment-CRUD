import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhysicalProduct extends Product {
  private String size;
  private double weight;
  private String color;

  public PhysicalProduct() {
    // calls the parent constructor
    super();
    this.size = "N/A";
    this.weight = 0.0;
    this.color = "N/A";
  }

  public PhysicalProduct(String name, double price, String sku, String size, double weight, String color) {
    // calls the parent constructor
    super(name, price, sku);
    this.size = size;
    this.weight = weight;
    this.color = color;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void displayNetPrice() {
    double tax = calculateSalesTax();
    double netPrice = getPrice() + tax;
    System.out.println("Net Price: $" + netPrice);
  }

  @Override
  public void displayDetails() {
    super.displayDetails();
    System.out.println("Physical Product Size: " + getSize());
    System.out.println("Physical Product Weight: " + getWeight() + " lbs");
    System.out.println("Physical Product Color: " + getColor());
  }

  @Override
  public void editDetails() {
    super.editDetails();

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the new size: ");
    String newSize = scanner.nextLine();
    this.setSize(newSize);

    System.out.print("Enter the new weight: ");
    double newWeight = scanner.nextDouble();
    this.setWeight(newWeight);

    System.out.print("Enter the new color: ");
    String newColor = scanner.nextLine();
    this.setColor(newColor);
  }

  @Override
  public double calculateSalesTax() {
    double taxPercentage = 0.1; // 10% tax rate
    return getPrice() * taxPercentage;
  }
}