import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ElementTest {

    E element;
    @BeforeEach
    public void init(){
        element = new E(1);

    }
    @Test
    void checkValues() {
        E lower = new E(-2);
        E higher = new E(100);
        E same = new E(1);
        assertTrue(element.compareTo(lower)==1);
        assertTrue(element.compareTo(higher)==-1);
        assertTrue(element.compareTo(same)==0);
    }

}