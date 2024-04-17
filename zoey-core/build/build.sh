#!/bin/bash
# 当前项目镜像打包后上传的位置，jenkins中的配置目录，具体查看Jenkins项目配置构建后操作Remote directory
cd /home/zoey/docker/jenkins/project/music-boot/zoey-core/build/
# 定义变量
IMAGE_NAME=zoey-music-boot:1.0.0
CONTAINER_NAME=zoey-music-boot

# 判断容器是否存在，若存在则停止并移除
if [ $(docker ps -a -q -f name=$CONTAINER_NAME) ]; then
    echo "Stopping and removing $CONTAINER_NAME container..."
    docker stop $CONTAINER_NAME
    docker rm $CONTAINER_NAME
fi

# 判断镜像是否存在，若存在则移除
if [ $(docker images -q $IMAGE_NAME) ]; then
    echo "Removing old $IMAGE_NAME image..."
    docker rmi $IMAGE_NAME
fi

# 构建镜像
echo "Building new $IMAGE_NAME image..."
docker build --no-cache -t $IMAGE_NAME .

BUILD_ID=dontKillMe
# 启动容器
echo "Starting $CONTAINER_NAME container..."
docker run --restart=always --network zoey-network -v ./logs:/logs -v /etc/localtime:/etc/localtime -d --name $CONTAINER_NAME -p 9090:9090 $IMAGE_NAME

# 判断容器是否成功启动
if [ $(docker ps -q -f name=$CONTAINER_NAME) ]; then
    echo $CONTAINER_NAME "myapp service is running"
    docker logs -f $CONTAINER_NAME
else
    echo $CONTAINER_NAME "myapp service failed to start"
fi