
![루바토 로고](https://user-images.githubusercontent.com/119032800/227819064-d907985d-99e1-4f50-b601-2823bbb40f85.png )
# RUBATO : 취미로 가볍게 시작하는 음악 레슨 매칭 서비스
</br>

## ❤ 프로젝트 목적

음악을 취미로 배우기에는 비용과 시간에 대한 부담이 크다.
음악 레슨을 하기 위해서는 소속되어야 하는 등 제약사항이 많다.

음악을 배우고 싶은데 비용 및 시간이 부담되는 사람들과
음악을 가르치고 싶은 프리랜서들을 위한 매칭 서비스 기획

## 🧡 개발 기간

2023.02.27 ~ 2023.03.24

## 💛 팀 소개
다장조 : 으뜸음이 <다>인 장조를 이르는말.
</br>
밝고 즐거운 다장조를 만들어가는 팀
</br>
모든게 다 장점이 되는 조 ♬

## 💚 팀원 및 역할분담
<img width="507" alt="image" src="https://user-images.githubusercontent.com/119032800/227824883-1c1ea95b-b8de-4800-8c98-95fa8ef645fc.png">


## 💙 주요 기능
### 회원관리
기능명 | 상세
-------|-----
회원가입| ‘아이디’, ‘비밀번호’, ‘이름’, ‘닉네임’, ‘이메일’, ‘핸드폰 번호’, ‘주소’ 총 7가지 정보를 입력하여 회원가입을 할 수 있으며, 회원가입 시 이메일 인증을 통하여 본인 이메일임을 인증해야 가입할 수 있고, 이메일은 추후에 변경할 수 없도록 한다. 이때 아이디, 닉네임, 이메일, 핸드폰번호는 중복될 수 없다.
마이페이지|자유게시판에  내가 쓴 글, 댓글, 레슨 게시판에 레슨 등록, 신청내역, 마켓 게시판에 판매 내역, 구매 내역을 볼 수 있다. 또한, 정보 수정, 탈퇴를 할 수 있다. 수정시 패스워드, 닉네임, 주소만 수정이 가능하다.
로그인|회원가입 시 입력한 정보와 아이디, 비밀번호가 일치하면 로그인이 가능하다, 아이찾기를 누른 후 이름과 이메일을 입력하면 아이디를 찾을 수 있다, 비밀번호는 아이디와 이메일을 입력하면 가능하다.

### 레슨게시판
기능명 | 상세
-------|-----
레슨 생성|로그인 한 회원에 한하여 '레슨이름', '레슨지역', '희망금액', '유효일정', '한줄소개', '상세소개' 총 6가지 정보를 입력하여 레슨글을 작성할 수 있다. 내가 작성한 레슨과 레슨 별로 받은 신청을 목록으로 확인할 수 있으며 상세조회를 통해 정보를 수정, 삭제 할 수 있다. 받은 신청 목록에서 '수락하기' 버튼을 클릭하면 해당 신청 회원에게 이메일을 보낼 수 있다.
레슨 신청| 레슨 상세보기 화면에서 로그인한 회원에 한하여 '희망금액', '희망일정', '요청사항' 총 3가지 정보를 입력하여 레슨 신청을 할 수 있다. 레슨 당 한번만 신청할 수 있으며 내가 한 신청을 목록으로 확인할 수 있다. 각 신청의 상세보기를 통해 수정, 삭제가 가능하다. 

### 자유게시판
기능명 | 상세
-------|-----
글 목록 조회| 게시판 목록 페이지에서 볼 수 있으며 비로그인, 로그인 상관없이 모두 이용가능하다.
글 작성| 로그인 상태에서만 이용가능. ‘글분류’,‘글제목’,‘글본문’을 작성 후 등록할 수 있다.
글 수정,삭제| 로그인상태에서 본인이 작성한 글에 대해서만 가능하다. 글 수정의 경우 글분류, 글제목, 글본문을 변경할 수 있다. 수정, 삭제 버튼은 당사자에게만 노출되고 있다.
댓글 목록 조회| 글 상세 페이지에서 글 본문과 함께 볼 수 있다. 게시글에 마다 각 본문에 해당하는 댓글을 화면 하단에서 목록으로 조회 가능하다.
댓글 삭제| 로그인 상태에서 본인이 작성한 댓글만 삭제가 가능하다. 삭제버튼은 당사자에게만 노출된다.
검색| 자유게시판 목록 하단에서 ‘제목+내용’, ‘제목’, ‘내용’, ‘작성자’를 선택하여 키워드로 검색한 후 목록으로 조회 가능하다. 로그인/비로그인 모두 이용 가능하다.

### 마켓게시판
기능명 | 상세
-------|-----
판매글 작성| 다중파일 업로드를 통해 판매글에 관한 이미지 파일을 최대 3장까지 첨부하여 지역, 상태 등 조건을 설정하여 판매글을 등록할 수 있다.
판매글 목록 조회| 업로드된 판매글을 목록으로 보여주며, 게시물의 첫 번째 이미지를 썸네일로 가져와서 사용자에게 보다 접근성있는 서비스를 제공한다.
판글 상세 조회| 판매글에 대한 정보 및 판매자에 대한 정보와 댓글을 보여준다. 구매하기 버튼을 통해 해당 제품을 구매할 수 있으며, 판매완료된 제품은 구매하기가 불가능하다.
구매하기| 제품정보와 구매자의 개인정보를 불러와서 결제API를 통해 제품을 구매할 수 있도록 한다.
댓글 작성| 판매글에 회원이라면 누구나 댓글을 작성할 수 있으며, 판매글 작성자가 댓글을 작성할 시 작성자인지 구분해주도록 한다.
댓글 수정| 자신의 댓글만 수정할 수 있다.
댓글 삭제| 자신의 댓글만 삭제할 수 있다.

### 채팅기능
기능명 | 상세
-------|-----
채팅방 목록| 채팅 이력이 있는 회원의 닉네임이 채팅방 목록으로 보이며, 최근 순으로 정렬하여 보여준다.
메시지 전송| 상대방에게 비동기적으로 메시지를 전송할 수 있다.
닉네임 검색| 닉네임으로 회원 검색 후, 해당 회원 채팅방에 입장하여 메시지를 전송할 수 있다

### 관리자페이지
기능명 | 상세
-------|-----
로그인| 관리자 페이지에서 관리자 아이디와 비밀번호가 일치할 경우만 로그인이 가능하다.
회원관리| 회원 관리 페이지에서 회원 정보를 조회할 수 있으며 회원의 활성화/비활성화 여부를 변경할 수 있고, 회원탈퇴를 시킬 수 있다. 아이디, 이름으로 회원 검색이 가능하다.
게시판관리|자유게시판, 레슨게시판, 마켓게시판의 글 리스트를 볼 수 있으며 제목으로 검색이 가능하고 모든 게시글을 삭제시킬 수 있다.
신고관리|신고접수된 게시글의 내역을 볼 수 있으며, 처리여부도 변경할 수 있다.
페이징|모든 페이지는 한 페이지당 10개씩 보이도록 페이징 처리가 되어있다.

## 💜 개발 환경
### 사용언어
<img src="https://img.shields.io/badge/java-2C2255?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=white"> <img src="https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jQuery&logoColor=white"> <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white"> <img src="https://img.shields.io/badge/CSS-1572B6?style=for-the-badge&logo=CSS&logoColor=white"> <img src="https://img.shields.io/badge/JSTL-E34F26?style=for-the-badge&logo=JSTL&logoColor=white">

### 기술스택
<img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> <img src="https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=Oracle&logoColor=white"> <img src="https://img.shields.io/badge/Apache Maven-C71A36?style=for-the-badge&logo=Apache Maven&logoColor=white"> <img src="https://img.shields.io/badge/mybatis-2C2255?style=for-the-badge&logo=mybatis&logoColor=white">

### 개발환경
<img src="https://img.shields.io/badge/Eclipse IDE-2C2255?style=for-the-badge&logo=Eclipse IDE&logoColor=white"> <img src="https://img.shields.io/badge/Apache Tomcat-F8DC75?style=for-the-badge&logo=Apache Tomcat&logoColor=white"> <img src="https://img.shields.io/badge/VISUAL STUDIO CODE-1572B6?style=for-the-badge&logo=VISUAL STUDIO CODE&logoColor=white"> <img src="https://img.shields.io/badge/GITHUB-2C2255?style=for-the-badge&logo=GITHUB&logoColor=white">


## 🤍 루바토 살펴보기

### 1. 메인화면
<img width="946" alt="image" src="https://user-images.githubusercontent.com/119032800/227849255-e7d3d23a-c7ac-4430-abb8-7e16d7cc89d5.png">
<img width="914" alt="image" src="https://user-images.githubusercontent.com/119032800/227849295-863ea358-f512-4441-aa5a-be732279f9e7.png">
<img width="920" alt="image" src="https://user-images.githubusercontent.com/119032800/227849327-11de7258-f691-4694-add6-b697267b27aa.png">
<img width="889" alt="image" src="https://user-images.githubusercontent.com/119032800/227849502-4ccbeec6-0bb4-4d75-9fd1-46e92379f8f8.png">
<img width="929" alt="image" src="https://user-images.githubusercontent.com/119032800/227849632-1219fcd7-339e-43c3-81ae-3deafac6ecf7.png">

### 2. 로그인
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227849955-7ce82e76-c3b5-4f80-975e-7636c60fe7b2.png">
2-1 아이디찾기
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227851608-432b2a5c-262f-483e-828b-b65460caad3e.png">
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227851694-6e373097-42c7-479f-8c52-24e24f1f12a3.png">
2-2. 비밀번호 찾기
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227851838-380d6d48-c216-411e-99dc-924231433948.png">
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227851776-2097c722-0f8b-4821-9d03-841fc4d96a7f.png">


### 3. 회원가입
<img width="794" alt="image" src="https://user-images.githubusercontent.com/119032800/227850093-b9cb9fbf-4dbd-4e6f-aa8d-c66b948b0f4c.png">

### 4. 마이페이지
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227850165-4693da18-9a93-4b44-ac9b-0d2a6e6396fa.png">
4-1. 작성 글 내역
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227850247-f8c37176-8acd-4558-9b57-4c4531d8a856.png">
4-2. 작성 댓글 내역
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227850541-e8f5d070-539b-442b-9724-e30cb7be1481.png">
4-3. 레슨 등록 내역
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227850645-142bf880-9c3e-4517-aca6-1a3bfb9df63c.png">
4-4. 레슨 신청 내역
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227850695-0fb88709-43bf-4670-9133-b266e5aab3e9.png">
4-5. 나의 판매 내역
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227850749-10f6292b-1aea-4d07-a654-4f18a998e919.png">
4-6. 구매 신청 내역
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227851307-f25ecae9-9d76-462f-804b-80feda9aa0b8.png">

### 5. 레슨게시판
5-1. 레슨 목록
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227852206-49664279-dc2b-4731-b848-cb35d16a66ee.png">
5-2. 레슨 상세
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227852243-4410af8e-63c4-45dc-a460-8edcd96bffe6.png">
5-3. 레슨 신청글 작성
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227852366-3660f5e5-cf92-4b38-9744-ddd4fc7f7090.png">
5-4. 레슨 생성
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227852511-a894601d-b9bf-4765-970c-5bbbfe64ceea.png">

### 6. 마켓게시판
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227852619-e325be5a-e6f5-4b89-a93f-dbd60bd7d0ce.png">
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227852691-e1dfb495-0cb8-4680-84a2-a12dc9692c1c.png">
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227852778-32059353-685a-4946-b5c3-0c362d1deb51.png">
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227852829-d6675dbb-2e9b-450b-af8d-d999db75ae4b.png">
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227852871-668535ee-1119-43de-a935-c0dafd1c6387.png">

### 7. 자유게시판
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227853082-614f56a1-b3cc-4760-8545-728519c6255b.png">
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227853144-cf9435a4-9e83-4f07-b723-673d2594f1ed.png">

### 8. 채팅
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227853304-4fa0556c-b675-44be-87f0-41fe00587de2.png">
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227853248-3ec9f293-4b2a-440d-af6f-964b717f9202.png">

### 9. 관리자페이지
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227853392-ae3b95ad-1a7f-4565-9344-ca566f60302d.png">
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227853435-665d9c7e-f1d9-4d6f-8ea6-d32ee9d0f1ce.png">
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227853468-61b14e1f-d98a-4a89-b6e7-bdc2758c182c.png">
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227853496-38924bb1-ed28-477e-bb19-bcca04861d0e.png">
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227853536-04ae6eb7-41f9-40f9-add7-800c03dd4273.png">
<img width="959" alt="image" src="https://user-images.githubusercontent.com/119032800/227853572-73bc2ec6-1149-4b3e-9f77-c3faa5868cf3.png">

