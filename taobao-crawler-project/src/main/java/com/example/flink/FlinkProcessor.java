package com.example.flink;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class FlinkProcessor {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<String> input = env.socketTextStream("hadoop01", 9999);
        DataStream<String> result = input.filter(line -> line != null && !line.isEmpty());
        result.print();
        env.execute("Flink Processor");
    }
}
