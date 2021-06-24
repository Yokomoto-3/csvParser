package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class Print  {
    int row;
    int column;
    String data;
    boolean header;

    public Print() {

    }

    public String getData() {
        return data;
    }
    Print(int row, int column, String data,boolean header){
        this.row = row;
        this.column=column;
        this.data=data;
        this.header=header;
    }
    public  int maxCol(ArrayList<Print> files){
        int maxCol=0;
        for(Print file:files){
            if(file.row>maxCol)maxCol=file.row;
        }
        return maxCol;
    }
    public  int maxRow(ArrayList<Print> files){
        int maxRow=0;
        for(Print file:files){
            if(file.row>maxRow)maxRow=file.row;
        }
        return maxRow;
    }
    public static final Comparator<Print> COMPARE_BY_COLUMN = new Comparator<Print>() {
        @Override
        public int compare(Print lhs, Print rhs) {
            return lhs.column - rhs.column;
        }
    };

}
