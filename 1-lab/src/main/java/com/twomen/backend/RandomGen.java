package com.twomen.backend;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class RandomGen {
  public static void main(String[] args) throws FileNotFoundException {
    try (PrintWriter printer = new PrintWriter(new FileOutputStream("sql/perf_test.sql"))) {
      printer.println("use CRUD_REST;");

      printer.println("insert into films (film_name, film_desc) values");

      for (int i = 1, n = 100000; i <= n; ++i) {
        printer.printf("('%d', '%d')", i, i);
        if (i == n) printer.println(";");
        else printer.println(",");
      }
    }
  }
}
