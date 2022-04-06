FROM java
ARG ARTIFACT_NAME=redis-counter-service-0.0.1-SNAPSHOT.jar
ENV ARTIFACT_NAME=${ARTIFACT_NAME}
COPY target/${ARTIFACT_NAME} /app/
CMD java -jar /app/${ARTIFACT_NAME}