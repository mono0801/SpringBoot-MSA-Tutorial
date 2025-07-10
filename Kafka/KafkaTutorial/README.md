# 1. 컨테이너 내부 접속
```bash
  docker exec -it kafka-kraft bash
```

# 2. 컨테이너 내 환경변수 설정
bitnami/kafka 이미지를 사용하여 컨테이너를 실행함
```bash
    export PATH=$PATH:/opt/bitnami/kafka/bin
```

# 2. 토픽 생성
```bash
    kafka-topics.sh \
    --create \
    --topic test-topic \
    --bootstrap-server localhost:9092 \
    --partitions 1 \
    --replication-factor 1
```

# 3. 메시지 생산 (프로듀서)
```bash
    kafka-console-producer.sh \
    --topic test-topic \
    --bootstrap-server localhost:9092
```
- 위 명령어 실행 후, 메시지 입력
- Ex) hello Kafka 입력 후 <b>Enter</b>
- Ctrl + C로 종료

# 4. 메시지 소비 (컨슈머)
```bash
    kafka-console-consumer.sh \
    --topic test-topic \
    --bootstrap-server localhost:9092 \
    --from-beginning
```
- 입력한 메시지가 콘솔에 출력됨
- Ctrl + C로 종료