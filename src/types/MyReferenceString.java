package types;

/**
 * A wrapper for strings that can be used as a reference.
 * Useful when you need to keep a reference to a string value even if its changed.
 */
public class MyReferenceString{
    private String value;

    public MyReferenceString(String value) {
        this.value = value;
    }

    /**
     * Returns the string representation.
     * @return the string value
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }

    /**
     * Required for Json
     */
    public MyReferenceString() {
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
