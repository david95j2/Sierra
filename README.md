# SIERRA REST API
- 드론 및 딥러닝 데이터 처리를 위한 초기 작업
- 구조 및 리팩토링은 다음 버전에서 진행하며, 여기서는 맛보기

---
### 📒 To do List
#### This Week
- [ ] ExceptionHandler
- [ ] UserController
- [ ] 
#### Next Week
- [ ] ViewPage with React
#### Done
- [x] Folder
- [x] Init Project
---
### 🔧 Project structure
- main/java/pacakage
  - Config
    - SwaggerConfig
  - ExceptionHandler
    - BaseException
    - BaseResponse
    - BaseResponseStatus (enum)
  - User
    - model
      - UserEntity
      - SignupUserReq
      - SignupUserRes
      - LoginUserReq
      - LoginUserRes
    - UserController
    - UserRepository
    - UserService
  - Utils
---
### ❗ Error List
#### DataBase
> **Q. java.sql.SQLSyntaxErrorException: (conn=602) Table 'DB이름.hibernate_sequence' doesn't exist**
>
>   Entity의 PK를 @GeneratedValue(strategy = GenerationType.AUTO)로 설정할 때 발생한 문제.
>   hibernate_sequence라는 테이블에서 PK를 조회하는데 해당 테이블이 존재하지 않아서 발생.
> 
> **A. Entity에 primary key에다가 추가**
>   ```java
>   @Id
>   @GeneratedValue(strategy = GenerationType.IDENTITY)
>   private int id;
>   ```
---
> **Q. Incorrect datetime value: '2020-01-01 09:54' for column '데이터베이스명'.'temp'.'Date' at row 1**
> 
> **A. mysql 기준 형식인 yyyy-mm-dd h:mm:ss 으로 변경**
