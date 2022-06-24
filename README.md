# CHAT API

## Base url
```
https://aej-d1t1.herokuapp.com/aej/2/
```

## Swagger-ui
```
https://aej-d1t1.herokuapp.com/aej/2/swagger-ui/index.html
```

## Table Endpoints
### User

| Name         | Endpoint                                                    | Method | Bearer token | Body and response               |
|--------------|-------------------------------------------------------------|--------|--------------|---------------------------------|
| Create User  | `/user`                                                     | `POST` | no           | [example](#user---create-user)  |
| Update User  | `/user/{id}`                                                | `PUT`  | no           | [example](#user---update-user)  |
| Get All User | `/user`                                                     | `GET`  | no           | [example](#user---get-all-user) |

### Chat
| Name              | Endpoint     | Method | Bearer token | Body and response                    |
|-------------------|--------------|--------|--------------|--------------------------------------|
| Create Chat Room  | `/chat`      | `POST` | no           | [example](#chat---create-chat-room)  |
| Get All Chat Room | `/chat`      | `GET`  | no           | [example](#chat---get-all-room-chat) |
| Insert Chat       | `/chat/{id}` | `PUT`  | no           | [example](#chat---insert-chat)       |

## User Examples
### User - Create User
```
POST /user
```

Body
```json
{
  "name": "string",
  "username": "string",
  "password": "string",
  "friendList": [
    "string"
  ],
  "descriptionProfile": "string"
}
```

Response
```json
{
  "code": "string",
  "message": "string",
  "data": {
    "id": "string",
    "name": "string",
    "username": "string",
    "password": "string",
    "friendList": [
      "string"
    ],
    "descriptionProfile": "string"
  }
}
```

### User - Get All User
```
GET /user
```

Response
```json
{
  "code": "string",
  "message": "string",
  "data": [
    {
      "id": "string",
      "name": "string",
      "username": "string",
      "password": "string",
      "friendList": [
        "string"
      ],
      "descriptionProfile": "string"
    }
  ]
}
```

### User - Update User
```
PUT /user/{id}
```

Body
```json
{
  "name": "string",
  "username": "string",
  "password": "string",
  "friendList": [
    "string"
  ],
  "descriptionProfile": "string"
}
```

Response
```json
{
  "code": "string",
  "message": "string",
  "data": {
    "id": "string",
    "name": "string",
    "username": "string",
    "password": "string",
    "friendList": [
      "string"
    ],
    "descriptionProfile": "string"
  }
}
```

## Chat Example
### Chat - Create Chat Room
```aidl
POST /transaksi
```

Body
```json
{
  "userId": [
    "string"
  ],
  "chat": [
    {
      "id": "string",
      "userId": "string",
      "chatValue": "string"
    }
  ]
}
```

Request
```json
{
  "code": "string",
  "message": "string",
  "data": {
    "id": "string",
    "userId": [
      "string"
    ],
    "chat": [
      {
        "id": "string",
        "userId": "string",
        "chatValue": "string"
      }
    ]
  }
}
```

### Chat - Get All Room Chat
```
GET /chat
```

Request
```json
{
  "code": "string",
  "message": "string",
  "data": [
    {
      "id": "string",
      "userId": [
        "string"
      ],
      "chat": [
        {
          "id": "string",
          "userId": "string",
          "chatValue": "string"
        }
      ]
    }
  ]
}
```

### Chat - Insert Chat
```
PUT /chat
```

Body
```json
{
  "userId": [
    "string"
  ],
  "chat": [
    {
      "id": "string",
      "userId": "string",
      "chatValue": "string"
    }
  ]
}
```

Request
```json
{
  "code": "string",
  "message": "string",
  "data": {
    "id": "string",
    "userId": [
      "string"
    ],
    "chat": [
      {
        "id": "string",
        "userId": "string",
        "chatValue": "string"
      }
    ]
  }
}
```