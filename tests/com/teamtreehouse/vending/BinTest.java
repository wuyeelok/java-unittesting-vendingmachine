package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class BinTest {

    private Bin bin;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        bin = new Bin(10);
    }

    @Test
    public void restockingDifferentItemsIsNotAllowed() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Cannot restock Coke with Beer");

        bin.restock("Coke", 2, 6, 10);
        bin.restock("Beer", 1, 2, 9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void restockingMoreThanRemainingCapaticyIsNotAllowed() {
        // amount > getAvailableSlots()
        bin.restock("ABC", 20, 6, 10);
    }

    @Test
    public void whenEmptyPriceIsZero() {
        assertEquals(0, bin.getItemPrice());
    }

    @Test
    public void whenEmptyNameIsNull() {
        assertNull(bin.getItemName());
    }

    @Test
    public void overStockingNotAllowed() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("There are only 10 spots left");

        bin.restock("Beer", 11, 20, 25);
    }
}