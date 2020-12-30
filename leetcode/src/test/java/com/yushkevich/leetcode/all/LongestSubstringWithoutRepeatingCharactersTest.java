package com.yushkevich.leetcode.all;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LongestSubstringWithoutRepeatingCharactersTest {

    private LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();

    @Test
    public void exampleOne() {
        assertThat(solution.lengthOfLongestSubstring("abcabcbb"), is(3));
    }

    @Test
    public void exampleTwo() {
        assertThat(solution.lengthOfLongestSubstring("bbbbb"), is(1));
    }

    @Test
    public void exampleThree() {
        assertThat(solution.lengthOfLongestSubstring("pwwkew"), is(3));
    }

    @Test
    public void exampleFour() {
        assertThat(solution.lengthOfLongestSubstring(""), is(0));
    }

    @Test
    public void exampleFive() {
        assertThat(solution.lengthOfLongestSubstring(" "), is(1));
    }

    @Test
    public void exampleSix() {
        assertThat(solution.lengthOfLongestSubstring("dvdf"), is(3));
    }

    @Test
    public void exampleSeven() {
        assertThat(solution.lengthOfLongestSubstring("au"), is(2));
    }

    @Test
    public void exampleEight() {
        assertThat(solution.lengthOfLongestSubstring("bbtablud"), is(6));
    }

    @Test
    public void exampleNine() {
        assertThat(solution.lengthOfLongestSubstring("abba"), is(2));
    }

    @Test
    public void exampleTen() {
        assertThat(solution.lengthOfLongestSubstring(" wobgrovw"), is(6));
    }
}
