## 기술 스택

### **Backend Framework**
- **Spring Boot 3.5.4**: 메인 프레임워크
- **Spring Security**: JWT 기반 인증 및 보안
- **Spring WebSocket**: 실시간 채팅 기능
- **MyBatis 3.0.5**: 데이터베이스 ORM

### **Database**
- **Oracle Database**: 메인 데이터베이스 (JDBC Driver)
- **MySQL**: 추가 데이터베이스 지원
- **MariaDB**: 확장성 고려 대안 DB

### **Authentication & Security**
- **JWT (JSON Web Token)**: 토큰 기반 인증
- **JJWT 0.11.5**: JWT 토큰 생성 및 검증
- **Spring Security**: 웹 보안 프레임워크

### **Real-time Communication**
- **Spring WebSocket**: 실시간 메시징
- **STOMP Protocol**: 메시지 전송 프로토콜

### **Development Tools**
- **Lombok 1.18.30**: 코드 간소화
- **Maven**: 의존성 관리 및 빌드 도구
- **Spring Boot DevTools**: 개발 편의성

## 구현 기능

### **1. 사용자 인증 시스템**
- JWT 기반 Stateless 인증
- 회원가입/로그인 기능
- 아이디/닉네임 중복 확인
- 강아지 정보 등록 및 관리

### **2. 위치 기반 서비스**
- GPS 좌표를 활용한 근처 장소 검색
- 산책로, 동물병원, 펫프렌들리 카페 위치 제공
- 거리 계산 및 정렬 기능

### **3. 산책 관리 시스템**
- 인기/추천/야간 산책로 분류
- 위치 기반 근처 산책로 추천
- 산책 시작/종료 추적 기능

### **4. E-Commerce 시스템**
- 카테고리별 상품 분류
- 장바구니 기능
- 인기 상품 랭킹 시스템
- 쿠폰 할인 시스템

### **5. 실시간 채팅**
- WebSocket 기반 그룹 채팅
- 채팅방 생성 및 참여
- 메시지 히스토리 저장

### **6. 훈련 프로그램**
- 카테고리별 훈련 콘텐츠
- 단계별 훈련 가이드
- 훈련 진행 상황 관리

### **7. 커뮤니티 기능**
- 게시글 작성 및 조회
- 프로모션 정보 제공
- 사용자 마이페이지

## 사용 API 및 오픈 API

### **위치 기반 서비스**
- **GPS 좌표 API**: 위도/경도를 통한 위치 기반 검색
- **거리 계산 알고리즘**: 하버사인 공식을 활용한 거리 측정
- **지역별 장소 검색**: 반경 기반 산책로/병원/카페 검색

### **실시간 통신**
- **WebSocket API**: 실시간 양방향 통신
- **STOMP 메시징**: 구독/발행 패턴 기반 채팅
- **JWT 토큰 인증**: 보안된 API 접근 제어

### **데이터베이스 연동**
- **Oracle JDBC**: 메인 데이터베이스 연결
- **MyBatis Mapper**: SQL 매핑 및 쿼리 관리
- **트랜잭션 관리**: Spring의 선언적 트랜잭션

### **파일 업로드**
- **MultipartFile**: 이미지 업로드 지원
- **파일 크기 제한**: 10MB 파일, 20MB 요청 크기 제한

## 프로젝트 특징

### **보안 중심 설계**
- **JWT 기반 Stateless 인증**: 서버 부하 감소 및 확장성 확보
- **Spring Security 통합**: 엔드포인트별 세밀한 권한 제어
- **CORS 설정**: 크로스 오리진 요청 안전 처리

### **모듈형 아키텍처**
- **패키지별 기능 분리**: 각 도메인별 독립적인 개발 가능
- **계층형 구조**: Controller → Service → DAO → Mapper 패턴
- **의존성 주입**: Spring IoC 컨테이너 활용

### **실시간 통신**
- **WebSocket 기반 채팅**: 낮은 지연시간의 실시간 메시징
- **STOMP 프로토콜**: 메시지 브로커를 통한 효율적 메시지 전달
- **세션 관리**: 채팅방별 독립적인 메시지 처리

### **위치 기반 서비스**
- **GPS 좌표 활용**: 정확한 위치 기반 검색
- **거리 계산**: 하버사인 공식으로 정밀한 거리 측정
- **범위별 검색**: 사용자 위치 기준 반경 내 장소 제공

### **확장 가능한 E-Commerce**
- **카테고리 시스템**: 유연한 상품 분류
- **장바구니 관리**: 다중 상품 선택 및 수량 관리
- **쿠폰 시스템**: 할인 정책 적용

### **반려동물 특화 기능**
- **다중 강아지 관리**: 한 사용자가 여러 강아지 등록 가능
- **견종별 맞춤 서비스**: 강아지 특성에 따른 개인화 추천
- **훈련 프로그램**: 단계별 강아지 훈련 가이드

