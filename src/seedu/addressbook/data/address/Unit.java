package seedu.addressbook.data.address;

import seedu.addressbook.data.exception.IllegalValueException;

public class Unit extends AddressComponent {
    private static final String EXAMPLE_INPUT = "#12-34";
    private static final String FORMAT_CONSTRAINTS = "Person addresses must be in the form " +
            "a/BLOCK, STREET, UNIT, POSTAL_CODE";
    private static final String VALIDATION_REGEX = "[#\\w\\.]+[-\\w\\.]+";

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Unit(String postalCode, boolean isPrivate) throws IllegalValueException {
        super(postalCode.trim(), isPrivate, EXAMPLE_INPUT);
        if (!isValidUnit(postalCode.trim())) {
            throw new IllegalValueException(FORMAT_CONSTRAINTS);
        }
    }

    /**
     * Returns true if a given string is a valid block address.
     */
    public boolean isValidUnit(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Unit // instanceof handles nulls
                && this.value.equals(((Unit) other).value)); // state check

    }
}
