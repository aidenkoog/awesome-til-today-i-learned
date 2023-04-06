#### Git 개념

- 분산형 버전 관리 시스템 (Version Control System)의 한 종류
- 버전 관리 시스템: 파일 변화를 시간에 따라 기록했다가 나중에 특정 시점의 버전을 다시 꺼내올 수 있는 시스템
  - 시점 복원 가능
  - 비교 가능
  - 작성자 확인 가능
  - 작성 시점 확인 가능

#### Git 장점 설명

- 소스 코드를 주고 받을 필요 없이, 같은 파일을 여러 명이 동시에 작업하는 병렬 개발 가능
- 오프라인 작업에 대한 병햡
- A라는 사람이 작업한 것과 B라는 사람이 작업한 내용을 라인 기반으로 병합
- 인터넷이 연결되지 않은 곳, 즉 오프라인에서도 개발 가능 (로컬에서, 분산 버전 관리 시스템이므로), 변경 사항들에 대한 병합 기능
  - 자동 Merge 기능이 없다면 오프라인 상태에서 수정 후 다른 오프라인 상태의 사람들의 수정 사항을 수동으로 적용해야 하는 상황 발생
- 중앙 저장소에 문제가 생겨도 원상 복구 가능
- 병합 시도 시 서로 같은 라인을 수정했을 경우 Conflict 발생
- 프로그램이나 패치 배포하는 과정 간단해짐
- 변경사항들을 커밋 단위로 관리 => 각각의 커밋들 간의 비교 가능

#### Git 작업 관련 약속해야 될 사항

- 작업 시작 전 Jira 티켓 생성 (이슈, 구현 등)
- 하나의 티켓은 하나의 커밋으로 완료될 수 있게 구성
- 커밋 그래프는 단순함 지향
- 서로 공유하는 커밋 그래프는 변경에 신중
- 리뷰어에게 리뷰를 반드시 받는 절차
- 자신의 풀리퀘스트 (PR)는 스스로 Merge

#### Git-Flow 전략 설명

- 브랜치 종류 설명
  - 항상 유지되는 메인 브랜치
    - master: 제품 출시
    - develop: 다음 출시 버전 개발
  - 일정 기간 동안만 유효한 보조 브랜치
    - feature: 기능 개발
    - release: 이번 출시 버전 준비
    - hotfix: 버그 수정
- 흐름 설명
  - 초기에 master 브랜치 준비
  - master 브랜치를 베이스로 하여 develop 브랜치 준비
  - develop 에서 상시로 버그를 수정한 커밋 추가
  - 새로운 기능 추가 작업이 있는 경우 develop 브랜치에서 feature 브랜치 생성
    - feature 브랜치는 항상 develop 브랜치에서부터 시작
  - 기능 추가 완료 후 feature 브랜치 내용을 develop 브랜치로 Merge
  - develop 에 이번 릴리즈 버전에 포함되는 모든 기능이 Merge 완료되었는 지 확인
  - 완료되었다면, QA 진행을 위해 develop 브랜치에서 release 브랜치 생성
  - QA 진행 중 발생한 버그들에 대한 수정사항은 release 브랜치에 추가
  - QA 완료 후 release 브랜치를 master와 develop로 Merge
  - master 브랜치에서 버전에 대한 태그 추가

#### Git, GitHub에 대한 설명

- Git: 버전 관리 시스템, Git Repository라고 불리는 데이터 저장소에 소스 코드 등을 넣어서 이용
- GitHub: Git Repository를 인터넷 상에서 제공하는 서비스(호스팅 서비스)
  - GitHub 라는 호스팅 서비스가 없다면 우리는 인프라 + 서버를 개인이 각각 구성하고 Git Repository를 조작할 UI가 있는 웹페이지까지 제작을 해야 함

#### fork와 clone 차이점

- fork
  - 다른 사람의 GitHub repository를 내 GitHub repository 즉, 나의 원격 저장소로 그대로 복제하는 기능
  - fork한 저장소는 원본과 연결되어 있음
  - 원본에 변경이 생기면 fork 저장소에서 fetch / pull 과정을 수행하면 변경 사항을 반영할 수 있음
  - 소스코드 수정 후 원본 repository에 적용하고 싶다면 원본 저장소에 PR (Pull Request)를 보내야 함
  - 원본 저장소 (GitHub 내 타 저장소들)에 권한이 없는 사용자가 저장소를 fork하고 자신의 저장소에 변경 사항을 적용한 후에 Push ==> 이 후 내 저장소에 있는 브랜치를 원본 저장소에 PR 요청 ==> 코드가 원작자에 의해 승인되면 코드가 병합됨.
