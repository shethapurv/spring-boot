FROM java
ARG ARTIFACT_NAME=graphql-netflix-dgs-example-1.0-SNAPSHOT.jar
ENV ARTIFACT_NAME=${ARTIFACT_NAME}
RUN mkdir /app
COPY target/${ARTIFACT_NAME} /app/
CMD java -jar /app/${ARTIFACT_NAME}