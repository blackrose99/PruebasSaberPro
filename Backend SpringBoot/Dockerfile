FROM openjdk:17
VOLUME /tmp
EXPOSE 8082
ADD ./target/pruebaSaberPro_Castano-1 app.jar
ENTRYPOINT ["java","-jar","/app.jar"]