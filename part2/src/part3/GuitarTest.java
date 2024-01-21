package part3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuitarTest {

    @Test
    public void testGetSerialNumber() {
        Guitar guitar = new Guitar("123", 50, "Jimmy", "B", "Electric", "Maple", "Alder");
        assertEquals("123", guitar.getSerialNumber());
    }

    @Test
    public void testGetPrice() {
        Guitar guitar = new Guitar("124", 75, "James", "H", "Electric", "Maple", "Alder");
        assertEquals(75, guitar.getPrice(), 0.001);
    }

    @Test
    public void testSetPrice() {
        Guitar guitar = new Guitar("125", 63, "Jackson", "A", "Electric", "Maple", "Alder");

        guitar.setPrice(65);
        assertEquals(65, guitar.getPrice(), 0.001);

    }
}