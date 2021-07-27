package com.yushkevich.leetcode.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumDeletionsToMakeCharacterFrequenciesUniqueTest {

    @Test
    public void testMinDeletions() {
        assertEquals(0, MinimumDeletionsToMakeCharacterFrequenciesUnique.minDeletions("aab"));
        assertEquals(2, MinimumDeletionsToMakeCharacterFrequenciesUnique.minDeletions("aaabbbcc"));
        assertEquals(2, MinimumDeletionsToMakeCharacterFrequenciesUnique.minDeletions("ceabaacb"));
        assertEquals(2, MinimumDeletionsToMakeCharacterFrequenciesUnique.minDeletions("bbcebab"));
        assertEquals(276, MinimumDeletionsToMakeCharacterFrequenciesUnique.minDeletions("abcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwz"));
    }
}
