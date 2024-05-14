# financial
## Git Strategy
- 브랜치 전략
    - `release`: 최신 릴리스 배포 버전 관리
    - `develop`: 최종 개발 버전 코드 관리. 해당 브랜치에서 QA 버전을 배포
      userName/ehp_android : 각자 fork한 브랜치
    - `feature/xxx`: 개발 진행 중인 기능에 대한 코드 관리. 각 작업자가 해당하는 `feature`명으로 브랜치 분기
    - `bugfix/vX.Y.Z`: develop 버전에 버그 발생 시 해당 브랜치에서 버그를 픽스함
    - `hotfix/vX.Y.Z`: release 버전에 버그 발생 시 해당 브랜치에서 버그를 픽스함
    - QA 빌드 버전 표시는 Tag를 통해서 표시하며 최종 배포시 Tag 제거
      (QA 빌드 버전은 Develop, Bugfix 브랜치에서 제공)
    - Release 빌드 버전 표시는 Tag를 통해서 표시
      (Release 빌드 버전은 Master, Hotfix 브랜치에서 제공)
- 커밋 전략
    - 커밋은 애플리케이션 구동 시 문제가 없는 수준에서 최소 단위로 커밋한다.
    - 커밋 메세지는 아래의 `[유형] 작업에 대한 요약 설명` 형태로 작성하고 필요에 따라 body를 작성할 수 있다.
    - `[ADD]` 신규 기능 추가 시 사용한다.
    - `[UPDATE]` 기능 수정 시 사용한다.
    - `[DELETE]` 기능 삭제 시 사용한다.
    - `[FIX]` 버그 수정 시 사용한다.
    - `[REFACTOR]` 코드 리팩토링 시 사용한다.
    - `[SETTING]` 환경설정, 라이브러리 버전 업데이트 등의 작업 시 사용한다.
    - `[DOCS]` README 등 문서 작업 발생 시 사용한다.
    - `[VERSION]` 앱 버전 수정 시 사용한다.
    - `[CHORE]` 기타 사소한 작업 발생 시 사용한다.