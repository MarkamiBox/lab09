package it.unibo.mvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation lof the Controller Interface.
 */
public final class SimpleController implements Controller {

    private String currentString;
    private final List<String> stringhistory = new ArrayList<>();

    @Override
    public void setNextString(final String string) {
        if (string == null) {
            throw new IllegalArgumentException("The string can't be null");
        }
        this.currentString = string;
    }

    @Override
    public String getNexString() {
        return this.currentString;
    }

    @Override
    public List<String> getPrintStringHistroy() {
        return Collections.unmodifiableList(this.stringhistory);
    }

    @Override
    public void printString() {
        if (currentString == null) {
            throw new IllegalStateException("Current print string is null");
        }
        System.out.println(currentString); // NOPMD: Requested
        this.stringhistory.add(this.currentString);
    }
}
