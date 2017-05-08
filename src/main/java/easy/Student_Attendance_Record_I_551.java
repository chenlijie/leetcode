package easy;

/**
 * Created by chenlijie on 5/3/17.
 */
public class Student_Attendance_Record_I_551 {

    public static boolean checkRecord(String s) {
        if (s == null || s.length() == 0)
            return false;

        int a = 0;
        int l = 0;

        for (char c : s.toCharArray()) {
            switch (c) {
                case 'A' :
                    a++;
                    l = 0;
                    break;
                case 'L' :
                    l++;
                    break;
                default:
                    l = 0;
                    break;
            }
            if (a == 2 || l == 3)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(!checkRecord(null));
        System.out.println(!checkRecord("LLPPLPPLPLPPLPLPLPPAPPPPPLPALL"));
//        System.out.println(checkRecord("ALP"));
//        System.out.println(checkRecord("ALPPPP"));
//        System.out.println(!checkRecord("ALAPA"));
//        System.out.println(checkRecord("PAPLLPLLPLL"));
//        System.out.println(!checkRecord("ALAPPAPAPP"));
    }
}
