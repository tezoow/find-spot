# 장소 검색 서비스
## How To Run
`bootRun` 을 실행합니다.
```bash
./gradlew bootRun
```

이후 웹브라우저에서 [http://localhost:8080](http://localhost:8080) 을 띄워 실행합니다.

### Authentication
사용 가능한 계정으로

* user / user
* kakao / kakao

가 준비되어 있습니다. 해당 계정은 프로그램 구동시 `data.sql` 에 의해 h2 DB에 insert 됩니다.

## Jar
```bash
./gradlew clean build
```

## How To Test
```bash
./gradlew test
```