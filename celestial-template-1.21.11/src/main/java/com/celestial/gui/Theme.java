package com.celestial.gui;

public enum Theme {
    ASTRAL(0xFF7B68EE, 0xFF191970, "Astral"),
    SOLARIS(0xFFFFB347, 0xFF8B0000, "Solaris"),
    VOID(0xFF00FFFF, 0xFF000000, "Void"),
    EMERALD(0xFF00FF7F, 0xFF003300, "Emerald"),
    CRIMSON(0xFFFF4500, 0xFF2B0000, "Crimson");

    public final int accent;
    public final int background;
    public final String displayName;

    Theme(int accent, int background, String displayName) {
        this.accent = accent;
        this.background = background;
        this.displayName = displayName;
    }
}
