package microsoft;

public class VersionCompare {

    static int compare(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int len1 = v1.length;
        int len2 = v2.length;
        int i1 = 0;
        int i2 = 0;

        while (i1 < len1 || i2 < len2) {
            if (i1 == len1) {
                if (v2[i2].length() > 0 && Integer.valueOf(v2[i2]) > 0)
                    return -1;
                i2++;
            } else if (i2 == len2) {
                if (v1[i1].length() > 0 && Integer.valueOf(v1[i1]) > 0)
                    return 1;
                i1++;
            } else {
                int num1 = v1[i1].length() == 0 ? 0 : Integer.valueOf(v1[i1]);
                int num2 = v2[i2].length() == 0 ? 0 : Integer.valueOf(v2[i2]);

                if (num1 == num2) {
                    i1++;
                    i2++;
                } else if (num1 > num2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(compare("1", "1.1"));

        System.out.println(Integer.parseInt("001"));
    }
}
