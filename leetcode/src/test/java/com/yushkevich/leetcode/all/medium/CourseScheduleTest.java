package com.yushkevich.leetcode.all.medium;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CourseScheduleTest {

    private CourseSchedule solution = new CourseSchedule();

    @Test
    public void exampleOne() {
        assertTrue(solution.canFinish(2, new int[][]{{1, 0}}));
    }

    @Test
    public void exampleTwo() {
        assertFalse(solution.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }
}
