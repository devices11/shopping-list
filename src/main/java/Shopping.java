import java.util.InputMismatchException;
import java.util.Scanner;

public class Shopping {
    static int shoppingListLength = 8;
    static String[] shoppingList = new String[shoppingListLength];

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Вас приветствует список покупок!");

        while (true) {
            switch (menu()) {
                case 1:
                    addItem();
                    break;
                case 2:
                    showList(shoppingList);
                    break;
                case 3:
                    allRemove();
                    break;
                case 4:
                    exit();
                    break;
                default:
                    incorrectInput();
            }
        }

    }

    //Главное меню
    private static int menu() {
        System.out.println("\nВыберите одну из команд:");
        System.out.println("    1. Добавить товар в список");
        System.out.println("    2. Показать список");
        System.out.println("    3. Очистить список");
        System.out.println("    4. Завершить работу");

        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner = new Scanner(System.in); //Пересоздаем scanner для очистки значений в кеше
            return 0;
        }
    }

    //1. Добавить товар в список
    private static void addItem() {

        System.out.println("Введите наименование товара:");

        scanner = new Scanner(System.in); //Пересоздаем scanner для очистки значений в кеше
        String productName = scanner.nextLine();

        for (int i = 0; i < shoppingList.length; i++) {
            if (shoppingList[i] == null) {
                shoppingList[i] = productName;
                System.out.println("Товар " + productName + " добавлен в список под номером " + (i + 1));
                break;
            } else if (shoppingList[i].equals(productName)) {
                System.out.println("Товар " + productName + " имеется в списке под номером " + (i + 1));
                break;
            } else if (shoppingList[shoppingList.length - 1] != null){
                newShoppingList(shoppingList);
            }
        }
    }

    //2. Показать список
    private static void showList(String[] shoppingList) {
        for (int i = 0; i < shoppingList.length; i++){

            if (shoppingList[i] != null){
                if (i == 0){
                    System.out.println("Список товаров:");
                }

                System.out.println("    " + (i + 1) + ". " + shoppingList[i]);
            } else if ((i > 0) && shoppingList[i] == null){
                break;
            } else {
                System.out.println("Список товаров пуст!");
            }

        }
    }

    //3. Очистить список
    private static void allRemove() {
        shoppingList = new String[shoppingListLength];
        System.out.println("Список товаров очищен");
    }

    //4. Завершить работу
    private static void exit() {
        System.out.println("До скорых встреч!");
        System.exit(0); //Завершение программы с успешным кодом 0
    }

    //Некорректный ввод в меню
    private static void incorrectInput() {
        System.out.println("Неизвестная команда!\n");
    }

    //Увеличить массив списка покупок
    private static void newShoppingList(String[] fullShoppingList) {
        shoppingList = new String[fullShoppingList.length + 1]; //Пересоздаем массив с большим размером, затерев значения
        System.arraycopy(fullShoppingList, 0, shoppingList, 0, fullShoppingList.length); //Копируем массив полученный на вход в увеличенный массив
    }
}
