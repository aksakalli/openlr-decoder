FROM openjdk:8-jdk-alpine as build
WORKDIR /workspace/app

COPY .mvn .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src src
RUN ./mvnw install -DskipTests

RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:8-jre-alpine

ARG DEPENDENCY=/workspace/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

VOLUME /tmp
EXPOSE 8080

ENTRYPOINT ["java","-cp","app:app/lib/*","org.openlr.openlrdecoder.OpenlrDecoderApplication"]