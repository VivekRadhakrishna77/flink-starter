package com.vivekrad;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class App {
    public static void main(String[] args) throws Exception {
        // Set up the execution environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // Create a DataStream from a simple collection
        DataStream<String> text = env.fromElements(
            "Apache Flink",
            "is",
            "a",
            "framework",
            "and",
            "distributed",
            "processing",
            "engine"
        );

        // Apply a simple transformation
        DataStream<String> upperCaseText = text.map(new MapFunction<String, String>() {
            @Override
            public String map(String value) {
                return value.toUpperCase();
            }
        });

        // Print the result to the console
        upperCaseText.print();

        // Execute the program
        env.execute("Flink Starter Job");
    }
}
