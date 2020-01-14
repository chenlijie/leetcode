package amazon.onsite;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class JsonParse {

    public Map<String, Object> parseJson(String json) {
//        int idx = findStart(json);
        return null;
    }



    public static void main(String[] args) {
        String fileName = "/Users/chenlijie/coding/leetcode/testFile/file.txt";

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            System.out.println(stream.findFirst().get());
//            stream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

        String s = "\"\ba\n\n\n\ta";
        System.out.println(s);
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            System.out.println(scanner.next());
//        }
    }
}
