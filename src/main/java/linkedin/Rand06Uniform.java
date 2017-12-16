package linkedin;

import java.util.Random;

/**
 * Created by chenlijie on 12/12/17.
 */
public class Rand06Uniform {

    int n;
    int k;
    int[] nums;

    public Rand06Uniform(int n) {
        this.n = n;
        k = n;
        nums = new int[n+1];
        for (int i = 0; i <= n; i++) {
            nums[i] = i;
        }
    }

    int getRandom() {
        if (k < 0) {
            k = n;
        }
        Random r = new Random();
        int idx = r.nextInt(k+1);
        swap(idx, k);
        return nums[k--];
    }

    void swap(int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    int rand01Uniform() {
        return new Random().nextInt(2);
    }

    int rand06Uniform() {
        while (true) {
            int res = 4*rand01Uniform() + 2*rand01Uniform() + rand01Uniform();
            if (res < 7)
                return res;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        Rand06Uniform uniform = new Rand06Uniform(n);
//        for (int i = 1; i <= (n+1)*3; i++) {
//            System.out.print(uniform.getRandom() + " ");
//            if (i%(n+1) == 0) {
//                System.out.println();
//            }
//        }
        System.out.println(uniform.rand06Uniform());
        System.out.println(uniform.rand06Uniform());
        System.out.println(uniform.rand06Uniform());
        System.out.println(uniform.rand06Uniform());
        System.out.println(uniform.rand06Uniform());
        System.out.println(uniform.rand06Uniform());
        System.out.println(uniform.rand06Uniform());
        System.out.println(uniform.rand06Uniform());
    }
}
