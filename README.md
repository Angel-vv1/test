## 项目简介
本项目是一个基于Flink分布式爬虫系统，用于爬取淘宝商品信息。

## 环境要求
- Java 8
- Flink 1.18.1
- Redis 6.2.3
- Hadoop 3.4.1

## 项目结构
- `src/main/java`：主要的 Java 代码
- `src/main/resources`：配置文件
- `src/test/java`：单元测试代码
- `src/test/resources`：测试配置文件
- `pom.xml`：Maven 依赖管理文件

## 使用方法
1. 确保 Redis、Hadoop 和 Flink 服务已启动。
2. 运行 `App.java` 启动爬虫和 Flink 处理程序。
3. 爬取的数据将通过 Flink 处理并输出。

## 注意事项
- 淘宝有严格的反爬机制，请遵守相关规则。
- 可根据实际情况调整配置文件。
