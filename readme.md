The API provides a platform to perform arithmetic calculations (addition, subtraction, multiplication, division, square root, and random string generation), and each functionality has a separate cost per request.

The API is designed to interact with a user's balance, and each request made to the API deducts the user's account balance. If the user's balance is not enough to cover the request cost, the request will be denied.

Repositoy:

[https://github.com/nvalfre/aritmetical-calculator-api](https://github.com/nvalfre/aritmetical-calculator-api)

Docker image: `nvalfre/aritmetical-calculator-api`

## Guide and curls examples for AWS:

### Login

```jsx
curl --location --request POST '[http://100.25.130.184:8080/login](http://100.25.130.184:8080/login)' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "nv",
"password": 4000
}'
```

```jsx
response:
{
    "id": null,
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJudiIsImV4cCI6MTY3ODc0MTk5NSwiaWF0IjoxNjc4NzA1OTk1fQ.rYc3GPOdhYDnE9IpBBpmfbCNjODjnyU2gNP4V6sEguI",
    "name": "nv",
    "active": true
}
```

### Calculator

```jsx
curl --location --request POST 'http://100.25.130.184:8080/api/calculator/nv' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJudiIsImV4cCI6MTY3ODc0MTk5NSwiaWF0IjoxNjc4NzA1OTk1fQ.rYc3GPOdhYDnE9IpBBpmfbCNjODjnyU2gNP4V6sEguI' \
--data-raw '{
    "operator1": 33.33,
    "operator2": 33.33,
    "length": 10,
    "operationType": "ADDITION"
}'
```


```jsx
response:
{
    "result": 66.66
}
```

#### OperationType
    - ADDITION,
    - SUBTRACTION,
    - MULTIPLICATION,
    - DIVISION,
    - SQUARE_ROOT,
    - RANDOM_STRING
### Records

```jsx
curl --location --request GET 'http://100.25.130.184:8080/api/calculator/nv/records' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJudiIsImV4cCI6MTY3ODc0MTk5NSwiaWF0IjoxNjc4NzA1OTk1fQ.rYc3GPOdhYDnE9IpBBpmfbCNjODjnyU2gNP4V6sEguI'
```

```jsx
response:
[
    {
        "id": "3548a471-7764-43c4-bd16-754baf0d7648",
        "operation": {
            "id": 6,
            "type": "RANDOM_STRING",
            "cost": 6.00
        },
        "userId": "1",
        "amount": 6.00,
        "userBalance": 10000.00
    },
    {
        "id": "bdf3ffae-9228-40cc-8e01-1c46fb97836c",
        "operation": {
            "id": 1,
            "type": "ADDITION",
            "cost": 1.00
        },
        "userId": "1",
        "amount": 1.00,
        "userBalance": 9994.00
    }
]
```

### Balance

```jsx
curl --location --request GET 'http://100.25.130.184:8080/api/calculator/nv/balance' \
--header 'Content-Type: application/json' \
	--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJudiIsImV4cCI6MTY3ODc0MTk5NSwiaWF0IjoxNjc4NzA1OTk1fQ.rYc3GPOdhYDnE9IpBBpmfbCNjODjnyU2gNP4V6sEguI'
```

```jsx
{
    "balance": 9993.0
}
```

Notes:

- Be aware that the current token used on curls will expire after a certain period of time. If this happens, you will need to refresh the token by calling the login endpoint again.


### Dockerfile commands

```jsx
docker build -t <image_name> .
docker tag <image_name> <tag_hub>/<image_name_tag>:<version>
docker push <image_name_tag>:<version>
docker run -d --name <container_name> -p 8080:8080 <image_name_tag>:<version>
```
```jsx
docker build -t aritmetical-calculator-api .
docker tag aritmetical-calculator-api nvalfre/aritmetical-calculator-api:latest
docker push nvalfre/aritmetical-calculator-api:latest
docker run -d --name nv -p 8080:8080 nvalfre/aritmetical-calculator-api:latest
```

### Deploy
```jsx
docker images
docker ps

docker stop <instance>
docker ps

docker rm <container_name>
docker images
docker ps

docker pull <image_name_tag>:<version>
docker run -d --name <container_name> -p 8080:8080 <image_name_tag>:<version>
```
