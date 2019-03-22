FROM node:8.11.2-alpine as node

RUN npm install
COPY . .
FROM node
RUN npm install http-server -g
CMD ["http-server","-p","8030", "dist/AngularJwtAuth","-S","--cert","ssl/cert.pem","--key","ssl/key.pem"]

