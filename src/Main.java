import java.util.*;

public class Main {

    private static final List<String> OPERATIONS = Arrays.asList(
            "1. Add item",
            "2. Show the list",
            "3. Delete item",
            "4. Find the purchase"
    );

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        //1. В цикле предлагать ему на выбор одну из операций: добавить, показать, удалить.
        while (true) {
            System.out.println("Select an operation or 'end' to finish :");
            for (String operation : OPERATIONS) {
                System.out.println(operation);
            }
            //2. Пользователь вводит номер операции
            String inputStr = scanner.nextLine();
            if (inputStr.equals("end")) {
                break;
            }
            int input;
            try {
                input = Integer.parseInt(inputStr) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Data were entered incorrectly. Type in number.");
                continue;
            }
            if (input < 0 || input > OPERATIONS.size()) {
                System.out.println("There is no such number to select.");
                continue;
            }
            //3. Программа запрашивает дополнительные данные для совершения операции, эти данные вводятся одной строкой
            //4. Программа выполняет операцию, выводит информацию на экран и переходит обратно к пункту вывода меню
            String item;
            switch (input) {
                case 0:
                    System.out.println("What purchase do you want to add?");
                    item = scanner.nextLine();
                    if (list.contains(item)) {
                        System.out.println("You already have this item in the list.");
                        continue;
                    }
                    list.add(item);
                    System.out.println("In total, there is(are) " + list.size() + " purchase(s)");
                    break;
                case 1:
                    System.out.println("Shopping list: ");
                    print(list);
                    break;
                case 2:
                    System.out.println("Shopping list: ");
                    print(list);
                    System.out.println("What item do you want to delete? Type in the number or purchase name");
                    item = scanner.nextLine();
                    try {
                        int itemNum = Integer.parseInt(item) - 1;
                        if (itemNum < 0 || itemNum >= list.size()) {
                            System.out.println("There is no item with this number");
                            continue;
                        }
                        String removedItem = list.remove(itemNum);
                        System.out.println(removedItem + " is deleted, the shopping list:");
                    } catch (NumberFormatException e) {
                        boolean isRemoved = list.remove(item);
                        if (!isRemoved) {
                            System.out.println("There is no item with this name: " + item);
                            continue;
                        } else {
                            System.out.println(item + " is deleted, the shopping list:");
                        }
                    }
                    print(list);
                    break;
                case 3:
                    System.out.println("Type in the text for searching: ");
                    String query = scanner.nextLine();
                    for (int i = 0; i < list.size(); i++) {
                        String itemLower = list.get(i).toLowerCase();
                        String queryLower = query.toLowerCase();
                        if (itemLower.contains(queryLower)) {
                            System.out.println((i + 1) + " " + list.get(i));
                        }
                    }
                    break;
            }
        }
    }


    private static void print(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + " " + list.get(i));
        }
    }
}