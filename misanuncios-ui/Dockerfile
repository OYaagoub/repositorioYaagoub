# first stage of building angular image
FROM node:apine3.19 as build
RUN mkdir -p /app

WORKDIR /app

COPY package.json /app/
RUN npm install

COPY . /app/

RUN npm run build --prod

FROM nginx:apine

COPY --from=build /app/dist/misanuncios-ui /usr/share/nginx/html






















