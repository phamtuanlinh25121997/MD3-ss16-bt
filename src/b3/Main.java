package b3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\admin\\Desktop\\test\\MD3_ss16bt\\data\\data.txt";
        List<String> duplicateWords = findDuplicateWords(fileName);
        if (duplicateWords != null) {
            System.out.println("Các từ trùng lặp trong file là: " + duplicateWords);
        } else {
            System.out.println("Không thể đọc file.");
        }
    }

    public static List<String> findDuplicateWords(String fileName) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+"); // Tách nội dung thành các từ
                for (String word : words) {
                    word = word.toLowerCase().replaceAll("[^a-zA-Z]", ""); // Chuyển đổi thành chữ thường và loại bỏ dấu câu
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1); // Đếm số lần xuất hiện của từ
                    }
                }
            }

            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                if (entry.getValue() > 1) {
                    result.add(entry.getKey());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return result;
    }
}
