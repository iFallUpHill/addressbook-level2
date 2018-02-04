package seedu.addressbook.data.address;

import seedu.addressbook.data.exception.IllegalValueException;

public class Street extends AddressComponent {

    private static final String EXAMPLE_INPUT = "Clementi Ave";
    private static final String FORMAT_CONSTRAINTS = "Street can be any string";
    private static final String VALIDATION_REGEX = ".+";

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Street(String postalCode, boolean isPrivate) throws IllegalValueException {
        super(postalCode.trim(), isPrivate, EXAMPLE_INPUT);
        if (!isValidStreet(postalCode.trim())) {
            throw new IllegalValueException(FORMAT_CONSTRAINTS);
        }
    }

    /**
     * Returns true if a given string is a valid block address.
     */
    public boolean isValidStreet(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Street // instanceof handles nulls
                && this.value.equals(((Street) other).value)); // state check

    }
}
