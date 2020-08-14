package menu;

public class Menu {
  public Menu(String cuisine, String name, String description, Double price) {
    this.cuisine = cuisine;
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public String description() {
    return description;
  }

  public void description(String description) {
    this.description = description;
  }

  public String name() {
    return name;
  }

  public void name(String name) {
    this.name = name;
  }

  public Double price() {
    return price;
  }

  public void price(Double price) {
    this.price = price;
  }

  private String description;
  private String name;
  private Double price;
  private String cuisine;

  public String cuisine() {
    return cuisine;
  }

  public void cuisine(String cuisine) {
    this.cuisine = cuisine;
  }
}
