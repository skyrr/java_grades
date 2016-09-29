import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by sky on 26.09.2016.//
 */
public class Dispatcher {
    public static void main(String[] args) throws Exception{

//        while () {
//        }
//        int i = 1;
        FileGetter f = new FileGetter();
        f.fileReader();
    }
}

class FileDisplay {
    String str;
    double dig;
    FileDisplay(String str, double dig) {
        this.str = str;
        this.dig = dig;
    }
    FileDisplay() {}
    public FileDisplay populateFile (FileDisplay f1) {
        str = " ";
        dig = 15;
        return f1;
    }
    public void displayFile(FileDisplay f1) {
        if (dig >= 4.5) {
//            return f1;
            System.out.println(">>>>>>>>>>>>>>>>>>>>");
        } else if (dig < 4.5 && dig >= 4) {
//            return f1;
            System.out.println("<<<<<<<<<<<<<<<<<<<<");
        } else {
            System.out.println("********************");
        }
    }
}

class FileGetter {
    public void fileReader() throws Exception{
        int dir = new File("\\grades\\src\\").list().length;
        for (int i = 1; i < dir; i++) {
            File f = new File("\\grades\\src\\g" + i + ".txt");
            if (f.exists() && !f.isDirectory()) {
                BufferedReader br1 = new BufferedReader(new FileReader(f));
                String temp = "";
                ArrayList<String> ag1 = new ArrayList<>();
                FileDisplay fileDisplay = new FileDisplay();
                while ((temp = br1.readLine()) != null) {
                    String[] array = temp.split(" ");
                    ag1.add(Arrays.toString(array));
                    System.out.println(array[0]);
                    String studentName = array[0];
                    String parsedStr = array[1];
                    System.out.println(parsedStr);
                    double parsedGrade = Double.parseDouble(parsedStr);
                    fileDisplay = new FileDisplay(studentName, parsedGrade);
                    fileDisplay.displayFile(fileDisplay);

                    MyFileWriter myFileWriter = new MyFileWriter();
                    myFileWriter.writeToFile(fileDisplay);
                }
                br1.close();

                System.out.println("EXISTS!!!!!!!!!!!!!!!!!!!");
                //return g;
            } else {
                System.out.println("end");
            }
        }
    }
}

class MyFileWriter {
    String str;
    double dig;
    public void writeToFile(FileDisplay f1) throws Exception {
        if (f1.dig >= 4.5) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>" + f1.dig + f1.str);
            FileWriter gradesHigh = new FileWriter("\\grades\\src\\gradesHigh.txt", true);
            BufferedWriter bw = new BufferedWriter(gradesHigh);
            PrintWriter out = new PrintWriter(bw);
            {
                out.println(f1.str + " " + f1.dig);
            }
            out.flush();
            out.close();
        } else if (f1.dig < 4.5 && f1.dig >= 4) {
            System.out.println("<<<<<<<<<<<<<<<<<<<<" + f1.dig + f1.str);
            FileWriter gradesMiddle = new FileWriter("\\grades\\src\\gradesMiddle.txt", true);
            BufferedWriter bw = new BufferedWriter(gradesMiddle);
            PrintWriter out = new PrintWriter(bw);
            {
                out.println(f1.str + " " + f1.dig);
            }
            out.flush();
            out.close();
        } else {
            System.out.println("********************" + f1.dig + f1.str);
            FileWriter gradesLow = new FileWriter("\\grades\\src\\gradesLow.txt", true);
            BufferedWriter bw = new BufferedWriter(gradesLow);
            PrintWriter out = new PrintWriter(bw);
            {
                out.println(f1.str + " " + f1.dig);
            }
            out.flush();
            out.close();
        }
    }

}