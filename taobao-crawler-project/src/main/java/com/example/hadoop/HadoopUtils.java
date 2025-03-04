package com.example.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

public class HadoopUtils {
    public static void writeToHDFS(String data, String filePath) throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://localhost:9000");
        FileSystem fs = FileSystem.get(conf);
        Path path = new Path(filePath);
        org.apache.hadoop.fs.FSDataOutputStream outputStream = fs.create(path);
        outputStream.write(data.getBytes());
        outputStream.close();
        fs.close();
    }
}
