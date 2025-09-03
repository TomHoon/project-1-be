### 빌드
### chmod +x ./graldew
### build.gradle에서 아래처럼 변경
    ### version = ''
    ### group = 'com.project1'
### ./gradlew clean
### ./gradlew build -x test
### docker image 만들기
### docker build -t hy-image .
### docker 실행
### docker run -d -p 12000:12000 --network chatting-network --name hy-container hy-image