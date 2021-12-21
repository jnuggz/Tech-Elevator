package com.techelevator;

import java.io.*;

public class BufferedWriterExample {

    public static void main(String[] args) throws IOException {

        /*
         * Create a file and PrintWriter
         */
        File file = new File("bufferedFile");

        /*
         * To add buffering a Print Writer is still needed and will still do the writing.
         * A BufferedWriter is added and passed the Print Writer.  The Print Writer will still
         * write to the file and the buffered writer will provide buffering.
         */
        try ( PrintWriter printWriter = new PrintWriter(file);
              BufferedWriter bufferedWriter = new BufferedWriter( printWriter )) {

                /*
                    With buffered writer use the write() method to write text to
                    the file.
                 */
                bufferedWriter.write("This is line one");
                /*
                    Unlike printerWriter's println(), bufferedWriter's write() does not add
                    a new line, but one can be added using the newLine() method.
                 */
                bufferedWriter.newLine();
                bufferedWriter.write("This is line two");
        }

    }
}
