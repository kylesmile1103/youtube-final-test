package com.finaltest.youtube;

import java.io.PrintWriter;
import java.util.List;

public class WriteFile {
    private List content;

    public WriteFile() {
    }

    public void setContent(List c) {
        this.content = c;
    }

    public void writeListToFile(String p) {
        String dir = System.getProperty("user.dir") + "/src/com/finaltest/youtube/";
        String path = dir + p;
        try {
            PrintWriter pr = new PrintWriter(path);
            for (Object v : this.content) {
                pr.println(v);
            }
            pr.close();
            System.out.println("Write to file " + path + " successfully");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Write to file failed!");
        }
    }
}

