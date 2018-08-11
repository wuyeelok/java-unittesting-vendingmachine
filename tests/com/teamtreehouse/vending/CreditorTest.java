package com.teamtreehouse.vending;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditorTest {

    private Creditor creditor;

    @Before
    public void setUp() throws Exception {
        creditor = new Creditor();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("One test is completed");
    }

    @Test
    public void addingFundsIncrementsAvaliableFunds() {


        //  Act
        creditor.addFunds(25);
        creditor.addFunds(25);

        //  Assert
        assertEquals(50, creditor.getAvailableFunds());

    }

    @Test
    public void refundingReturnsAllAvailableFunds() {

        creditor.addFunds(10);

        int refund = creditor.refund();

        assertEquals(10, refund);
    }

    @Test
    public void refundingResetsAvailableFundsToZero() {


        creditor.addFunds(60);
        creditor.refund();

        assertEquals(0, creditor.getAvailableFunds());
    }


}