# Multi-Front SSO Secured POC

This project is a demo of how to secure two front-end application, and a back-end one, using both SSO and api-key
concepts.

It is composed of:
- A standalone back-end server:
  - Running an embedded H2 database populated with liquibase
  - Exposing endpoints for reading, adding, deleting data from the database
  - Endpoints are secured with an api-key
- A read-front-end application:
  - Exposing a web page (Thymeleaf) for reading database data
  - Secured with OpenId Connect (Keycloak)
- A write-front-end application:
  - Exposing forms (Thymeleaf) for adding/removing data from database
  - Secured with OpenId Connect (Keycloak)
