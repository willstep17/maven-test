import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class JUnitTests {
    public List<String> names;

    @Before
    public void setUp() {
        names = new ArrayList<>();
        names.add("Daniel");
    }

    @Test
    public void testIfNamesIsInitialized() {
        assertNotNull(names);
    }

    @Test
    public void TestIfNamesCanBeAdded() {
        assertEquals(1, this.names.size());
        this.names.add("Zach");
        assertEquals(2, this.names.size());
        assertSame("Daniel", this.names.get(0));
        assertSame("Zach", this.names.get(1));
    }

    @Test
    public void testIfTestsWork() {
        this.names.add("Will");
        assertSame("Will", this.names.get(1));
    }

    @Test
    public void testIfArraysAreSame() {
        boolean[] expected = {true, true, false};
        boolean[] actual = {true, true, false};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testIfTrue() {
        assertTrue(!false);
        assertFalse(false);
        assertTrue(4 > 2);
    }

    @Test
    public void testIfEqual() {
        assertEquals("String", "String");
        assertEquals(4.53, 4.72, .2);
    }
}
