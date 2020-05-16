FROM openjdk:8-jre-alpine

ENV APP_FILE app.jar
ENV APP_HOME /usr/apps
ENV DATABASE_NAME ambassadorsaas
ENV DATABASE_PORT 3306
ENV DATABASE_HOST mysql
ENV DATABASE_USER root

EXPOSE 8080
COPY target/*.jar $APP_HOME/$APP_FILE
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar -Dspring.profiles.active=dev -Djasypt.encryptor.password=KEYOAUTH2 $APP_FILE"]