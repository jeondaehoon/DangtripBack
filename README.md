# DangTrip

**반려견 동반 산책·장소·커뮤니티·쇼핑을 통합 제공하는 모바일 서비스 (개인 개발 백엔드)**

DangTrip은 반려견과 함께하는 산책, 장소 탐색(카페/병원), 커뮤니티, 쇼핑, 채팅 등  
다양한 기능을 하나의 앱에서 사용할 수 있도록 구현한 프로젝트입니다.  
Spring Boot 기반 REST API 서버를 직접 설계하고,  
React Native 앱과 연동하여 실제 서비스 환경처럼 동작하도록 구현했습니다.

---

## 기술 스택

### Backend Framework
- Spring Boot 3.5.4 (메인 프레임워크)
- Spring Security (JWT 기반 인증 및 보안)
- Spring WebSocket (실시간 채팅)
- MyBatis 3.0.5 (ORM 및 SQL 매핑)

### Database
- Oracle Database (메인 데이터베이스)
- MySQL / MariaDB (테스트 및 확장성 고려)

### Authentication & Security
- JWT (토큰 기반 인증)
- JJWT 0.11.5 (토큰 생성 및 검증)
- Spring Security (엔드포인트별 접근 제어)

### Real-time Communication
- Spring WebSocket (실시간 통신)
- STOMP Protocol (메시지 전송 프로토콜)

### Development Tools
- Lombok (코드 간소화)
- Maven (빌드 및 의존성 관리)
- Spring Boot DevTools (개발 편의 기능)

---

## 주요 구현 기능

### 1. 사용자 인증 시스템
- JWT 기반 로그인/회원가입 및 인증 처리
- 사용자 정보 관리 (닉네임, 프로필, 강아지 정보 등)
- Stateless 인증 구조로 서버 부하 최소화

### 2. 위치 기반 서비스
- GPS 좌표를 활용한 주변 장소(산책로, 병원, 카페) 조회
- 반경 기반 탐색 및 거리 정렬 기능
- Oracle Spatial 데이터 활용

### 3. 산책 관리 기능
- 산책로 목록(근처/인기/야간) API 제공
- 산책 시작/종료 기록 및 시간 저장
- 사용자별 산책 이력 관리

### 4. 쇼핑몰 기능
- 상품 카테고리 / 목록 / 상세 조회
- 장바구니 / 주문 / 쿠폰 시스템
- 인기 상품 조회 및 랭킹 API

### 5. 실시간 채팅 시스템
- WebSocket + STOMP 기반 채팅 서버 구축
- 채팅방 생성 / 참여 / 메시지 저장 기능
- 사용자 간 1:1 및 그룹 대화 지원

### 6. 커뮤니티 및 훈련 기능
- 게시글 등록 / 조회 / 좋아요 기능
- 단계별 반려견 훈련 콘텐츠 관리
- 사용자 커뮤니티 공간 제공

---

## 사용 API 및 연동

### 위치 기반 서비스
- GPS 좌표 기반 탐색  
- 거리 계산 알고리즘 (하버사인 공식)  
- 반경 내 장소 필터링  

### 실시간 통신
- WebSocket 양방향 통신  
- STOMP 메시징 (Publish/Subscribe 구조)  
- JWT 인증 기반 메시지 접근 제어  

### 데이터베이스 연동
- Oracle JDBC를 통한 메인 데이터 연동  
- MyBatis Mapper로 SQL 매핑 및 트랜잭션 관리  

### 파일 업로드
- MultipartFile 기반 이미지 업로드  
- 최대 10MB 파일 / 20MB 요청 제한 설정  

---

## 프로젝트 특징

- **보안 중심 설계**: JWT 기반 Stateless 인증으로 확장성 확보  
- **모듈형 구조**: Controller–Service–DAO–Mapper 계층 구조 적용  
- **WebSocket 통합**: STOMP 프로토콜을 통한 안정적인 실시간 메시징  
- **위치 기반 로직**: GPS 좌표 기반 반경 검색 기능 구현  
- **E-Commerce 확장성**: 상품, 주문, 쿠폰 등 쇼핑 모듈 완비  
- **반려동물 특화 기능**: 다중 강아지 등록, 훈련 가이드, 커뮤니티 기능 포함  

---


배운 점

Spring Boot + MyBatis를 활용한 API 서버를 처음부터 직접 구축했습니다.

JWT 인증, WebSocket 통신, RESTful 설계를 통해 백엔드 핵심 개념을 익혔습니다.

실제 앱 연동을 통해 API 설계, 토큰 인증, DB 트랜잭션 관리의 전체 흐름을 경험했습니다.

복잡한 기능들을 분리된 모듈로 관리하면서 유지보수성과 확장성을 고려한 구조를 설계했습니다.

개발 목표

반려견과 함께하는 생활 전반을 관리할 수 있는 서비스를 백엔드 중심으로 구현하는 것을 목표로 했습니다.
