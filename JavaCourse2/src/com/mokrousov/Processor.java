package com.mokrousov;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Processor {
  public static boolean process(File f) throws IOException {
    Path path = f.toPath();
    boolean flag = false;
    StringBuilder text = new StringBuilder();
    Scanner scanner = new Scanner(new FileInputStream(f));
    scanner.useDelimiter(" ");
    while (scanner.hasNext()) {
      String s = scanner.next();

      if (s.equals("public")) {
        StringBuilder builder = new StringBuilder();
        String next = scanner.next();
        builder.append(' ');

        if (next.equals("abstract") || next.equals("static")) {
          builder.append(next);
          builder.append(' ');
          next = scanner.next();
        }

        if (next.equals("class")) {
          text.append("public");
        } else {
          flag = true;
          text.append("protected");
        }

        text.append(builder);
        text.append(next);
        text.append(' ');
      } else {
        text.append(s);
        text.append(' ');
      }
    }

    if (flag) {
      Files.write(path, text.toString().getBytes());
      return true;
    } else {
      return false;
    }
  }
}
