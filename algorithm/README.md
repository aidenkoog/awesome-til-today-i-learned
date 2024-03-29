#### 알고리즘

- 아랍의 수학자, 알콰리즈미 이름에서 유래
- 문제 이해 후 문제 해결을 위한 단계를 세우고 이를 적용해 문제를 해결하는 과정
  - 컴퓨터에게 명령하기 위해서는 일의 순서를 세분화해서 명령을 내려야 함
- 절차
- 문제나 과제를 해결하기 위한 처리 절차를 하나하나 구체적인 순서에 따라 표현한 아이디어나 생각

#### 알고리즘의 조건

- 입력
- 출력
- 명확성
- 유한성(종결성): 명령어 수행 후 유한 시간 내에 종료
- 효율성: 모든 과정은 명백하게 실행 가능 / 검증 가능한 것이어야 함

#### 알고리즘의 4단계 설명

- 문제 정의: 해결하고자 하는 바를 input / output 으로 나눠서 정의
- 알고리즘 설명: 해결하기 위해 할 일들을 단계적으로 정의
- 정확성 증명: 알고리즘이 맞는지 수학적으로 증명
- 성능 분석: 시간, 공간 복잡도

#### 프로그램 / 프로그래밍 개념

- 프로그램: 알고리즘을 프로그래밍 언어로 기술한 것
- 프로그래밍: 프로그램을 작성하는 작업
- 프로그래밍 언어: 컴퓨터에 지시하기 위한 인공 언어
- 프로그램 작성 흐름
  - 기획 => 설계 => 프로그래밍(코딩) => 테스트 / 디버깅 => 문서 작성

#### 알고리즘 분석 방법

- 시간 복잡도 (Time Complexity) - 속도
- 공간 복잡도 (Space Complexity) - 메모리 사용량
- 참고.
  - 일반적으로 복잡도를 이야기할 때 이는 시간 복잡도를 의미
  - 알고리즘은 시간을 더 중요시

#### 알고리즘 문제 해결 전략 설명

- 반복
- 재귀반복
- 완전 탐색
- 역추적
- 발견법
- 분할 정복

#### 알고리즘 종류

- 정렬: 선택 / 삽입 / 병합 / 퀵
- 탐색: 순차 탐색
- 그래프
  - 그래프 탐색: 깊이 우선 탐색 / 너비 우선 탐색
  - 경로 탐색

#### 알고리즘의 세가지 기본형 (기본 구조) 설명

- 순차 구조
- 선택 구조
- 반복 구조

#### 빅오 표기법 설명 (Big-O notation)

- 알고리즘 최악의 실행 시간 표기, 최소한 보장되는 성능 표기, 가장 일반적으로 사용
  - 그 외 표기법: 빅 오메가 (최상의 실행 시간), 빅 세타 (평균 실행 시간)
- 상수항 / 계수 무시
- 최고차항만 표시
- 종류
  - 실행 속도 O(1) < O(log N) < O(N) < O(N log N) < O(N^2) < O(2^N) <-- 가장 느림

#### 정렬 알고리즘에서 Stable, Unstable에 대한 설명

- 순서 : 같은 값의 정렬 후 위치
- 각각에 해당하는 알고리즘에 대해 설명
  - Stable: 삽입, 합병
  - Unstable: 선택, 힙, 퀵
- 구체적인 구현 내용
  - 합병: 분할
  - 퀵: 피벗
- 시간 복잡도
  - 합병: nlogn
  - 퀵: nlogn ~ n^2 (최악의 경우)
- 각각의 장단점 / 언제 사용하면 좋은지?
  - 시간 복잡도, In-place, Stable

#### 동적 프로그래밍(DP, Dynamic Programming) 설명

- 주어진 문제를 풀기 위해서, 문제를 여러 개의 하위 문제(subproblem)로 나누어 푼 다음, 그것을 결합하여 해결하는 방식
- 어떤 부분 문제가 다른 문제들을 해결하는데 사용될 수 있어, 답을 여러 번 계산하는 대신 한 번만 계산하고 그 결과를 재활용하는 메모이제이션(Memoization) 기법으로 속도를 향상 시킬 수 있음
- 2가지 조건
  - 중복되는 부분(작은) 문제
  - 최적 부분 구조

#### 메모이제이션 (Memoization) 기법 설명

- 동일한 계산을 반복해야 할 때, 이전에 계산한 값을 재사용함으로써 동일한 계산의 반복 수행을 제거하여 프로그램 실행 속도를 빠르게 하는 기술

#### 동적 프로그래밍(Dynamic Programming)의 두 가지 조건 설명

- 다음의 조건을 만족해야 함
  - Overlapping Subproblem(중복되는 부분문제): 주어진 문제는 같은 부분 문제가 여러번 재사용됨
  - Optimal Substructure(최적 부분구조): 새로운 부분 문제의 정답을 다른 부분 문제의 정답으로부터 구할 수 있음

