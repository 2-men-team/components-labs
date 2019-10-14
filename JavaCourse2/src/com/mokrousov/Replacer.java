package com.mokrousov;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Replacer implements Callable<List<String>> {
  private File dir;
  private ExecutorService pool;

  public Replacer(File dir, ExecutorService pool) {
    this.dir = dir;
    this.pool = pool;
  }

  public Replacer(File dir, int nThreads) {
    this.dir = dir;
    this.pool = Executors.newFixedThreadPool(nThreads);
  }

  @Override
  public List<String> call() throws Exception {
    List<String> processed = new ArrayList<>();

    try {
      File[] files = dir.listFiles();
      List<Future<List<String>>> result = new ArrayList<>();

      for (File f : files) {
        if (f.isDirectory()) {
          Replacer replacer = new Replacer(f, pool);
          Future<List<String>> task = pool.submit(replacer);
          result.add(task);
        } else if (f.getName().endsWith(".java") && Processor.process(f)) {
          processed.add(f.getAbsolutePath());
        }
      }

      for (Future<List<String>> future : result)
        processed.addAll(future.get());
    } catch (ExecutionException | InterruptedException e) {
      e.printStackTrace();
    }

    return processed;
  }

  public Future<List<String>> submit() {
    return pool.submit(this);
  }

  public void finish() {
    pool.shutdown();
  }
}
