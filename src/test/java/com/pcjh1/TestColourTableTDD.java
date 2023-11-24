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
        @Test
        public void testInvalidPaletteSizeException () {
            assertThrows(IllegalArgumentException.class, () -> {
                ColourTableTDD colourTable = new ColourTableTDD(0);
            });

            assertThrows(IllegalArgumentException.class, () -> {
                ColourTableTDD colourTable = new ColourTableTDD(1025);
            });


        }
    @Test
    public void testAddTooMany() {
        ColourTableTDD colourTable = new ColourTableTDD(2);

        colourTable.add(255, 0, 0); // Add red
        assertEquals(1, colourTable.getColorTable().size());

        colourTable.add(0, 255, 0); // Add green
        assertEquals(2, colourTable.getColorTable().size());

        assertThrows(IllegalStateException.class, () -> {
            // Attempt to add more colors than the specified palette size
            colourTable.add(0, 0, 255); // Add blue
            colourTable.add(255, 255, 255); // Add white
        });
    }
    @Test
  public void testAdd() {
        ColourTableTDD colourTable = new ColourTableTDD(2);

        colourTable.add(255, 0, 0); // Add red
        assertEquals(1, colourTable.getColorTable().size());

        colourTable.add(0, 255, 0); // Add green
        assertEquals(2, colourTable.getColorTable().size());

        assertThrows(IllegalStateException.class, () -> {
            // Attempt to add more colors than the specified palette size
            colourTable.add(0, 0, 255); // Add blue
            colourTable.add(255, 255, 255); // Add white
        });
    }
    @Test
    public void testAddInvalidRGBValues() {
        ColourTableTDD colourTable = new ColourTableTDD(2);

        assertThrows(IllegalArgumentException.class, () -> {
            colourTable.add(-1, 0, 0); // Add red
        });

        assertThrows(IllegalArgumentException.class, () -> {
            colourTable.add(0, -1, 0); // Add green
        });

        assertThrows(IllegalArgumentException.class, () -> {
            colourTable.add(0, 0, -1); // Add blue
        });

        assertThrows(IllegalArgumentException.class, () -> {
            colourTable.add(256, 0, 0); // Add red
        });

        assertThrows(IllegalArgumentException.class, () -> {
            colourTable.add(0, 256, 0); // Add green
        });

        assertThrows(IllegalArgumentException.class, () -> {
            colourTable.add(0, 0, 256); // Add blue
        });
    }}