package com.twomen.backend;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class DataGen {
  public static void main(String[] args) throws FileNotFoundException {
    try (PrintWriter printer = new PrintWriter(new FileOutputStream("sql/perf_test.sql"))) {
      printer.println("use supplier2;");

      printer.println("insert into films (film_name, film_desc) values");

      for (int i = 1, n = 50_000; i <= n; ++i) {
        printer.printf("('%d', '%d')", i, i);
        if (i == n) printer.println(";");
        else printer.println(",");
      }
    }
  }
}
