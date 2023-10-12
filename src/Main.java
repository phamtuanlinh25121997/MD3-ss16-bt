import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File outputDir = new File("output");
        File helloFile = new File("output/hello.txt");
        File subDir = new File("output/subfolder");
        File output1File = new File("output/subfolder/output1.txt");
        File output1Dir = new File("output/subfolder/output1");

        if (outputDir.exists()) {
            outputDir.delete();
        }

        if (output1Dir.mkdir()) {
            helloFile.createNewFile();
            if (subDir.mkdir()) {
                output1File.createNewFile();
                output1Dir.mkdir();
            }
        }

        subDir.renameTo(new File("output/subfolder1"));

        System.out.println("Cấu trúc của cây thư mục là:");
        displayDirTree(outputDir);

    }

    private static void displayDirTree(File rootDir) {
        if (rootDir.isDirectory()) {
            System.out.println(rootDir.getName());
            File[] subFiles = rootDir.listFiles();
            String prefixLv1 = "-";
            for (File subFile : subFiles) {
                System.out.println(prefixLv1 + subFile.getName());
                if (subFile.isDirectory()) {
                    String prefixLv2 = "--";
                    File[] subFileLv2s = subFile.listFiles();
                    for (File subFileLv2 : subFileLv2s) {
                        System.out.println(prefixLv2 + subFileLv2.getName());
                    }
                }
            }
        } else {
            System.out.println(rootDir.getName());
        }
    }
}