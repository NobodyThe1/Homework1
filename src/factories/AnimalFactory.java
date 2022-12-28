package factories;

import animals.AbsAnimal;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;
import data.AnimalTypeData;

import java.util.Locale;

public class AnimalFactory {

    public AbsAnimal create(AnimalTypeData type) {
        switch(type) {
            case CAT -> {
                return new Cat();
            }
            case DOG -> {
                return new Dog();
            }
            case DUCK -> {
                return new Duck();
            }
            default -> {
                return null;
            }
        }

    }
}
