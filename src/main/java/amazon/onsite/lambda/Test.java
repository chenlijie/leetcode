package amazon.onsite.lambda;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Test {

    public static void printPersons(List<Person> roster, CheckPerson tester) {

        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void printPersons_2(List<Person> roster, Predicate<Person> tester) {

        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }


    public static void processPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    public static List<String> processPersons_2(List<Person> roster, Predicate<Person> tester, Consumer<Person> block, List<String> ans) {

        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        List<Person> roster = Arrays.asList(new Person("ca", Person.Sex.MALE, 20),
                new Person("abc", Person.Sex.FEMALE, 30));

        processPersons(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.printPerson()
        );

        boolean a = Files.isDirectory(Paths.get("/Users/chenlijie/coding/leetcode/build.gradle"));
        System.out.println(a);

        a = Files.isDirectory(Paths.get("/Users/chenlijie/coding/leetcode/src"));
        System.out.println(a);

        Files.list(Paths.get("/Users/chenlijie/coding/leetcode/src")).forEach(l -> System.out.println(l.getFileName()));
    }
}
