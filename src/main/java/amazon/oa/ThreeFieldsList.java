package amazon.oa;

import java.time.LocalDate;
import java.util.*;

public class ThreeFieldsList {

    //https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=473955&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D5%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26searchoption%5B3109%5D%5Bvalue%5D%3D2%26searchoption%5B3109%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
    //给了有三个feild的list，表示【某用户，在那一天，干了什么】，要找出把哪些用户连续两天干了同一件事

    public List<String> solution(List<List<String>> input) {
        Map<String, Map<String, Set<LocalDate>>> who = new HashMap<>();
        Set<String> ans = new HashSet<>();

        for (List<String> list : input) {
            if (!ans.contains(list.get(0))) {
                who.putIfAbsent(list.get(0), new HashMap<>());
                who.get(list.get(0)).putIfAbsent(list.get(1), new HashSet<>());
                Set<LocalDate> when = who.get(list.get(0)).get(list.get(1));

                LocalDate date = getLocalDate(list.get(2));
                if (when.contains(date.plusDays(1L)) || when.contains(date.plusDays(-1L))) {
                    ans.add(list.get(0));
                } else {
                    when.add(date);
                }
            }
        }

        System.out.println(ans);

        return new ArrayList<>(ans);
    }

    private LocalDate getLocalDate(String s) {
        String[] str = s.split("-");
        return LocalDate.of(Integer.valueOf(str[0]), Integer.valueOf(str[1]), Integer.valueOf(str[2]));
    }

    public static void main(String[] args) {
        List<List<String>> lists = new ArrayList<>();

        List<String> list = new ArrayList<>();
        list.add("A"); list.add("eat"); list.add("2018-01-02");
        lists.add(list);

        list = new ArrayList<>();
        list.add("B"); list.add("eat"); list.add("2018-01-02");
        lists.add(list);

        list = new ArrayList<>();
        list.add("A"); list.add("eat"); list.add("2018-01-03");
        lists.add(list);

        list = new ArrayList<>();
        list.add("B"); list.add("eat"); list.add("2018-01-04");
        lists.add(list);

        ThreeFieldsList t = new ThreeFieldsList();
        t.solution(lists);
    }
}
