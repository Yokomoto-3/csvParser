package com.company;

import java.io.*;
import java.util.*;

public class csvParser implements Runnable {
    public csvParser(String path) {
        this.path = path;
    }

    String path;
    int column = 0;
    int row = 0;
    String text = "";

    ArrayList<Print> files = new ArrayList<>();

    @Override
    public void run() {

        parse(path);
        System.out.println(Thread.currentThread().getName());
    }

    public void parse(String path) {
        try (FileReader reader = new FileReader(path)) {
            int c;
            while ((c = reader.read()) != -1) {
                if (c != 59 && c != 13 && c != 10) {
                    text += (char) c;
                }
                if (c == 59) {
                    if (row == 0) files.add(new Print(row, column, text, true));
                    else files.add(new Print(row, column, text, false));
                    text = "";
                    column++;
                } else if (c == 10) {
                    if (row == 0) files.add(new Print(row, column, text, true));
                    else files.add(new Print(row, column, text, false));
                    column = 0;
                    text = "";
                    row++;
                }
            }

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        Collections.sort(files, Print.COMPARE_BY_COLUMN);
        for (Print file : files) {
            if (file.header == true) {
                System.out.println("\n" + file.data + ":");

            } else {
                System.out.print(file.data + ";");
            }


        }
        System.out.println();
    }
}
