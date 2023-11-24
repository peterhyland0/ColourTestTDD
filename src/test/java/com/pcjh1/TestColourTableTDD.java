package com.pcjh1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestColourTableTDD {
    @Test
    public void testColourTableTDD() {
        ColourTableTDD colourTable = new ColourTableTDD(4);
        colourTable.setPalette(4);
        assertEquals(4, colourTable.getPalette());
    }

}