## 프로젝트 구조

```
src/main/java/com/freefit/freefitapp/
├── cafes/          # 펫프렌들리 카페 관리
├── cart/           # 장바구니 기능
├── chat/           # 실시간 채팅
├── config/         # 설정 (보안, WebSocket 등)
├── coupon/         # 쿠폰 시스템
├── dogdetail/      # 강아지 상세 정보
├── doginfo/        # 강아지 정보 관리
├── explore/        # 장소 탐색
├── hospital/       # 동물병원 정보
├── login/          # 로그인 인증
├── main/           # 메인 페이지
├── mypage/         # 마이페이지
├── order/          # 주문 관리
├── shopping/       # 쇼핑몰
├── signup/         # 회원가입
├── trainings/      # 훈련 프로그램
├── util/           # 유틸리티 (JWT, DB 설정 등)
├── vo/             # Value Objects
└── walks/          # 산책 관련 기능
```

## 로드맵

### **Phase 1: 기본 플랫폼 구축** 
- [x] 사용자 인증 시스템 (JWT)
- [x] 강아지 정보 관리
- [x] 위치 기반 산책로 서비스
- [x] 기본 쇼핑몰 기능
- [x] 실시간 채팅 시스템

### **Phase 2: 서비스 확장** 
- [ ] **추천 시스템 고도화**
  - AI 기반 개인화 추천 엔진
  - 강아지 특성별 맞춤 서비스
  - 사용자 행동 패턴 분석

- [ ] **소셜 기능 강화**
  - 산책 그룹 매칭 시스템
  - 강아지 미팅 기능
  - 커뮤니티 게시판 고도화

- [ ] **모바일 앱 개발**
  - React Native 기반 크로스 플랫폼 앱
  - 푸시 알림 시스템
  - 오프라인 모드 지원

### **Phase 3: 고급 기능** 📋
- [ ] **IoT 연동**
  - 강아지 활동량 추적기 연동
  - 건강 데이터 모니터링
  - 스마트 컬러/급식기 연동

- [ ] **결제 시스템 통합**
  - PG사 연동 (토스페이먼츠, 카카오페이)
  - 정기 구독 서비스
  - 포인트 적립 시스템

- [ ] **데이터 분석 플랫폼**
  - 강아지 건강 인사이트 제공
  - 지역별 반려동물 트렌드 분석
  - 예측 분석 기반 서비스

### **Phase 4: 글로벌 확장** 
- [ ] **다국어 지원**
  - 영어, 일본어, 중국어 지원
  - 현지화된 콘텐츠 제공

- [ ] **글로벌 파트너십**
  - 해외 펫샵 및 병원 연동
  - 국제 배송 서비스
  - 글로벌 커뮤니티 구축

## 시작하기

### **필수 요구사항**
- Java 17 이상
- Oracle Database
- Maven 3.6 이상

### **설치 및 실행**

1. **저장소 클론**
```bash
git clone https://github.com/your-username/FreeFit.git
cd FreeFit
```

2. **데이터베이스 설정**
```properties
# application.properties
spring.datasource.hikari.jdbc-url=jdbc:oracle:thin:@localhost:1521/ORCLPDB
spring.datasource.hikari.username=YOUR_USERNAME
spring.datasource.hikari.password=YOUR_PASSWORD
```

3. **애플리케이션 실행**
```bash
mvn spring-boot:run
```

4. **브라우저에서 접속**
```
http://localhost:8080
```

## 주요 API 엔드포인트

### **인증**
- `POST /login` - 로그인
- `POST /signup` - 회원가입
- `GET /checkid` - 아이디 중복 확인

### **강아지 정보**
- `GET /dogbreeds` - 견종 정보 조회
- `POST /saveDogInfo` - 강아지 정보 저장
- `GET /doginfo/{userId}` - 사용자 강아지 정보 조회

### **산책**
- `GET /walks` - 위치 기반 산책로 조회
- `GET /walks/popular` - 인기 산책로
- `GET /walks/night` - 야간 산책로

### **쇼핑**
- `GET /shopping/categories` - 상품 카테고리
- `GET /shopping/products` - 상품 목록
- `POST /cart` - 장바구니 추가

### **채팅**
- `POST /chat/join` - 채팅방 참여
- WebSocket: `/chat/{roomId}` - 실시간 메시지

## 기여하기

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 라이선스

이 프로젝트는 MIT 라이선스 하에 배포됩니다. 자세한 내용은 `LICENSE` 파일을 참조하세요.


프로젝트 링크: [https://github.com/your-username/FreeFit](https://github.com/your-username/FreeFit)

---

**FreeFit과 함께 우리 강아지의 건강한 일상을 만들어가세요! 🐾**
