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
![postman1](https://github.com/user-attachments/assets/c8843141-da98-4b69-a6c2-7dd2685def3f)
![postman2](https://github.com/user-attachments/assets/8633136e-3757-43c3-bd3d-5d5067c6240c)
![postman3](https://github.com/user-attachments/assets/41ec7b77-e715-406f-9541-c541f21e770a)
![postman4](https://github.com/user-attachments/assets/a7acc056-b7c1-4749-8d29-5eea170820d4)
![postman5](https://github.com/user-attachments/assets/7d00b6f1-b287-465e-8f5d-4fa7bdfe259a)
![postman6](https://github.com/user-attachments/assets/0a0994df-bc83-4ad9-a29e-51c8cefecb87)
![postman7](https://github.com/user-attachments/assets/b3b967e8-0f06-4681-ac2a-e108a58f42e2)
![postman8](https://github.com/user-attachments/assets/e8cc62b8-f347-4e66-9ecc-dce51a8ad1f8)
