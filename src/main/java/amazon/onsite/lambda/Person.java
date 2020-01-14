package amazon.onsite.lambda;

public class Person {
    public enum Sex {
        MALE, FEMALE
    }

    String name;
    Sex gender;
    String emailAddress;
    int age;

    public Person(String name, Sex gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void printPerson() {
        System.out.println(name);
    }

    public Sex getGender() {
        return gender;
    }
}
