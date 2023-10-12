package b1;


import java.io.*;

public class Main {
    public static void main(String[] args) {
        File outputDirectory = new File("data");
        if (!outputDirectory.exists()) {
            outputDirectory.mkdir();
        }
        File helloFile = new File(outputDirectory, "data.txt");
        try (FileWriter writer = new FileWriter(helloFile)) {
            writer.write("Hề lô ! Đây là Huyyy ! ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileName = "C:\\Users\\admin\\Desktop\\test\\MD3_ss16bt\\data\\data.txt";
        String content = readFile(fileName);
        if (content != null) {
            String[] words = content.split("\\s+");
            int wordCount = words.length;
            System.out.println("Số lượng từ trong file là: " + wordCount);
        } else {
            System.out.println("Không thể đọc file.");
        }
    }

    public static String readFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return content.toString();
    }
}
