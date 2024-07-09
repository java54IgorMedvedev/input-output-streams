package telran.io;

import java.io.*;
import java.nio.file.*;

public class CodeCommentsSeparation {

    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            System.err.println("Usage: CodeCommentsSeparation <inputFile> <outputCodeFile> <outputCommentsFile>");
            return;
        }

        Path inputFilePath = Path.of(args[0]);
        Path codeFilePath = Path.of(args[1]);
        Path commentsFilePath = Path.of(args[2]);

        try (BufferedReader reader = Files.newBufferedReader(inputFilePath);
             BufferedWriter codeWriter = Files.newBufferedWriter(codeFilePath);
             BufferedWriter commentsWriter = Files.newBufferedWriter(commentsFilePath)) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                String trimmedLine = line.trim();
                if (trimmedLine.startsWith("//")) {
                    commentsWriter.write(line);
                    commentsWriter.newLine();
                } else {
                    codeWriter.write(line);
                    codeWriter.newLine();
                }
            }
        }
    }
}
