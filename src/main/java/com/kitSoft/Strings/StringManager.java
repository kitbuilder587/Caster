package com.kitSoft.Strings;

public class StringManager {
    public static int getSymbolLine(String s, int k){
        int line = 1;
        for(int i=0;i<s.length();i++){
            if(i==k)
                break;

            if(s.charAt(i) == '\n')
                line++;

        }
        return line;
    }

    public static int getLinesCount(String s){
        if(s == null || s.length() == 0)
            return 0;
        int lines = 1;
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) == '\n')
                lines++;
        }

        return lines;
    }

    public static String generateStringFrom1ToN(int n){
        StringBuilder res= new StringBuilder();
        for(int i=0;i<n;i++){
            res.append(i+1).append("\n");
        }
        return res.toString();
    }

    public static int getMaximumColumnsCount(String s){
        int maxColumns = 0;
        int columns = 0;
        for(int i=0;i<s.length();i++){
            if (s.charAt(i) == '\n'){
                maxColumns = Math.max(maxColumns,columns);
                columns = 0;
            }else {
                columns++;
            }
        }
        return maxColumns;
    }
}
