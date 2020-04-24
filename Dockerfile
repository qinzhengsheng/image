FROM java:8
MAINTAINER "Dereck"<535305131@qq.com>
VOLUME /temp
EXPOSE 8888
ADD image.jar image.jar
CMD java -jar image.jar