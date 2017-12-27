package com.forumShiro.listener;

/**
 */
public class Online {
    private Online() {
    }

    private static volatile long count = 0;

    public static long getCount() {
        return count;
    }

    public static void add() {
        count++;
    }

    public static void delete() {
        if (count > 0)
            count--;
    }
}
