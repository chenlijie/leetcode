package medium;

/**
 * Created by chenlijie on 12/10/17.
 */
public class Interval {
    public int start;
    public int end;
    Interval() { start = 0; end = 0; }
    public Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}