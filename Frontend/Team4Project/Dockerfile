# This is run before building the docker image
# npm ci && npm run build


FROM nginx:alpine
COPY nginx.conf /etc/nginx/conf.d/nginx.conf
COPY /dist/Team4Project /usr/share/nginx/html
RUN rm /etc/nginx/conf.d/default.conf
EXPOSE 80