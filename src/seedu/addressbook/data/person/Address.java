package seedu.addressbook.data.person;

import seedu.addressbook.data.address.Block;
import seedu.addressbook.data.address.Street;
import seedu.addressbook.data.address.Unit;
import seedu.addressbook.data.address.PostalCode;
import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "Block 123, Clementi Ave, #12-34, 231534";
    private static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be in the form " +
            "a/BLOCK (Any String), STREET (Any String), UNIT (#Floor-Unit), POSTAL_CODE (Alphanumeric)";
    private static final String ADDRESS_VALIDATION_REGEX = ".+?(?=,),.+?(?=,),.+?(?=,),.+";

    private static final int BLOCK_INDEX = 0;
    private static final int STREET_INDEX = 1;
    private static final int UNIT_INDEX = 2;
    private static final int POSTALCODE_INDEX = 3;

    public final String value;
    private boolean isPrivate;

    private final Block block;
    private final Street street;
    private final Unit unit;
    private final PostalCode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        String[] splitAddress = trimmedAddress.split(",");

        this.isPrivate = isPrivate;
        this.block = new Block(splitAddress[BLOCK_INDEX], isPrivate);
        this.street = new Street(splitAddress[STREET_INDEX], isPrivate);
        this.unit = new Unit(splitAddress[UNIT_INDEX], isPrivate);
        this.postalCode = new PostalCode(splitAddress[POSTALCODE_INDEX], isPrivate);

        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }

        this.value = block.toString() + ", " + street.toString() + ", "
                + unit.toString() + ", " + postalCode;

    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
