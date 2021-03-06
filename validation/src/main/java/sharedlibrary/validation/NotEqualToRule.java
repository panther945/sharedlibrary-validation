package sharedlibrary.validation;

import android.databinding.ObservableField;

/**
 * Created by Patrick Hsiao on 2016/10/4.
 */

public class NotEqualToRule extends ObservableRule {
    private final String otherLabel;
    private final ObservableField<String> other;

    public NotEqualToRule(String label, ObservableField<String> field, String otherLabel, ObservableField<String> other) {
        super(label, field);
        this.other = other;
        this.otherLabel = otherLabel;
    }

    @Override
    public boolean isValid() {
        return !field.get().equals(other.get());
    }

    @Override
    public String invalidMessage() {
        return label + "不可與" + otherLabel + "相同";
    }
}
