package b2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\admin\\Desktop\\test\\MD3_ss16bt\\data\\data.txt";
        int lineCount = countLines(fileName);
        if (lineCount >= 0) {
            System.out.println("Số lượng dòng trong file là: " + lineCount);
        } else {
            System.out.println("Không thể đọc file.");
        }
    }
    public static int countLines(String fileName) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
        return count;
    }
}
