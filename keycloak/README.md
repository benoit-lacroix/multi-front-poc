# Local Keycloak

For starting Keycloak, juste run the following command:

```bash
docker-compose -f docker-compose.yml up
```

Then log to Keycloak server:
- Url: http://localhost:8090/
- Login: `admin`
- Password: `admin`

Follow the instructions:
- Create a new realm named: `multi-front-poc`
- Create a demo user: `demo`/`demo`
- Create two clients:
  - Read Front:
    - Id: `read-front`
    - Client Protocol: `openid-connect`
  - Write Front:
      - Id: `read-front`
      - Client Protocol: `openid-connect`
- Edit both clients and set/check the following information:
  - Access Type: `public`
  - Valid Redirect URIs: `*`