#### 재귀 알고리즘과 재귀의 시간 복잡도 설명

- 함수 내부에서 함수가 자기 자신을 또 다시 호출하여 문제를 해결하는 알고리즘
- 자기가 계속해서 자신을 호출하므로 끝없이 반복되게 되므로 반복을 중단할 조건이 반드시 필요
- 팩토리얼을 계산하는 재귀 함수에서는 T(n) = T(n-1) + c (C는 n과 f(n-1)을 곱하는 비용)을 조회하고 점화식을 계산하면 O(n)이 됨

#### 정렬 알고리즘 설명

- **버블정렬** (Bubble Sort)
  - 서로 인접한 두 원소를 비교하여 정렬하는 알고리즘
  - 0번 인덱스부터 n-1번 인덱스까지 n번까지의 모든 인덱스를 비교하며 정렬
  - 시간복잡도 O(n^2)
- **선택정렬** (Selection Sort)
  - 첫 번째 값을 두번째부터 마지막 값까지 차례대로 비교하여 최소값을 첫 번째에 놓음
  - 두 번째 값을 세번째부터 마지막 값까지 비교하여 최소값을 찾아 두 번째 위치에 놓음
  - 위 과정을 반복하며 정렬하는 알고리즘
  - 시간복잡도 O(n^2)
- **힙 정렬** (Heap Sort)
  - 주어진 데이터를 힙 자료구조로 만들어 최대값 또는 최소값부터 하나씩 꺼내서 정렬하는 알고리즘
  - 힙소트가 가장 유용한 경우는 전체를 정렬하는 것이 아니라 가장 큰 값 몇개만을 필요로 하는 경우에 적합
  - 시간복잡도는 O(nlog2n)
- **병합정렬** (Merge Sort)
  - 주어진 배열을 크기가 1인 배열로 분할하고 합병하면서 정렬을 진행하는 분할/정복 알고리즘
  - 시간복잡도는 O(nlog2n)
- **퀵 정렬** (Quick Sort)
  - 매우 빠른 정렬 속도를 자랑하는 분할 정복 알고리즘 중 하나로 합병정렬과 달리 리스트를 비균등하게 분할
  - 피벗을 설정하고 피벗보다 큰값과 작은값으로 분할하여 정렬
  - 시간복잡도
    - 최선 / 평균의 경우: O(nlog2n)
    - 리스트가 계속해서 불균등하게 나눠지는 경우는 O(n^2)
- **삽입정렬** (Injection Sort)
  - 두 번째 값부터 시작하여 그 앞에 존재하는 원소들과 비교하여 삽입할 위치를 찾아 삽입하는 정렬 알고리즘
  - 두 번째 값과 첫번째 값 비교 후 서로 위치 변경
  - 세 번째 값과 두번째 (필요시 첫번째) 값들 비교 후 위치 변경
  - 이 과정을 반복
  - 시간 복잡도
    - 평균: O(n^2)
    - 가장 빠른 경우는 O(n)
    - 최악의 경우: O(n^2)

#### n개의 배열에서 k(k<=n) 번째로 큰수를 찾는 알고리즘 설명

- 일반적으로 퀵정렬을 사용
- 퀵정렬을 사용하면 정렬이 불필요한 부분들을 정렬하면서 효율적이지 못하게 되는 문제 발생
- 퀵선택 알고리즘은 퀵정렬을 한 후에 피봇과 K를 비교하여 아래와 같이 수행
  - pivot의 인덱스가 k와 같은 경우 : 그대로 그 인덱스의 값을 리턴
  - pivot의 인덱스가 k보다 작은 경우 : pivot의 인덱스+1부터 마지막 인덱스까지 다시 Partition함수에 넘겨준다
  - pivot의 인덱스가 k보다 큰 경우 : 첫번째 인덱스부터 pivot의 인덱스-1까지 다시 Partition함수에 넘겨준다
- 퀵정렬과 퀵선택 알고리즘 차이점
  - Pivot의 인덱스가 7이고 K가 5인 경우에, 피봇의 오른쪽 부분은 재귀 함수를 돌지 않아 한 쪽만으로 재귀를 진행
  - 퀵선택 알고리즘의 시간복잡도: n+n/2+4/n+....1=O(n)

#### 빅오(Big-O) 표기법의 시간 복잡도 크기 순서

- O(1) < O(logN) < O(N) < O(NlogN) < O(N^2) < O(2^N) < O(N!)

#### 허프만 코딩 설명

- 문자의 빈도를 이용해 압축하는 방법으로 빈도가 높은 문자에 짧은 코드를 부여
- 접두부 코드와 최적 코드를 사용
  - 접두부 코드: 문자에 부여된 코드가 다른 이진 코드의 접두부가 되지 않는 코드
  - 최적코드: 인코딩된 메세지의 길이가 가장 짧은 코드

