package sharedlibrary.validation;

import android.databinding.ObservableField;

/**
 * Created by Patrick Hsiao on 2016/8/18.
 */
public class LengthRule extends ObservableRule {
    private final int max;
    private final int min;

    public LengthRule(String label, ObservableField<String> field, int max, int min) {
        super(label, field);
        this.max = max;
        this.min = min;
    }

    @Override
    public boolean isValid() {
        return field.get().length() >= min && field.get().length() <= max;
    }

    @Override
    public String invalidMessage() {
        if (min == max) {
            return label + "長度為" + max + "個字";
        }

        return label + "長度為" + max + " ~ " + min + "個字";
    }
}
