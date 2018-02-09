package facebook.onsite;

import java.util.Arrays;

public class FriendRequest {

//    给定一个长为n的数组Ages, 其中第i个元素表示第i个人的年龄。求这个n各种，发送的好友请求的总数。其中，
//    1. 如果Age(B)<= (1/2)Age(A) + 7, A不会给B发请求  Age(B) > (1/2)Age(A) + 7
//    2. 如果Age(B) > Age(A)， A不会给B发请求.  Age(B) <= Age(A)
//    3. 如果Age(B)>100 and Age(A)<100, A不会给B发请求
//    4. 不满足1，2，3，则A会给B发请求。

    // Age(B) > (1/2)Age(A) + 7, Age(B) <= Age(A)
    // [1, 2, 3, 4, 5, 6]
    //                 A
    // we need to find those elements which value is larger than t, and t is (1/2)Age(A) + 7;

    static int requestNum(int[] ages) {

//        Arrays.sort(ages);
        int cnt = 0;
        int len = ages.length;
        for (int i = len - 1; i >= 0; i--) {
            int t = ages[i]/2 + 7;

            int lo = 0;
            int hi = i;

            while (lo < hi) {
                int mi = (lo + hi) / 2;

                if (ages[mi] > t) {
                    hi = mi;
                } else {
                    lo = mi + 1;
                }
            }

            for (int j = lo; j < i; j++) {
                System.out.println(ages[j] + ", " + ages[i]);
            }

            cnt += i - lo;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(requestNum(new int[] {5,8,10,15,17,18,19,20}));
//        System.out.println(requestNum(new int[] {60,120}));
    }
    // A = 60, B = 120
//    1. 如果Age(B)<= (1/2)Age(A) + 7, A不会给B发请求  Age(B) > (1/2)Age(A) + 7
//    2. 如果Age(B) > Age(A)， A不会给B发请求.  Age(B) <= Age(A)
//    3. 如果Age(B)>100 and Age(A)<100, A不会给B发请求
//    4. 不满足1，2，3，则A会给B发请求。
}