#### 알고리즘 테스트의 목적

- 문제 해결력
- 예외 상황과 경계값 처리
- 코드 가독성과 중복 제거 등 관련한 코드의 품질
- 언어 자체에 대한 이해도
- 효율적인 로직
- => 문제를 어떻게 창의적으로 해결을 할 것인가를 측정하기 위한 목적

#### 알고리즘 문제 해결을 위한 접근법 및 생각법 정리

- 접근법
  - 문제에 대한 능동적, 공격적 받아들임
  - 필요한 정보를 추가적으로 요구
  - 문제 자체에 대한 완벽한 이해 필요
  - 문제를 익숙한 용어로 재정의 / 해결하기 위한 정보를 추출 <== 추상화 과정
  - 추상화된 데이터를 바탕으로 문제 해결 계획 수립 (사용할 알고리즘과 자료구조 선택)
  - 수립한 계획에 대해 검증 시도
    - Pseudo 코드 작성 또는 의견 수집
  - 계획 실행
- 생각법
  - 비슷한 문제를 항상 생각하려고 시도
  - 단순한 방법에서 시작해서 점진적 개선 시도
  - 작은 값을 생각 시도
  - 그림으로 그리기 시도
  - 수식으로 표현 시도
  - 풀이 순서를 강제
  - 뒤에서부터 생각

#### DFS, BFS에 대한 설명 (그래프 탐색 알고리즘)

- [DFS]: **깊이** 우선 탐색 (Depth First Search)
  - "더 나아갈 길이 보이지 않을 때까지 깊이 들어간다"를 원칙으로 그래프 내의 정점을 방문하는 알고리즘
  - 끝까지 깊이 들어갔다가 방문해왔던 정점 말고는 다른 이웃을 갖고 있지 않은 정점을 만나게 되면 다시 뒤로 돌아와 다른 경로로 뻗어 있는 정점을 타고 방문을 재개하는 방식으로 동작
  - 루트 노드 (또는 다른 임의의 노드)에서 시작해서 다음 분기로 넘어가기 전에 해당 분기를 완벽하게 탐색하는 방법
  - 모든 노드를 방문하고자 하는 경우에 선택 (완전 탐색 알고리즘에 자주 이용)
  - 자기 자신을 호출하는 순환 알고리즘
  - 트리 순회 (전위, 중위, 후위 순회)는 모두 DFS의 한 종류
  - 그래프 탐색의 경우 어떤 노드를 방문했었는지의 여부를 반드시 검사 필요 (무한 루프 방지의 목적)
- [BFS]: **너비** 우선 탐색 (Breadth First Search)
  - "꼼꼼하게 좌우를 살피며 다니자"
  - 시작 정점으로부터 가까운 정점을 먼저 방문하고 멀리 떨어져 있는 정점을 나중에 방문하는 알고리즘
  - 깊이 1인 모든 정점 방문 후 그 다음 깊이 정점들 방문
  - 더 이상 방문할 정점이 없는 경우에 탐색을 종료
  - 루트 노드에서 시작해서 인접한 노드를 먼저 탐색하는 방법
  - 두 노드 사이의 최단 경로 또는 임의의 경로를 찾고 싶을 때 이 방법 선택
  - 시작 정점으로부터 거리가 가까운 정점의 순서로 탐색
  - 어떤 노드를 방문했었는지 여부를 반드시 검사
  - 재귀적으로 동작하지 않음
  - 방문한 노드들을 차례로 저장한 후 꺼낼 수 있는 자료구조인 큐를 사용 (FIFO)
  - 일반적으로 큐를 이용해서 반복적 형태로 구현

#### 최소 비용 신장 트리(MST, Minimum Spanning Tree) 알고리즘 설명

- 신장 트리(Spanning Tree)
- 크루스칼 (Kruskal) 알고리즘
- 프림 (Prim) 알고리즘

#### 최단 경로(Shortest Path) 알고리즘 설명

- 다익스트라 (Dijkstra) 알고리즘
- 플로이드 (Floyd) 알고리즘

#### Union-Find 알고리즘 설명

- Union-Find

#### 백트래킹 (Back Tracking)

- 모든 경우의 수를 전부 고려하는 알고리즘
- 답을 찾는 도중 답이 아니어서 막히면, 되돌아가서 다시 답을 찾아가는 기법
- 퇴각검색
- 현재 상태에서 가능한 모든 경로를 따라 들어가 탐색하다, 원하는 값과 불일치하는 부분이 발생하면 더 이상 탐색을 진행하지 않고 전 단계로 돌아가는, 즉 이름 그대로 방금 왔던 길을 되돌아가는 알고리즘

