package amazon.onsite;

public class MovingAverage {

    int cur = 0;
    int[] nums;
    int size = 0;
    double sum;
    /*
     * @param size: An integer
     */
    public MovingAverage(int size) {
        // do intialization if necessary
        nums = new int[size];
    }

    /*
     * @param val: An integer
     * @return:
     */
    public double next(int val) {
        // write your code here
        if (size >= nums.length) {
            sum += val - nums[cur];
            nums[cur] = val;
            cur = (++cur) % nums.length;
            return sum/nums.length;
        } else {
            sum += val;
            nums[cur] = val;
            cur = (++cur) % nums.length;
            size++;

            return sum / size;
        }

    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
    }
}
