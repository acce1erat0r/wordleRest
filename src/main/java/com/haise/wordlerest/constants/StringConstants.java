package com.haise.wordlerest.constants;

public enum StringConstants {
    ANSWER("клоун");
    private final String str;

    public String getStr() {
        return str;
    }

    StringConstants(String str) {
        this.str = str;
    }
}
