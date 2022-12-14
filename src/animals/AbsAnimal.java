package animals;

public class AbsAnimal {

    private String name;
    private int age;
    private int weight;
    private String color;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return age;
    }

    public String getColor() {
        return color;
    }
    public void setName(String name) {
        this.name = name;
    }


        public void setAge ( int age) {
                if (age >= 0 && age <= 100) {
                    this.age = age;
                    // break;
            } else {
                    System.out.println("Неверный возраст!");
            }
    }

    public void setWeight(int weight) {
            if (weight >= 0 && weight <= 100) {
                this.weight = weight;
            } else {
                System.out.println("Неверный вес!");
            }
        }

    public void setColor(String color) {
        this.color = color;
    }

    public void say() {
        System.out.println("Я говорю");
    }

    public void go() {
        System.out.println("Я иду");

    }
    public void eat() {
        System.out.println("Я ем");
    }

    public void drink() {
        System.out.println("Я пью");
    }

    private String getCase(int age) {
        if (age % 10 == 0 || age % 10 >= 5 || age >= 11 && age <= 19) {
            return "лет";
        } else if (age % 10 == 1) {
            return "год";
        } else {
            return "года";
        }
    }

    @Override
    public String toString() {
        return String.format("Привет! Меня зовут %s, мне %d %s, я вешу %d кг, мой цвет - %s.",
                name, age, getCase(age), weight, color);
    }

}
