package it.unibo.mvc;

import java.util.List;

/**
 * A simple controller responsible of I/O access.
 */
public interface Controller {

    /**
     * Set the next string to print.
     * 
     * @param string next string to be set.
     * @throws IllegalArgumentException if current string is null.
     */
    void setNextString(String string);

    /**
     * Get the current string.
     * 
     * @return the current strng.
     */
    String getNexString();

    /**
     * Get the list of printed strings.
     * 
     * @return the list of printed string.
     */
    List<String> getPrintStringHistroy();

    /**
     * Print the current string.
     * 
     * @throws IllegalStateException if current string is null.
     */
    void printString();
}
