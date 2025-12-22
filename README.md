총 세가지 파일이 있습니다.

## 파일 구성

movie-react : front-end

tutorial : inteliji에서 가동시킬 back-end

db_movie : mysql에서 작동시킬 db파일
  - 이 파일을 쓰기위해서는 우선 mysql brench를 설치해야힘 세가지 파일이 있습니다.

갑작스럽게 적용한거라 파일이름이 중구난방인점 유의해 주세요.


## 각각의 파일 설명

movie-react : front-end
  - 파일 내부에 readme.md 있음. 파일 구조 설명 및 사용 npm dependency 개제

    
tutorial : inteliji에서 가동시킬 back-end
  - 프로젝트 생성당시 https://start.spring.io/ 를 사용함. 현재는 프로젝트 자체가 생성됐으므로, 실행만 하면 됨.
  - application.properties에서 db연결을 해야함. 위치 src/main/java/project~~~~~/resource/application.properties
  - 프로젝트의 기본설정은 build.grade에서 함. 파일 켰을때 아래쪽에 코끼리 아이콘 ㄱㄱ


db_movie : mysql에서 작동시킬 db파일
  - 이 파일을 쓰기위해서는 우선 mysql brench를 설치해야함.
  - https://dev.mysql.com/downloads/installer/ 여기서 하면 될듯. 버전은 최소 8.0이상. 본인 운영체제 맞춰서 다운
