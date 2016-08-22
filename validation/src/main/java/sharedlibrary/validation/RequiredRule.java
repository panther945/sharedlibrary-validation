package sharedlibrary.validation;

import android.databinding.ObservableField;
import android.text.TextUtils;

/**
 * Created by Patrick Hsiao on 2016/8/18.
 */
public class RequiredRule extends ObservableRule {

    public RequiredRule(String label, ObservableField<String> field) {
        super(label, field);
    }

    @Override
    public boolean isValid() {
        return !TextUtils.isEmpty(field.get());
    }

    @Override
    public String invalidMessage() {
        return "請輸入" + label;
    }
}
