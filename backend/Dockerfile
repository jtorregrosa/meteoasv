FROM openjdk:11.0.13-slim-buster as build

SHELL ["/bin/bash", "-o", "pipefail", "-c"]
USER root

COPY . /source

RUN cd /source && ./mvnw -DfinalName="app" -P api-docs,prod clean package

FROM openjdk:11.0.13-jre-slim-buster

ENV APPLICATION_SLEEP 0

COPY --from=build /source/api/target/app.jar /app/app.jar
COPY docker-entrypoint.sh /app/docker-entrypoint.sh

EXPOSE 8080

ENTRYPOINT [ "/app/docker-entrypoint.sh"]

# Define labels at end to avoid rebuilding image when they change.
ARG LABEL_BUILD_CREATED="n/a"
ARG LABEL_IMAGE_VERSION="n/a"
ARG LABEL_REVISION="n/a"

LABEL org.opencontainers.image.authors='J. Torregrosa <jtorregrosa@nouss.eu>'
LABEL org.opencontainers.image.url='https://noussintelligence.com'
LABEL org.opencontainers.image.documentation='https://nouss.visualstudio.com/nouss-team-cloud/_git/nouss-docker-services?path=/ionic-build-base/README.md'
LABEL org.opencontainers.image.source='https://nouss.visualstudio.com/nouss-team-cloud/_git/nouss-docker-services'
LABEL org.opencontainers.image.vendor='Nouss Intelligence S.L.'
LABEL org.opencontainers.image.licenses='SEE LICENSE IN /LICENSE.MD'
LABEL org.opencontainers.image.created=$LABEL_BUILD_CREATED
LABEL org.opencontainers.image.version=$LABEL_IMAGE_VERSION
LABEL org.opencontainers.image.revision=$LABEL_REVISION
LABEL org.opencontainers.image.title='IonicAndroidBuilder base image'
LABEL org.opencontainers.image.description='This image base contains all required tools and dependencies to build & sign android artifacts'
