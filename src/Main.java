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

    public static void main(String[] args) {

        while (true) {
            System.out.println("Введите команду:");
            System.out.println("ADD - добавить животное в список");
            System.out.println("LIST - показать список животных");
            System.out.println("EXIT - выйти из программы");

            String commandName = scanner.next().toUpperCase(Locale.ROOT).trim();
            boolean isExistCommand = false;
            for (CommandData commandData : CommandData.values()) {
                if (commandData.name().equals(commandName)) {
                    isExistCommand = true;
                    break;
                }
            }
            if (!isExistCommand) {
                System.out.println("Нет такой команды!");
                continue;
            }
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

                    String animalName = scanner.next().toUpperCase(Locale.ROOT).trim();
                    boolean isExistAnimal = false;
                    for (AnimalTypeData animalTypeData : AnimalTypeData.values()) {
                        if (animalTypeData.name().equals(animalName)) {
                            isExistAnimal = true;
                            break;
                        }
                    }
                    if (!isExistAnimal) {
                        System.out.println("Нет такого животного!");
                        continue;
                    }
                    AnimalTypeData type = AnimalTypeData.valueOf(animalName);
                    animalList.add(0, (fillAnimalData(type)));
                    animalList.get(0).say();
                    System.out.println();
                }
                default -> System.out.println("Неизвестная команда");
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
                       if (age <= 0 || age >= 100) {
                           System.out.println("Неверный возраст");
                           continue;
                       } else {
                           animal.setAge(age);
                       }
                       break;
                   } catch (NumberFormatException ex) {
                       System.out.println("Неверный возраст");
                   }
               }

        while (true) {
            System.out.println("Сколько весит животное?");
            try {
                int weight = Integer.parseInt(scanner.next());
                if (weight <= 0 || weight >= 100) {
                    System.out.println("Неверный вес");
                    continue;
                } else {
                    animal.setWeight(weight);
                }
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Неверный вес");
            }
        }
        return animal;
    }

}
