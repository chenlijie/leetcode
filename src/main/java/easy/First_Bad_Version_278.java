package easy;

/**
 * Created by chenlijie on 5/5/17.
 */
public class First_Bad_Version_278 {


    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n+1;
        int mi;
        while (lo < hi) {
            mi = (lo + hi)/2;

            if (isBadVersion(mi)) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }

        return lo < 0 || lo == n+1 ? 0 : lo;
    }

    char[] flag = new char[] {'F', 'T'};
    boolean isBadVersion(int version) {
        if (flag[version] == 'T')
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new First_Bad_Version_278().firstBadVersion(1));
    }
}
