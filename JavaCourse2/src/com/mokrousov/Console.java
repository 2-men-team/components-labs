package com.mokrousov;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Console {
  public static void runConsole(InputStream stream) {
    Scanner scanner = new Scanner(stream);

    System.out.println("Interactive console. Print 'exit' to finish.");
    while (true) {
      System.out.print("Enter directory: ");
      String dir = scanner.next();
      if (dir.equals("exit"))
        return;

      File file = new File(dir);
      if (!file.isDirectory()) {
        System.out.println("Invalid directory path.");
        continue;
      }

      Replacer replacer = new Replacer(file, 5);
      Future<List<String>> task = replacer.submit();

      try {
        for (String f : task.get()) {
          System.out.println(f);
        }
      } catch (ExecutionException | InterruptedException e) {
        e.printStackTrace();
      }

      replacer.finish();
      break;
    }
  }
}
 