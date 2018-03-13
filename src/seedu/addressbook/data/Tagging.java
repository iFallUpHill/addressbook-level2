package seedu.addressbook.data;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;

public class Tagging {

    public enum OperationType {
        ADDITION, DELETION
    }

    private final Person person;
    private final Tag tag;
    private final OperationType operationType;

    public Tagging(Person person, Tag tag, OperationType operationType) {
        this.person = person;
        this.tag = tag;
        this.operationType = operationType;
    }

    @Override
    public String toString() {
        final String operationSymbol = (operationType == OperationType.ADDITION ? "+ " : "- ");
        return operationSymbol + person.getName().toString() + " [" + tag.tagName + "]";
    }
}
