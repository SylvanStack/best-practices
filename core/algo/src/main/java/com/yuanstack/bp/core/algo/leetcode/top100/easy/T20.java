package com.yuanstack.bp.core.algo.leetcode.top100.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author hansiyuan
 * @date 2022年05月04日 12:00
 */
public class T20 {
    public static void main(String[] args) {

    }

    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        put('?', '?');
    }};

    public boolean isValid(String s) {
        if (s.length() > 0 && !map.containsKey(s.charAt(0))) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<Character>() {{
            add('?');
        }};
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.addLast(c);
            } else if (!map.get(stack.removeLast()).equals(c)) {
                return false;
            }
        }
        return stack.size() == 1;
    }
}
