package com.example;

import com.example.crawler.ZhiwangCrawler;
import com.example.flink.FlinkProcessor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            Crawler crawler = new Crawler();
            crawler.startCrawling();
        });
        executorService.submit(() -> {
            try {
                FlinkProcessor.main(args);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
