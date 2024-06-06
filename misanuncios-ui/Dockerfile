# FROM node:18-alpine as build
# WORKDIR /app/src
# COPY package*.json ./
# RUN npm ci
# COPY . ./
# RUN npm run build

# FROM node:18-alpine
# WORKDIR /usr/app
# COPY --from=build /app/src/dist/misanuncios-ui/server ./
# CMD node server.mjs
# EXPOSE 4000

# FROM node:18-alpine as build
# WORKDIR /app/src
# COPY package*.json ./
# RUN npm ci
# COPY . ./
# RUN npm run build

# FROM nginx:1.23
# RUN rm /etc/nginx/conf.d/default.conf
# COPY nginx.conf /etc/nginx/conf.d
# COPY --from=build /app/src/dist/misanuncios-ui /var/www/html
# RUN chmod -R 755 /var/www/html
# RUN chown -R nginx:nginx /var/www/html

# EXPOSE 80
# CMD ["nginx", "-g", "daemon off;"]



FROM node:alpine

WORKDIR /usr/src/app

COPY . /usr/src/app

RUN npm install -g @angular/cli

RUN npm install

CMD ["ng", "serve", "--host", "0.0.0.0"]
