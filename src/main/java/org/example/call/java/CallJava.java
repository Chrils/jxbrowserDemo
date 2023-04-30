package org.example.call.java;

public abstract class CallJava {

    private final String attrName;

    public String getAttrName() {
        return attrName;
    }

    public CallJava() {
        this.attrName = this.getClass().getSimpleName();
    }

    public CallJava(String attrName) {
        this.attrName = attrName;
    }
}