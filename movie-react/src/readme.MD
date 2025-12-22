## 파일 계층구조

src를 눌러보면 폴더가 크게 api, assets, components, pages, 외부파일 index.js,router.js 이럴게 있음

## 파일,폴더들 설명

1. api : 서버(벡인드)와의 연결 url 유지보수를 용이하게 하기위해 따로 모아둠.
2. assets : 각종 css 파일 혹은 default 이미지, 공용적으로 사용되는 자질구레한것들 모아둔는 곳
3. components : 페이지가 로딩될때, 페이지 안에서 작동하는 자잘한 구성요소들.
4. page : 실제 외부 도메인을 통한 url를 각각 독자적으로 설정되어있음. 예: service/view 이면 view하는 page가 존재하고. 그 view를 구성하는 하위 components들이 존재.
5. index.js react의 심장. react의 모든 요소는 이 index.js에서 시작됨.
6. router.js : 프론트상의 각종 url 설정

## npm 깔아야하는거

프로젝트 들어와서 내부 terminal키고,
npm i react-router-dom, styled-components, axios 세가지가 필요한것

- 다만 해당 파일은 이미 완성본이므로, 기존에 설치된 dependency는 재설치 필요가 없으므로 그냥 npm i 만 깔면, 해당 프로젝트를 기존에 베포한 사람의 설정들이 자동으로 따라와질것. 단, 뭔가 추가한다면, 그떄부터는 npm i 너가 필요한것 따로 추가 필요.

## local 프로젝트 시작하기

terminal에 npm stat치면됨.
