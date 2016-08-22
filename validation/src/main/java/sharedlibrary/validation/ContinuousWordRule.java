package sharedlibrary.validation;

import android.databinding.ObservableField;

/**
 * Created by Patrick Hsiao on 2016/8/19.
 */
public class ContinuousWordRule extends ObservableRule {
    private final int count;

    public ContinuousWordRule(String label, ObservableField<String> field, int count) {
        super(label, field);
        this.count = count;
    }

    @Override
    public boolean isValid() {
        String data = field.get();
        if (data.length() >= count) {
            for (int i = 0; i < data.length() - count + 1; i++) {
                boolean isContinuous = true;

                // check continuous word
                for (int j = 0; j < count - 1; j++) {
                    int c1 = data.charAt(i + j);
                    int c2 = data.charAt(i + j + 1);
                    isContinuous &= Math.abs(c1 - c2) == 1;
                }

                if (isContinuous) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public String invalidMessage() {
        return "不可包含" + count + "個連續數字或英文";
    }
}
