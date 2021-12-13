package com.guy.class22a_and_8;

import android.text.Editable;
import android.text.TextWatcher;

import androidx.annotation.NonNull;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class EditTextValidator {

    public abstract static class Watcher {
        protected CharSequence errorText;

        public Watcher(CharSequence errorText) {
            this.errorText = errorText;
        }
    }

    public static class Watcher_Negative extends Watcher {
        public Watcher_Negative(CharSequence errorText) {
            super(errorText);
        }
    }

    public static class Watcher_Positive extends Watcher {
        public Watcher_Positive(CharSequence errorText) {
            super(errorText);
        }
    }

    public static class Watcher_LessThan extends Watcher {
        protected Object value;
        public Watcher_LessThan(CharSequence errorText, Object value) {
            super(errorText);
            this.value = value;
        }
    }

    public static class Watcher_LessThanOrEqualTo extends Watcher {
        protected Object value;
        public Watcher_LessThanOrEqualTo(CharSequence errorText, Object value) {
            super(errorText);
            this.value = value;
        }
    }

    public static class Watcher_GreaterThan extends Watcher {
        protected Object value;
        public Watcher_GreaterThan(CharSequence errorText, Object value) {
            super(errorText);
            this.value = value;
        }
    }

    public static class Watcher_GreaterThanOrEqualTo extends Watcher {
        protected Object value;
        public Watcher_GreaterThanOrEqualTo(CharSequence errorText, Object value) {
            super(errorText);
            this.value = value;
        }
    }

    public static class Watcher_NotEqualTo extends Watcher {
        protected Object value;
        public Watcher_NotEqualTo(CharSequence errorText, Object value) {
            super(errorText);
            this.value = value;
        }
    }

    public static class Builder {
        private TextInputLayout textInputLayout;
        private ArrayList<Watcher> watchers = new ArrayList<>();
        private boolean isItAlreadyBuild = false;

        public static Builder make(@NonNull TextInputLayout textInputLayout) {
            return new Builder(textInputLayout);
        }

        private Builder(@NonNull TextInputLayout textInputLayout) {
            this.textInputLayout = textInputLayout;
        }

        public Builder addWatcher(Watcher watcher) {
            if (isItAlreadyBuild) {
                return this;
            }
            this.watchers.add(watcher);
            return this;
        }

        public void build() {
            if (isItAlreadyBuild) {
                return;
            }
            addValidator(textInputLayout, watchers);
            isItAlreadyBuild = true;
        }
    }

    public static void addValidator(TextInputLayout textInputLayout, ArrayList<Watcher> watchers) {
        textInputLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String input = charSequence.toString();
                boolean isOk = true;
                for (Watcher watcher : watchers) {
                    isOk = check(input, watcher);
                    if (!isOk) {
                        textInputLayout.setError(watcher.errorText);
                        break;
                    }
                }
                if (isOk) {
                    textInputLayout.setError("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });
    }

    private static boolean check(String input, Watcher watcher) {
        if (false) {

        }

        else if (watcher instanceof Watcher_Positive) {
            Double num = -1.0;
            try {
                num = getDouble(input);
            } catch (Exception ex) { }
            if (num < 0) {
                return false;
            }
        }

        else if (watcher instanceof Watcher_Negative) {
            Double num = -1.0;
            try {
                num = getDouble(input);
            } catch (Exception ex) { }
            if (num >= 0) {
                return false;
            }
        }

        else if (watcher instanceof Watcher_LessThan) {
            double value;
            double num;
            try {
                num = getDouble(input);
                value = getDouble(((Watcher_LessThan) watcher).value);
                if (num >= value) {
                    return false;
                }
            } catch (Exception ex) {
                return false;
            }
        }

        else if (watcher instanceof Watcher_LessThanOrEqualTo) {
            double value;
            double num;
            try {
                num = getDouble(input);
                value = getDouble(((Watcher_LessThanOrEqualTo) watcher).value);
                if (num > value) {
                    return false;
                }
            } catch (Exception ex) {
                return false;
            }
        }

        else if (watcher instanceof Watcher_GreaterThan) {
            double value;
            double num;
            try {
                num = getDouble(input);
                value = getDouble(((Watcher_GreaterThan) watcher).value);
                if (num <= value) {
                    return false;
                }
            } catch (Exception ex) {
                return false;
            }
        }

        else if (watcher instanceof Watcher_GreaterThanOrEqualTo) {
            double value;
            double num;
            try {
                num = getDouble(input);
                value = getDouble(((Watcher_GreaterThanOrEqualTo) watcher).value);
                if (num < value) {
                    return false;
                }
            } catch (Exception ex) {
                return false;
            }
        }

        else if (watcher instanceof Watcher_NotEqualTo) {
            double value;
            double num;
            try {
                num = getDouble(input);
                value = getDouble(((Watcher_NotEqualTo) watcher).value);
                if (num == value) {
                    return false;
                }
            } catch (Exception ex) {
                return false;
            }
        }

        return true;
    }

    private static double getDouble(Object value) {
        try {
            return ((Number) value).doubleValue();
        } catch (ClassCastException ex4) {
            return new Double(value.toString());
        }
    }

}
