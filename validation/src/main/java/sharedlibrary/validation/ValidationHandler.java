package sharedlibrary.validation;

/**
 * Created by Patrick Hsiao on 2016/8/18.
 */
public interface ValidationHandler {
    void onValidate();
    void onInvalid(String message);
}
