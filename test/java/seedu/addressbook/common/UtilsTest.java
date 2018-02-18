package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {


    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }

    @Test
    public void elementsAreNull() throws Exception {
        // empty list
        assertHasNoNull();

        // lists containing null objects
        assertHasAnyNull((Object) null);
        assertHasAnyNull(null, null);
        assertHasAnyNull("Abc", null);
        assertHasAnyNull(123, null);
        assertHasAnyNull("Abc", 123, null);
        assertHasAnyNull(null, "Abc");
        assertHasAnyNull(null, 123);
        assertHasAnyNull(null, "Abc", 123);
        assertHasAnyNull("Abc", 123, null, "Abc", 123);
        assertHasAnyNull("Abc", 123, null, "Abc", 123, null);

        // lists without null objects
        assertHasNoNull("Abc");
        assertHasNoNull(123);
        assertHasNoNull("Abc", 123);
        assertHasNoNull("Abc", 123, "Abc", 123);
        assertHasNoNull("Abc", 123, "def", 456);

    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertHasAnyNull(Object... objects) {
        assertTrue(Utils.isAnyNull(objects));
    }

    private void assertHasNoNull(Object... objects) {
        assertFalse(Utils.isAnyNull(objects));
    }

}
