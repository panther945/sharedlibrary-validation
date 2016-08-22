package sharedlibrary.validation;

import android.databinding.ObservableField;

import java.util.Locale;

/**
 * Created by Patrick Hsiao on 2016/8/18.
 */
public class RepeatWordRule extends ObservableRule {
    private final String format = ".*(\\w)\\1{%d}.*";
    private final int count;
    private final String regularExpression;
    private boolean caseSensitive = true;

    public RepeatWordRule(String label, ObservableField<String> field, int count) {
        super(label, field);
        this.count = count;
        this.regularExpression = String.format(Locale.US, format, count - 1);
    }

    @Override
    public boolean isValid() {
        return caseSensitive ? !field.get().matches(regularExpression)
                : !field.get().toUpperCase().matches(regularExpression);
    }

    @Override
    public String invalidMessage() {
        return label + "不可含" + count + "個重複字元";
    }

    public void setCaseSensitive(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }
}
