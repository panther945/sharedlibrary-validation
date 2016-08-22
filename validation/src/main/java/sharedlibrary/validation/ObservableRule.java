package sharedlibrary.validation;

import android.databinding.ObservableField;

/**
 * Created by Patrick Hsiao on 2016/8/18.
 */
public abstract class ObservableRule implements Rule {
    protected String label;
    protected ObservableField<String> field;

    public ObservableRule(String label, ObservableField<String> field) {
        this.label = label;
        this.field = field;
    }
}
