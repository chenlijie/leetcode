package tweeter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogSearcher {

    static Collection<String> search(Collection<String> logLines, LocalTime start, LocalTime end) {
        List<String> ans = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        boolean isWithInRange = false;
        for (String line : logLines) {
            if (line.length() <= 20) {
                if (isWithInRange) {
                    ans.add(line);
                }
            } else {
                String timeStr = line.substring(0, 20);
                try {
                    LocalTime time = LocalTime.parse(timeStr, formatter);

                    if (time.isAfter(start) && time.isBefore(end) || time.equals(start) || time.equals(end)) {
                        isWithInRange = true;
                        ans.add(line);
                    } else {
                        isWithInRange = false;
                    }
                } catch (DateTimeParseException e) {
                    if (isWithInRange) {
                        ans.add(line);
                    }
                }
            }
        }

        for (String s : ans) {
            System.out.println(s);
        }
        return ans;
    }

    static Collection<String> search2(Collection<String> logLines, LocalTime start, LocalTime end) {
        List<String> ans = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        boolean isWithInRange = false;
        for (String line : logLines) {

            if (-1 == line.indexOf('\t')) {
                if (isWithInRange) {
                    ans.add(line);
                }
            } else {
                LocalTime time = LocalTime.parse(line.substring(0, 20), formatter);

                if (time.isAfter(start) && time.isBefore(end) || time.equals(start) || time.equals(end)) {
                    isWithInRange = true;
                    ans.add(line);
                } else {
                    isWithInRange = false;
                }
            }
        }

        for (String s : ans) {
            System.out.println(s);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");//.ISO_INSTANT;
//        System.out.println(LocalTime.parse("2011-12-03T10:15:30Z", formatter));

        List<String> list = Arrays.asList(
                "2016-02-12T03:21:54Z\tProgram x",
                "2016-03-12T03:21:55Z\tthrow exception",
                "java.lang.NullPointExcption",
                "at program x at 15",
                "at program x at 50",
                "2016-02-12T03:21:56Z\tProgram x",
                "2016-04-12T10:21:54Z\tProgram y",
                "2016-04-12T10:21:53Z\tProgram yy",
                "2016-09-12T18:21:56Z\tProgram z",
                "2016-09-12T18:21:57Z\tProgram zz",
                "2016-03-12T12:55:55Z\tthrow exception",
                "java.lang.OutofBoundPointExcption",
                "at program x at 151",
                "at program x at 501"
        );

//        List<String> list = new ArrayList<>();
//        try (Stream<String> stream = Files.lines(Paths.get("./testFile/log.txt"))) {
//            list = stream.collect(Collectors.toList());
//        }

        LocalTime start = LocalTime.of(10, 21, 54);
        LocalTime end = LocalTime.of(18, 21, 56);
        search2(list, start, end);
    }
}
