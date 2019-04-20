package com.ceomer.tutorial.bitflag;

import org.junit.Test;

import static org.junit.Assert.*;

public class FlagManagerTest {

    @Test
    public void test_areFlagsSet(){
        FlagManager flagManager = new FlagManager();
        flagManager.setFlags(FlagManager.GREEN | FlagManager.COOL);

        assert(flagManager.isGreen());
        assert(flagManager.isCool());
        assertFalse(flagManager.isLong());
        assertFalse(flagManager.isHeavy());
        assertFalse(flagManager.isOld());
    }

}