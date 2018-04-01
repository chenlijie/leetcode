package tweeter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TimeSeriesDataAggreation {
//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=222774&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D20%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

    static String start;
    static String end;
    static TreeMap<String, TreeMap<String, Long>> msgHolder = new TreeMap<>(Comparator.reverseOrder());

    static void processLog(String msg) {
        String[] info = msg.split(",");
        if (info.length != 3) {
            return;
        }

        //Skip if date is out of range
        String date = info[0].substring(0, info[0].lastIndexOf('-')).trim();
        if (date.compareTo(start) < 0 || date.compareTo(end) > 0) {
            return;
        }

        //Skip if category is empty
        String category = info[1].trim();
        if (category.isEmpty()) {
            return;
        }

        //Skip if it's not a num or not positive
        long count = 0L;
        try {
            count = Long.parseLong(info[2].trim());
            if (count <= 0) {
                return;
            }
        } catch (NumberFormatException e) {
            return;
        }

        msgHolder.putIfAbsent(date, new TreeMap<>());
        msgHolder.get(date).put(category, msgHolder.get(date).getOrDefault(category, 0L) + count);
    }

    static void printLog() {
        for (Map.Entry<String, TreeMap<String, Long>> entry : msgHolder.entrySet()) {
            StringBuilder builder = new StringBuilder();
            builder.append(entry.getKey());

            for (Map.Entry<String, Long> e : entry.getValue().entrySet()) {
                builder.append(", ").append(e.getKey()).append(", ").append(e.getValue());
            }
            System.out.println(builder.toString());
        }
    }

    static void initializeDateRange(String range) {
        String[] dates = range.split(",");
        start = dates[0].trim();
        end = dates[1].trim();
    }

    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(System.in);
        initializeDateRange(s.nextLine());
        s.nextLine();
        while (s.hasNext()) {
            String msg = s.nextLine();
            if ("exit".equals(msg)) break;
            processLog(msg);
        }
        printLog();
        s.close();

        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        boolean isReady = false;
        while ((line = reader.readLine()) != null) {
            //initialize date range
            if (!isReady) {
                initializeDateRange(line);
                isReady = true;
            } else {
                if ("exit".equals(line)) break;
                //process log
                processLog(line);
            }
        }

        //output result
        printLog();*/
    }
}

