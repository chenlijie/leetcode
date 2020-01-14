package amazon.oa;

import java.util.*;

public class LogSorter {
// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=351718&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B5%5D%3D5%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D5%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
    static class LetterLog implements Comparable<LetterLog> {
        String log;
        String identifier;
        String message;

        public LetterLog(String log, String identifier, String message) {
            this.log = log;
            this.identifier = identifier.toLowerCase();
            this.message = message.toLowerCase();
        }

        @Override
        public int compareTo(LetterLog o) {
            int res = message.compareTo(o.message);
            if (res == 0) {
                return identifier.compareTo(o.identifier);
            }
            return res;
        }
    }

    static List<String> sort(List<String> logs) {

        List<String> numLogs = new ArrayList<>();
        List<LetterLog> letterLogs = new ArrayList<>();

        for (String log : logs) {
            int idx = log.indexOf(' ');
            String part2 = log.substring(idx + 1);

            if (Character.isDigit(part2.charAt(0))) {
                numLogs.add(log);
            } else {
                letterLogs.add(new LetterLog(log, log.substring(0, idx), part2));
            }
        }

        Collections.sort(letterLogs);

        List<String> sortedLog = new ArrayList<>();
        for (LetterLog log : letterLogs)
            sortedLog.add(log.log);

        sortedLog.addAll(numLogs);

        System.out.println(sortedLog);
        return sortedLog;
    }


    public static void main(String[] args) {
        List<String> list = //Arrays.asList("a1 9 2 3 1", "g1 Act car", "zo4 4 7", "ab1 off KEY dog", "a8 act zoo");
        Arrays.asList("fhie 1df8 sfds", "fdsf 2def sees", "efe2 br9o fjsd", "asd1 awer jik9");
        sort(list);
    }
}
