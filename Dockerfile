FROM amazoncorretto:21

# JAR 파일을 컨테이너로 복사
ARG JAR_FILE=ZiGee-Api/build/libs/*.jar
COPY ${JAR_FILE} app.jar

# 애플리케이션 실행
ENTRYPOINT ["java","-jar","/app.jar"]