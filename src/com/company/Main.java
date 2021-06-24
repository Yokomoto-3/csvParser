package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> paths = new ArrayList<>();
        paths.add("D:\\Programms JAVA\\untitled\\src\\com\\company\\test1.csv");
        paths.add("D:\\Programms JAVA\\untitled\\src\\com\\company\\test2.csv");
        paths.add("D:\\Programms JAVA\\untitled\\src\\com\\company\\test3.csv");

        for (String path:paths ) {
            Thread thread = new Thread(new csvParser(path));
            thread.setName(path);
            thread.start();
            thread.join();
        }
    }
}
