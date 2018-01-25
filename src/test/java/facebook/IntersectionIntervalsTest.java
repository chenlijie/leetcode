package facebook;

import medium.Interval;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static facebook.IntersectionIntervals.insersection;
import static facebook.IntersectionIntervals.intersection;
import static facebook.IntersectionIntervals.intersectionByBinarySearch;

public class IntersectionIntervalsTest {


    List<Interval> intervals1 = new ArrayList<>();
    List<Interval> intervals2 = new ArrayList<>();

    @Before
    public void setup() {
        intervals1.clear();
        intervals2.clear();
    }

    @Test
    public void testEmpty() {
        Interval i11 = new Interval(1, 4);
        intervals1.add(i11);

        assertTrue(insersection(intervals1, intervals2).isEmpty());
    }

    @Test
    public void testOneIntersection() {
        Interval i11 = new Interval(1, 4);
        Interval i21 = new Interval(2, 8);

        intervals1.add(i11);
        intervals2.add(i21);

        Interval ans = insersection(intervals1, intervals2).get(0);
        assertEquals(ans.start, 2);
        assertEquals(ans.end, 4);
    }


    @Test
    public void testMultipleIntersection() {
        Interval i10 = new Interval(-1, 0);
        Interval i11 = new Interval(1, 4);
        Interval i12 = new Interval(6, 12);
        Interval i13 = new Interval(13, 15);

        Interval i21 = new Interval(2, 8);
        Interval i22 = new Interval(10, 12);
        Interval i23 = new Interval(15, 18);

        intervals1.add(i10);
        intervals1.add(i11);
        intervals1.add(i12);
        intervals1.add(i13);

        intervals2.add(i21);
        intervals2.add(i22);
        intervals2.add(i23);

        List<Interval> ans = insersection(intervals1, intervals2);

        System.out.println(ans);
        assertEquals(ans.size(), 4);
    }


    @Test
    public void testBinaryEmpty() {
        Interval i11 = new Interval(1, 4);
        intervals1.add(i11);

        assertTrue(intersectionByBinarySearch(intervals1, intervals2).isEmpty());
    }

    @Test
    public void testOneIntersectionOfBinary() {
        Interval i11 = new Interval(1, 4);
        Interval i21 = new Interval(2, 8);

        intervals1.add(i11);
        intervals2.add(i21);

        Interval ans = intersectionByBinarySearch(intervals1, intervals2).get(0);
        assertEquals(ans.start, 2);
        assertEquals(ans.end, 4);
    }


    @Test
    public void testMultipleIntersectionOfBinary() {
        Interval i10 = new Interval(-1, 0);
        Interval i11 = new Interval(1, 4);
        Interval i12 = new Interval(6, 12);
        Interval i13 = new Interval(13, 15);

        Interval i21 = new Interval(2, 8);
        Interval i22 = new Interval(10, 12);
        Interval i23 = new Interval(15, 18);

        intervals1.add(i10);
        intervals1.add(i11);
        intervals1.add(i12);
        intervals1.add(i13);

        intervals2.add(i21);
        intervals2.add(i22);
        intervals2.add(i23);

        List<Interval> ans = intersectionByBinarySearch(intervals1, intervals2);

        System.out.println(ans);
        assertEquals(ans.size(), 4);
    }

    @Test
    public void testEmpty2() {
        Interval i11 = new Interval(1, 4);
        intervals1.add(i11);

        assertTrue(intersection(intervals1, intervals2).isEmpty());
    }

    @Test
    public void testOneIntersection2() {
        Interval i11 = new Interval(1, 4);
        Interval i21 = new Interval(2, 8);

        intervals1.add(i11);
        intervals2.add(i21);

        Interval ans = intersection(intervals1, intervals2).get(0);
        assertEquals(ans.start, 2);
        assertEquals(ans.end, 4);
    }


    @Test
    public void testMultipleIntersection2() {
        Interval i10 = new Interval(-1, 0);
        Interval i11 = new Interval(1, 4);
        Interval i12 = new Interval(6, 12);
        Interval i13 = new Interval(13, 15);

        Interval i21 = new Interval(2, 8);
        Interval i22 = new Interval(10, 12);
        Interval i23 = new Interval(15, 18);

        intervals1.add(i10);
        intervals1.add(i11);
        intervals1.add(i12);
        intervals1.add(i13);

        intervals2.add(i21);
        intervals2.add(i22);
        intervals2.add(i23);

        List<Interval> ans = intersection(intervals1, intervals2);

        System.out.println(ans);
        assertEquals(ans.size(), 4);
    }
}