FROM springci/graalvm-ce:java17-0.12.x

ENV DEBIAN_FRONTEND=noninteractive
ENV WORK_DIR=/opt/inventory-service
ENV JAR_FILENAME=inventory-service-0.0.1-SNAPSHOT.jar

WORKDIR ${WORK_DIR}

LABEL org.opencontainers.image.authors="lifezqy@126.com"

ADD target/${JAR_FILENAME} ${WORK_DIR}/

EXPOSE 9020

CMD java -jar ${WORK_DIR}/${JAR_FILENAME}


# docker build --progress tty -t lifezqy/inventory-service:v1 .
