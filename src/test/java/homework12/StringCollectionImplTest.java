package homework12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCollectionImplTest {
    private StringCollectionImpl collection;
    private final int initCollectionSize = 5;

    @BeforeEach
    public void setCollection() {
        collection = testCollection();
    }

    private StringCollectionImpl testCollection() {
        StringCollectionImpl testCollection = new StringCollectionImpl();
        for (int i = 0; i < initCollectionSize; i++) {
            testCollection.add("String" + i);
        }
        return testCollection;
    }

    @Test
    public void testSize() {
        //expected
        assertEquals(5, collection.size());
    }

    @Test
    public void testGet() {
        //expected
        assertEquals(collection.get(0), "String0");
        assertEquals(collection.get(1), "String1");
    }

    @Test
    public void testAdd() {
        //expected
        String newElement = "String10";
        collection.add(newElement);
        //actual
        assertEquals(collection.get(initCollectionSize), "String10");
    }

    @Test
    public void testAddByIndex() {
        //expected
        String newElement = "StringCheck";
        int indexOfNewElement = 2;
        collection.add(indexOfNewElement, newElement);
        //actual
        assertEquals(collection.get(2), "StringCheck");
        assertEquals(collection.size(), initCollectionSize + 1);
    }

    @Test
    public void testDelete() {
        //expected
        String deletedElement = "String2";
        collection.delete(deletedElement);
        //actual
        assertEquals(collection.size(), initCollectionSize - 1);
    }

    @Test
    public void testContains() {
        //expected
        String containedElement = "String6";
        String notContainedElement = "String10";
        collection.add(containedElement);
        //actual
        assertTrue(collection.contains(containedElement));
        assertFalse(collection.contains(notContainedElement));
    }

    @Test
    public void testEquals() {
        StringCollectionImpl checkCollection = testCollection();
        //expected
        assertTrue(collection.equals(checkCollection));
        checkCollection.add("String7");
        assertFalse(collection.equals(checkCollection));

    }

    @Test
    public void testClear() {
        //expected
        collection.clear();
        //actual
        assertEquals(0, collection.size());
    }
}
