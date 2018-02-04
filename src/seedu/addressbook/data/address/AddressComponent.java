package seedu.addressbook.data.address;

public class AddressComponent {

    public String EXAMPLE;

    public final String value;
    private boolean isPrivate;

    public AddressComponent(String address, boolean isPrivate, String example) {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        this.EXAMPLE = example;
        this.value = trimmedAddress;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

}
