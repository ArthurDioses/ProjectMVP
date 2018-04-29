package com.example.adiosesr.appmvpexample.data.source;

public enum Extras {
    EXTRAS_TASK("task"),;

    private String extra;

    Extras(String extra) {
        this.extra = extra;
    }

    public String getExtra() {
        return extra;
    }
}
