package com.pcjh1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
public class TestColourTableTDD {
    @Test
    public void testColourTableTDD() {
        ColourTableTDD colourTable = new ColourTableTDD(4);
        colourTable.setPalette(4);
        assertEquals(4, colourTable.getPalette());

    }


    @ParameterizedTest
    @ValueSource(ints = {0, 3, -234, 7, 11111})
    public void testColourTableTDDInvalidPaletteSize(int invalidPaletteSize) {
        assertThrows(IllegalArgumentException.class, () -> {
            ColourTableTDD colourTable = new ColourTableTDD(invalidPaletteSize);
        });
        // Add more assertions for the expected behavior when an invalid palette size is provided
    }


    }


