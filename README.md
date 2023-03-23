# HSJ-PetClinic-Study

- Commit 규칙
    - 기능 별로 개발을 하고 커밋을 한다.
    - 푸쉬 하나당 branch 하나
    - commit 메세지: {type} : 기능
    - **type**
        - Feat : 기능 추가 첫 커밋
        - Fix : 장애/에러 수정
        - Docs : 문서 수정에 대한 커밋
        - Style : 코드 스타일 혹은 포맷 등에 관한 커밋
        - Refactor : 코드 리팩토링에 대한 커밋
    - Ex : User Table 개발 CRUD
        - userBranch → Push
            1. commit : create user service
            2. commit : update user service
            3. commit : delete user service
            4. commit : get user service

- Pull Request 규칙
    - PR 제목: {본인 깃 허브 이름} : {추가한 기능}
    - PR comment : 왜 이렇게 구현했는지, 어떤 기술을 사용했는지, 이 기술이 무엇인지 등 자세히 작성
