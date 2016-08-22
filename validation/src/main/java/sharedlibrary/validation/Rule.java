package sharedlibrary.validation;

/**
 * Created by Patrick Hsiao on 2016/8/18.
 */
public interface Rule {
    boolean isValid();
    String invalidMessage();
}
