package tweeter;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

public class AppacheLog {

    //https://github.com/chaithu123/Twitter-Coding-Challenge/blob/master/Twitter-Coding-Challenge-__-powered-by-HackerRank.pdf

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z");
    static DateTimeFormatter reportFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    static class LogMessage {
        String time;
        String uri;
        int code;

        public LogMessage(String time, String uri, int code) {
            this.time = time;
            this.uri = uri;
            this.code = code;
        }
    }

    static LogMessage extract(String log) {
        //get time
        int timeStart = log.indexOf('[') + 1;
        int timeEnd = log.indexOf(']');
        String time = formatTime(log.substring(timeStart, timeEnd));
        //get uri
        int uriStart = log.indexOf(' ', timeEnd + 2) + 1;
        int uriEnd = log.indexOf(' ', uriStart);
        String uri = log.substring(uriStart, uriEnd);
        int questionMark = uri.indexOf('?');
        if (-1 != questionMark) {
            uri = uri.substring(0, questionMark);
        }
        //get code
        int codeStart = log.indexOf(' ', uriEnd + 1) + 1;
        int codeEnd = log.indexOf(' ', codeStart);
        int code = Integer.parseInt(log.substring(codeStart, codeEnd));

        return new LogMessage(time, uri, code);
    }

    static String formatTime(String time) {
        return ZonedDateTime.parse(time, formatter)
                            .withZoneSameInstant(ZoneId.of("UTC"))
                            .format(reportFormatter);
    }

    static TreeMap<String, TreeMap<String, int[]>> report = new TreeMap<>();

    public static void main(String[] args) {
        try (Stream<String> stream = Files.lines(Paths.get("/Users/chenlijie/coding/leetcode/testFile/test.txt"))) {
            stream.forEach(line -> {
                LogMessage msg = extract(line);
                report.putIfAbsent(msg.time, new TreeMap<>());
                report.get(msg.time).putIfAbsent(msg.uri, new int[2]);
                int[] cnts = report.get(msg.time).get(msg.uri);
                if (msg.code < 500 || msg.code >= 600) {
                    cnts[0]++;
                }
                cnts[1]++;
            });
        } catch (IOException e) {

        }

        NumberFormat formatter = new DecimalFormat("#0.00");
        for (Map.Entry<String, TreeMap<String, int[]>> entry : report.entrySet()) {
            for (Map.Entry<String, int[]> e : entry.getValue().entrySet()) {
                int[] cnts = e.getValue();
                String rate = formatter.format((cnts[0]*100)/cnts[1]);
                System.out.println(entry.getKey() + " " + e.getKey() + " " + rate);
            }
        }
    }

}
