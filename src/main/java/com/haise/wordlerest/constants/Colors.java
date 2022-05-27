package com.haise.wordlerest.constants;

public enum Colors {
    RED("RED"),
    GREEN("GREEN"),
    YELLOW("YELLOW");
    private final String color;

    public String getColor() {
        return color;
    }

    Colors(String color) {
        this.color = color;
    }
}
