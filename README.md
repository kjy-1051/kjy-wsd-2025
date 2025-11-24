# 웹서비스설계 실습2

Spring Boot를 사용하여 REST API를 구현한 과제입니다.
GET / POST / PUT / DELETE API를 각각 2개씩 구현하였습니다.
또한 Interceptor를 활용한 Middleware(요청 로그 출력) 기능을 구현하였습니다.

## Tech Stack(기술 스택)
- Java 23
- Spring Boot 4.0
- Postman (API 테스트)

## Package Structure(패키지 구조)

kr.ac.jbnu.kjy > api > dto , request , v1 , config

## API List(API 리스트)

### GET
- GET /api/v1/items : 전체 조회
- GET /api/v1/items/{id} : 단건 조회

### POST
- POST /api/v1/items : 아이템 생성
- POST /api/v1/items/with-header : 헤더 포함 요청 테스트

### PUT
- PUT /api/v1/items/{id} : 부분/전체 수정
- PUT /api/v1/items/{id}/price?price=1234 : 가격만 수정

### DELETE
- DELETE /api/v1/items/{id} : 단건 삭제
- DELETE /api/v1/items : 전체 삭제

## How to Run(실행 방법)

1. IntelliJ에서 DemoApplication 실행
2. 서버 `http://localhost:8080` 에서 실행됨
3. Postman을 통해 테스트

ex) GET http://localhost:8080/api/v1/items

## Middleware (Interceptor)

모든 요청이 들어올 때마다 로그를 출력합니다.

[REQ] GET /api/v1/items
[REQ] POST /api/v1/items

## Postman Test Results

![postman1](https://github.com/user-attachments/assets/ee0e9697-a4e0-45ad-b1fc-a5250c46d447)
![postman2](https://github.com/user-attachments/assets/8c43eae0-073d-4203-ab3f-81bd0cebf8e3)
![postman3](https://github.com/user-attachments/assets/418cb7bc-db78-45f9-8274-9b0f462acdbc)
![postman4](https://github.com/user-attachments/assets/85b730c8-a420-47e8-99e4-8be043de4e7a)
![postman5](https://github.com/user-attachments/assets/05dcf66b-26ae-4750-8048-c224312d09c3)
![postman6](https://github.com/user-attachments/assets/abc1f1f6-384a-4e66-b017-b6550ad4ea45)
![postman7](https://github.com/user-attachments/assets/df812288-fe9b-437d-a7e6-3a4b41f93ae9)
