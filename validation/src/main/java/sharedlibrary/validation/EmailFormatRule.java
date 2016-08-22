package sharedlibrary.validation;

import android.databinding.ObservableField;
import android.util.Patterns;

/**
 * Created by Patrick Hsiao on 2016/8/18.
 */
public class EmailFormatRule extends ObservableRule {
    public EmailFormatRule(String label, ObservableField<String> field) {
        super(label, field);
    }

    @Override
    public boolean isValid() {
        return Patterns.EMAIL_ADDRESS.matcher(field.get()).matches();
    }

    @Override
    public String invalidMessage() {
        return "Email格式錯誤";
    }
}
