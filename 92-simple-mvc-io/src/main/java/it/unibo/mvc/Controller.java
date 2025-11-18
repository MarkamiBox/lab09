package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public final class Controller {
    private static final String PATH = System.getProperty("user.home") + File.separator + "output.txt";
    private File currentfile = new File(PATH);

    /** 
     * Set the current file. 
     * 
     * @param name Input File
     */
    public void setFile(final File name) {
        this.currentfile = name;
    }

    /**
     * Get the current file.
     * 
     * @return the File
     */
    public File getFile() {
        return this.currentfile;
    }

    /**
     * Get the current path.
     * 
     * @return the path of the file as a string
     */
    public String getPath() {
        return currentfile.getPath();
    }

    /**
     * Set the string input into the file.
     * 
     * @param input string of input
     */
    public void setInput(final String input) {
        try (PrintStream ps = new PrintStream(PATH, StandardCharsets.UTF_8)) {
            ps.print(input);
        } catch (final IOException e) {
            System.out.println(e); // NOPMD: Requested
        }
    }
}
