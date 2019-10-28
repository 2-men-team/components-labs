package com.twomen.backend;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class DataGen {
  public static void main(String[] args) throws FileNotFoundException {
    try (PrintWriter printer = new PrintWriter(new FileOutputStream("sql/perf_test.sql"))) {
      printer.println("use supplier1;");
      printer.println(
          "create table if not exists perf (\n" +
              "  id int primary key auto_increment,\n" +
              "  num int\n" +
              ");");

      printer.println("insert into perf (num) values");

      for (int i = 1, n = 50_000; i <= n; ++i) {
        printer.print("(" + ((int) (Math.random() * n)) + ")");
        if (i == n) printer.println(";");
        else printer.println(",");
      }
    }
  }
}
