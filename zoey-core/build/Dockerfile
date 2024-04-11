# 使用官方 OpenJDK 17 映像作为基础镜像
FROM openjdk:21-jdk

# 将当前目录下的 jar 包复制到容器中的 /app 目录下
COPY ./zoey-core-1.0.0.jar ./java/music-boot.jar

# 设置容器启动时执行的命令
CMD ["java", "-jar", "./java/music-boot.jar"]