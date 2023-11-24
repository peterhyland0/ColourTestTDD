package com.pcjh1;

import java.util.ArrayList;
import java.util.List;

public class ColourTableTDD {
    private int palette;
    private final List<int[]> colorTable;
    public ColourTableTDD(int palette) {
        if (!inValidPaletteSize(palette)) {
            throw new IllegalArgumentException("Invalid palette size");
        }
        this.palette = palette;
        this.colorTable = new ArrayList<>();
    }

    public void setPalette(int palette) {
        this.palette = palette;
    }

    public int getPalette() {
        return palette;
    }

    public void add(int red, int green, int blue) {


        int[] rgbColor = {red, green, blue};
        for (int rgbValue : rgbColor) {
            if (invalidRGBValue(rgbValue)) {
                throw new IllegalArgumentException("Invalid RGB value");
            }
        }
        if (colorTable.size() < palette) {
            colorTable.add(rgbColor);
        } else {
            throw new IllegalStateException("Exceeded the capacity of the ColourTable");
        }
    }

    public List<int[]> getColorTable() {
        return colorTable;
    }
    public boolean invalidRGBValue(int rgbValue) {
        return rgbValue < 0 || rgbValue > 255;
    }

    public boolean inValidPaletteSize(int palette) {
        return palette > 1 && palette < 1025 && (palette & (palette - 1)) == 0;
    }
}
