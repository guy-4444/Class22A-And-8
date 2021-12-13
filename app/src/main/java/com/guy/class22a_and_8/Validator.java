package com.guy.class22a_and_8;

import android.text.Editable;
import android.text.TextWatcher;

import com.google.android.material.textfield.TextInputLayout;

public class Validator {

    public static class Watcher {
        private int law;
        private Object value;
        private String error;

        public Watcher(int law, Object value, String error) {
            this.law = law;
            this.value = value;
            this.error = error;
        }
    }

    public static final int POSITIVE = 100;
    public static final int INTEGER = 101;
    public static final int IS_NUMBER = 102;
    public static final int LESS_THAN = 103;

    public static void addValidator(TextInputLayout textInputLayout, Watcher[] watchers) {
        textInputLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String input = charSequence.toString();

                boolean result = true;
                for (Watcher watcher : watchers) {
                    result = check(input, watcher.law, watcher.value);
                    if (!result) {
                        textInputLayout.setError(watcher.error);
                        break;
                    }
                }

                if (result) {
                    textInputLayout.setError("");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private static boolean check(String input, int law, Object value) {
        if (law == POSITIVE) {
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
        }

        return true;
    }

}
