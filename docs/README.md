# 📝설계 구조
- Application : 애플리케이션 실행을 관리한다.
- MainController : 데이터 전달 및 중계 역할을 한다.
- view
    - InputView : 입력과 관련된 책임 관리한다.
    - OutputView : 출력과 관련된 책임 관리한다.
- message
    - ErrorMessage : 에러 메시지를 관리한다.
    - ViewMessage : 출력 메시지를 관리한다.
- domain
    - Car :  멤버 변수로 `name` , `position` 을 가지고 있으며 자동차의 역할을 한다.
# 💪 프로젝트 개요
자동차 게임을 구현한다. <br>
자동차의 name과 시도횟수를 입력받고, 게임을 진행시킨 후 우승자를 선정한다.

# 📝 구현 기능 목록
### 게임 초기화


- [X] 자동차 이름 입력받기 기능
  -  출력 문구 : `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)` 
  - [x] `예외처리` : 빈 문자열 입력 검증
  - [X] `예외처리` : 5글자를 초과하지 않는지 검증


  - [x]  쉼표로 이름들 구분하는 기능.  
     - [X] `예외처리` : 중복되는 이름 검증


- [x] 시도 횟수 입력받기 기능
  - `시도할 회수는 몇회인가요?`를 출력한다.
  - [x] `예외처리` : 빈값 검증
  - [x] `예외처리` : 숫자가 아닌 문자 검증
  - [x] `예외처리` : 0 이하인 값 검증
### 게임 진행
- [x] 자동차 전진 한다.
  - [x] 0~9중 난수 생성 후 4이상일때만 true 반환 기능
- [x] 매 실행결과 출력 한다.
  - [x] 처음에만 "실행 결과" 출력 
  - [x] `출력문구` : `${이름} : ---` 와 같은 형식으로 출력

### 게임 종료
- [x] 우승자를 선정한다.
- [x] 우승자를 출력한다
  - [x] `출력문구` : `최종 우승자 : ${이름}` 형태로 출력한다.
