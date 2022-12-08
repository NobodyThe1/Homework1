import animals.AbsAnimal;
import animals.pets.Cat;
import animals.pets.Dog;
import animals.birds.Duck;
import data.AnimalTypeData;
import data.CommandData;
import factories.AnimalFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static List<AbsAnimal> animalList = new ArrayList<>();
    //private static AnimalTypeData[] animalArray = AnimalTypeData.values();
    //private static CommandData dataArray[] = CommandData.values();


    public static void main(String[] args) {

        while (true) {
            System.out.println("Введите команду:");
            System.out.println("ADD - добавить животное в список");
            System.out.println("LIST - показать список животных");
            System.out.println("EXIT - выйти из программы");

            String commandName = scanner.next().toUpperCase(Locale.ROOT).trim();

            try {
                CommandData commandData = CommandData.valueOf(commandName);

                switch (commandData) {
                    case LIST -> {
                        for (int i = 0; i < animalList.size(); i++) {
                            System.out.println(animalList.get(i));
                        }
                        System.out.println();
                    }
                    case EXIT -> System.exit(0);
                    case ADD -> {
                        System.out.println("Выберите животное");

                        try {
                            String animalName = scanner.next().toUpperCase(Locale.ROOT).trim();
                            AnimalTypeData type = AnimalTypeData.valueOf(animalName);
                            animalList.add(0, (fillAnimalData(type)));
                            animalList.get(0).say();
                            System.out.println();
                        } catch (IllegalArgumentException e) {
                            System.out.println("Нет такого животного!");
                            continue;
                        }
                    }
                    default -> System.out.println("Неизвестная команда");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Нет такой команды!");
                continue;
            }
        }
    }


    private static AbsAnimal fillAnimalData(AnimalTypeData type) {

        AnimalFactory factory = new AnimalFactory();
        AbsAnimal animal = factory.create(type);

        System.out.println("Как зовут животное?");
        animal.setName(scanner.next());

        System.out.println("Какой цвет у животного?");
        animal.setColor(scanner.next());

        while (true) {
            System.out.println("Сколько лет животному?");
                   try {
                       int age = Integer.parseInt(scanner.next());
                       animal.setAge(age);
                       break;
                   } catch (NumberFormatException ex) {
                       System.out.println("Неверный возраст");
                   }
               }

        while (true) {
            System.out.println("Сколько весит животное?");
            try {
                int weight = Integer.parseInt(scanner.next());
                animal.setWeight(weight);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Неверный вес");
            }
        }
        return animal;
    }

    private static boolean isExistAnimal(Enum<AnimalTypeData> type, String scan) {
        AnimalTypeData[] animalArray = AnimalTypeData.values();
        for (AnimalTypeData s : animalArray) {
            if (scan.equals(s.toString())) {
                return true;
            } else {
                System.out.println("Нет такого животного!");
                continue;
            }
        }
        return false;
    }

    private static boolean isExistCommand(String scan) {
        CommandData[] commandArray = CommandData.values();
        for (CommandData s : commandArray) {
            if (scan.equals(s.toString().toUpperCase().trim())) {
                continue;
            } else {
                System.out.println("Нет такой команды!");
                break;
            }
        }
        return false;
    }
}
