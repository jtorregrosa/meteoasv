FROM nginx:1.21.0-alpine AS base
WORKDIR /app
EXPOSE 80
EXPOSE 443

FROM node:14-alpine AS build
WORKDIR /app

# IMAGE - Install build system dependencies.
ENV BUILD_DEPS="gettext"
RUN set -x && \
    apk add --virtual build_deps $BUILD_DEPS &&  \
    cp /usr/bin/envsubst /usr/local/bin/envsubst && \
    apk del build_deps

# IMAGE - Required build arguments.
ARG NPM_BUILD_COMMAND=prod

# NPM - Install dependencies.
COPY package*.json /app/
RUN npm ci

# NPM - Build.
COPY . /app
RUN npm run build:${NPM_BUILD_COMMAND}

FROM base AS final
COPY --from=build /app/dist/ /usr/share/nginx/html
COPY /nginx-custom.conf /etc/nginx/conf.d/default.conf

CMD ["/bin/sh",  "-c",  "envsubst < /usr/share/nginx/html/assets/env.template.js > /usr/share/nginx/html/assets/env.js && exec nginx -g 'daemon off;'"]
