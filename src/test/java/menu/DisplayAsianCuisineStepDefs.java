package menu;

import java.util.List;
import java.util.stream.Collectors;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.common.collect.Lists;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisplayAsianCuisineStepDefs {

  String cuisineType;
  String userCuisineTypeSelection;
  List<Menu> menus = Lists.newArrayList(
      new Menu("asian", "food1", "food1", 5.0),
      new Menu("asian", "food2", "food2", 5.0),
      new Menu("asian", "food3", "food3", 5.0),
      new Menu("asian", "food4", "food4", 5.0),
      new Menu("asian", "food5", "food5", 5.0)
  );

  @Given("users wants to view {cuisineType} cuisine menu")
  public void users_wants_to_view_cuisine_menu(String cuisineType) {
    this.cuisineType = cuisineType;
  }

  @When("users selected {selectedCuisine} cuisine menu")
  public void users_selected_cuisine_menu(String selectedCuisine) {
    this.userCuisineTypeSelection = selectedCuisine;
  }

  @Then("display asian cuisine {foodName}")
  public void display_asian_cuisine_list(String foodName) {
    MenuImpl menuImpl = new MenuImpl();

    List<Menu> expectMenus = menus.stream()
                                  .filter(menu -> cuisineType.equals(menu.cuisine()))
                                  .collect(Collectors.toList());

    assertEquals(expectMenus, menuImpl.getMenuByType(userCuisineTypeSelection));
    assertEquals(foodName, menuImpl.getMenuByType(userCuisineTypeSelection).get(0).name());
  }
}