package sharedlibrary.validation;

import java.util.List;

/**
 * Created by Patrick Hsiao on 2016/8/18.
 */
public abstract class Validator {
    protected final List<Rule> rules;
    protected ValidationHandler handler;

    protected Validator(List<Rule> rules) {
        this.rules = rules;
    }

    public boolean validate() {
        for (Rule rule : rules) {
            if (!rule.isValid()) {
                if (handler != null) {
                    handler.onInvalid(rule.invalidMessage());
                }
                return false;
            }
        }

        return true;
    }

    public void setHandler(ValidationHandler handler) {
        this.handler = handler;
    }
}
