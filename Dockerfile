FROM openjdk:17-oracle as Build

COPY . .

RUN ./gradlew --no-daemon shadowJar

LABEL org.opencontainers.image.source=https://github.com/m2en/citation

CMD ["java", "-jar", "build/libs/citation.jar"]
