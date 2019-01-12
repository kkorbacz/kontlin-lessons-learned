package org.kkorbacz.pitfalls;

import java.util.List;

public class InteropJava {
    private Integer integerField;

    public InteropJava(Integer integerField) {
        this.integerField = integerField;
    }

    public Integer getIntegerField() {
        return integerField;
    }

    public String dreadfulMethod(List<String> list) {
        if (!list.isEmpty()) {
            list.set(0, "Nobody expects that I was added to the collection");
        }
        return "some result";
    }
}
