package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuImpl {

  public MenuImpl() {
    loadMenu();
  }

  List<Menu> menus = new ArrayList();

  public void loadMenu() {
    menus.add(new Menu("asian", "food1", "food1", 5.0));
    menus.add(new Menu("asian", "food2", "food2", 5.0));
    menus.add(new Menu("asian", "food3", "food3", 5.0));
    menus.add(new Menu("asian", "food4", "food4", 5.0));
    menus.add(new Menu("asian", "food5", "food5", 5.0));
    menus.add(new Menu("western", "food6", "food6", 5.0));
    menus.add(new Menu("western", "food7", "food7", 5.0));
    menus.add(new Menu("western", "food8", "food8", 5.0));
    menus.add(new Menu("western", "food9", "food9", 5.0));
    menus.add(new Menu("western", "food10", "food10", 5.0));
  }

  public List<Menu> getMenuByType(String cuisine) {
    return menus.stream()
                .filter(menu -> cuisine.equals(menu.cuisine()))
                .collect(Collectors.toList());
  }
}
