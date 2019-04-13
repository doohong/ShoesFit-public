# 신발사이즈 추천 서비스 [ShoesFit](https://www.shoesfit.cf) [![Build Status](https://travis-ci.com/doohong/shoesfit.svg?token=JxNjuc3tcKVrStfgbLYF&branch=master)](https://travis-ci.com/doohong/shoesfit)
---
## 설명

ShoesFit은 집단지성을 이용한 신발 사이즈 추천 서비스 입니다.

자신이 가지고 있는 두개의 신발을 이용하여 원하는 신발의 브랜드와 이름을 입력하면 다른사람들의 입력한 정보를 토대로 신발사이즈를 추천해줍니다.

입력한 두개의 신발은 연관 관계를 만들어 저장함으로 다른사람들의 검색의 도움을 주는 정보가 됩니다.

---

## 기술 설명

Spring Boot를 이용하여 신발 추천 알고리즘 및 API를 개발하였습니다.

MyBatis 대신 JPA를 사용하였습니다.

JavaScript와 jQuery를 이용하여 자동완성 기능을 만들었으며 Ajax를 이용하여 API를 호출하여 사용하였습니다.

Travis CI를 이용하여 자동 빌드와 CodeDeploy를 이용한 자동 빌드, Nginx를 이용한 무중단 배포까지 하였습니다.

![무중단배포](https://t1.daumcdn.net/cfile/tistory/996F763D5A73F91E26)

freenom에서 무료 도메인을 받아 aws 네임서버를 이용하여 도메인 연결을 하였습니다.

let'sencrypt의 certbot을 이용하여 빠르게 ssl을 적용하였습니다.

---

### 기술 요약
- SpringBoot
- JavaScript
- jQuery
- JPA
- AWS EC2(Amazon Linux)
- AWS RDS(Maria DB)
- AWS CodeDeploy
- AWS S3
- AWS Rout 53
- Travis CI
- Nginx
- certbot

---

## 사용방법

1. 가지고 있는 신발 두개의 브랜드와 이름 사이즈를 입력하세요.
2. 사이즈를 알고 싶은 신발의 브랜드와 이름을 입력하세요.
3. 두신발 검색 버튼을 눌러서 검색해주세요.

---

### 주의사항

- 브랜드와 이름이 같은 신발은 입력하실 수 없습니다. 
- 찾으시는 신발이 자동완성에 있으면 자동완성에 있는 단어를 입력해주세요. ex)에어맥스가 자동완성 리스트에 있으면 airmax(X) 에어맥스(O)
 
