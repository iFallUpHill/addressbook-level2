package seedu.addressbook.data.address;

import seedu.addressbook.data.exception.IllegalValueException;

public class PostalCode extends AddressComponent {

    private static final String EXAMPLE_INPUT = "2ADF31BFN534";
    private static final String FORMAT_CONSTRAINTS = "Postal Code must be alphanumeric.";
    private static final String VALIDATION_REGEX = "^[a-zA-Z0-9]+$";

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public PostalCode(String postalCode, boolean isPrivate) throws IllegalValueException {
        super(postalCode.trim(), isPrivate, EXAMPLE_INPUT);
        if (!isValidPostalCode(postalCode.trim())) {
            throw new IllegalValueException(FORMAT_CONSTRAINTS);
        }
    }

    /**
     * Returns true if a given string is a valid block address.
     */
    public boolean isValidPostalCode(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
                && this.value.equals(((PostalCode) other).value)); // state check
    }
}
