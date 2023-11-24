package com.pcjh1;

public class ColourTableTDD {
    private int palette;

    public ColourTableTDD(int palette) {
        if (!inValidPaletteSize(palette)) {
            throw new IllegalArgumentException("Invalid palette size");
        }
        this.palette = palette;
    }

    public void setPalette(int palette) {
        this.palette = palette;
    }

    public int getPalette() {
        return palette;
    }

    public boolean inValidPaletteSize(int palette) {
        return palette > 1 && palette < 1025 && (palette & (palette - 1)) == 0;
    }
}
