package seedu.addressbook.data.address;

import seedu.addressbook.data.exception.IllegalValueException;

public class Block extends AddressComponent {

    private static final String EXAMPLE_INPUT = "Block 123";
    private static final String FORMAT_CONSTRAINTS = "Block can be any string.";
    private static final String VALIDATION_REGEX = ".+";

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Block(String block, boolean isPrivate) throws IllegalValueException {
        super(block.trim(), isPrivate, EXAMPLE_INPUT);
        if (!isValidBlock(block.trim())) {
            throw new IllegalValueException(FORMAT_CONSTRAINTS);
        }
    }

    /**
     * Returns true if a given string is a valid block address.
     */
    public boolean isValidBlock(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && this.value.equals(((Block) other).value)); // state check
    }
}