- clone
  - 특정 원격 저장소 내용을 나의 로컬 저장소로 완전히 복사하는 기능
  - 연결된 저장소는 로컬에서 remote 로 연결된 origin
  - clone 한 프로젝트는 원본 저장소의 로그를 보는 것이 불가능

#### pull과 fetch 차이점

- fetch
  - 원격 저장소의 변경 사항들을 로컬로 가져오기 전에 변경 내용을 확인하고 싶은 경우에 사용하는 명령어
  - 누가 특정 파일에 수정을 했는지 안했는지 확인하고 싶을 때 사용
  - 로컬로 변경한 내용을 가져오지 않고 변경한 내역들만 확인
  - 사용 방법
    - 원격에서 (GitHub에서) 파일을 수정
    - 로컬에서 git fetch origin
    - git checkout origin/master
    - 해당 파일을 열어보면 원격저장소에서 수정한 내용이 추가되었음을 확인 가능
    - 즉, 로컬에는 저장되지 않고 브랜치로 체크아웃하여 변경된 내용들을 확인만 하는 것
    - git log로 fetch한 commit 내역도 확인 가능
    - fetch는 원격저장소에서 파일을 병합하기 전에 병합을 할지 말지 확인을 할수 있는 명령어
- pull
  - fetch랑 다르게 로컬에 변경내용을 병합
  - 로컬에서 작업 중 변경된 애용을 pull 할 경우 conflict 발생 가능성이 있으므로 fetch 후 pull을 로컬이 깨끗한 상태에서 사용하는 게 바람직함

#### merge와 cherry-pick 설명

- git cherry-pick
  - 다른 브랜치에 있는 Commit을 선택적으로 내 브랜치에 적용시킬 때 사용하는 명령어
- git merge
  - 브랜치를 다른 브랜치로 합치는 과정
  - merge의 기본 단위는 브랜치
  - Fast Forward Merge: 가장 기본적인 merge, 현재 브랜치의 HEAD가 대상 브랜치의 HEAD까지로 옮기는 merge
- (참고) Conflict 상황 설명
  - main 브랜치에서 a.file 안의 내용을 "test1" 이라고 작성하고 dev 브랜치에서 a.file 안의 내용을 "test2" 이라고 작성
  - git switch main
  - git merge dev
  - Conflict 발생
    - <<<<<< HEAD
    - test1
    - ======
    - test2
    - > > > > > > dev

#### HEAD에 대한 설명

- 모든 브랜치에 HEAD 값 존재
- 해당 브랜치의 마지막 Commit을 의미
- 특정 브랜치의 마지막 커밋에 대한 포인터
- 현재 내가 바라보고 있는 Commit

#### Git merge 대신 Git rebase 를 언제 사용하는 지에 대한 설명

- merge
  - 다른 브랜치에서 Commit한 내용을 하나의 Commit으로 합치는 것
  - 실행한 브랜치로 병합 실행하고 새로운 커밋이력을 생성
- rebase
  - 어떤 특정 브랜치를 베이스로 커밋 이력을 재정렬하겠다는 명령어
  - 재정렬되는 커밋 이력이기 때문에 재정렬되는 커밋 이력에는 이전과는 다른 새로운 Hash 아이디가 부여됨 (merge와 다른점)

#### Git stash 명령 사용 시기 설명

- 파일의 변경 내용을 일시적으로 기록해두는 것/영역
- 현재 작업 중인 내용을 임시 저장해두고 다른 구현 또는 이슈를 수정해야 할 때 사용
- stash 저장 명령
  - git stash
  - git stash push -m "message"
  - git stash save "message"
- stash 저장 목록 조회
  - git stash list
- stash 저장 내용 확인
  - git stash show
- stash 저장 내용 불러오기
  - git stash pop
  - git stash pop stash@{2}
  - git stash apply <== pop 과는 다르게 목록에서 사라지지 않고 해당 stash를 불러옴
- stash 제거
  - git stash drop
  - git stash clear

#### Git Upstream, Downstream 설명

- 저장소의 관계에 따라서 상대적으로 정해지는 이름들
- upstream: 상대방의 원본 원격 저장소 의미 (최신 정보 보유)
- downstream: 로컬 내 저장되어 있는 저장소, 주로 fetch로 가져온 다음 upstream/master를 origin/master로 merge하여 로컬 저장소도 최신으로 유지

#### Git switch, checkout, restore 설명

- 2019/08/16: Git은 checkout 기능을 switch와 restore로 분리
- switch: 브랜치 변경 기능, 기존에 없는 브랜치인 경우 생성하면서 변경도 가능
- restore: 작업 중인 파일 중 기존 마지막 커밋의 상태로 되돌리고자 할 때 사용, 변경 사항을 원래 상태로 되돌릴 수 있음
