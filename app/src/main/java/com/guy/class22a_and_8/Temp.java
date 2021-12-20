package com.guy.class22a_and_8;

public class Temp {
}
/*
    private static boolean check(String input, Watcher watcher) {
        if (watcher instanceof Watcher_Positive) {
            double num = -1;
            try {
                num = Double.valueOf(input);
            } catch (Exception ex) { }

            if (num >= 0) {
                return true;
            } else {
                return false;
            }
        } else if (law == INTEGER) {
            boolean isOk = true;
            try {
                int num = Integer.valueOf(input);
            } catch (Exception ex) {
                isOk = false;
            }

            if (isOk) {
                return true;
            } else {
                return false;
            }
        } else if (law == IS_NUMBER) {
            boolean isOk = true;
            try {
                double num = Double.valueOf(input);
            } catch (Exception ex) {
                isOk = false;
            }

            if (isOk) {
                return true;
            } else {
                return false;
            }
        } else if (law == LESS_THAN) {
            double num;
            double val;
            try {
                num = Double.valueOf(input);
                val = ((Number) value).doubleValue();

                if (num < val) {
                    return true;
                }
            } catch (Exception ex) { }

            return false;
        } else if (law == WITHOUT_LETTERS) {
            char[] chars = (char[]) value;
            for (char c : chars) {
                if (input.indexOf(c) != -1) {
                    return false;
                }
            }
        } else if (law == LETTER_MAXIMUM) {
            char c = 'A';
            int n = 3;

            String temp = input.replaceAll(""+c, "");
            if (input.length() - temp.length() > n) {
                return false;
            }
        }

        return true;
    }

 */