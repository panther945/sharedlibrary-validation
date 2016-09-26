package sharedlibrary.validation;

import android.databinding.ObservableField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick Hsiao on 2016/8/18.
 */
public final class SimpleValidator extends Validator {

    protected SimpleValidator(List<Rule> rules) {
        super(rules);
    }

    public static final class Builder {
        List<Rule> rules = new ArrayList<>();
        String label;
        ObservableField<String> field;
        ValidationHandler handler;

        public SimpleValidator build() {
            SimpleValidator validator = new SimpleValidator(rules);
            validator.setHandler(handler);
            return validator;
        }

        public Builder label(String label) {
            this.label = label;
            return this;
        }

        public Builder filed(ObservableField<String> field) {
            if (field == null) {
                throw new IllegalStateException("Filed is required");
            }

            this.field = field;
            return this;
        }

        public Builder handler(ValidationHandler handler) {
            this.handler = handler;
            return this;
        }

        public Builder observableHandler(final ObservableField<String> error) {
            this.handler = new ValidationHandler() {
                @Override
                public void onValidate() {
                    // clear error message
                    error.set(null);
                }

                @Override
                public void onInvalid(String message) {
                    error.set(message);
                }
            };

            return this;
        }

        public Builder addRule(Rule rule) {
            rules.add(rule);
            return this;
        }

        public Builder required() {
            rules.add(new RequiredRule(label, field));
            return this;
        }

        public Builder formatEmail() {
            rules.add(new EmailFormatRule(label, field));
            return this;
        }

        public Builder length(int max, int min) {
            rules.add(new LengthRule(label, field, max, min));
            return this;
        }

        public Builder repeatWord(int count) {
            rules.add(new RepeatWordRule(label, field, count));
            return this;
        }

        public Builder continuousWord(int count) {
            rules.add(new ContinuousWordRule(label, field, count));
            return this;
        }
    }
}
