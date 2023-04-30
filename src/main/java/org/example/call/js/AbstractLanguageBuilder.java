package org.example.call.js;

import java.util.Objects;

public abstract class AbstractLanguageBuilder {

    private StringBuilder str;

    public String build() {
        return (Objects.requireNonNull(str)).toString();
    }

}
