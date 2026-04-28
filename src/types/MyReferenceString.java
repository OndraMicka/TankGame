package types;

public class MyReferenceString{
    private String value;

    public MyReferenceString(String value) {
        this.value = value;
    }

    public MyReferenceString() {
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
