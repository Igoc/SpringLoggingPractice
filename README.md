# Spring Logging Practice

Practice for logging in Spring

## IPv6 → IPv4

### IntelliJ

``` bash
-Djava.net.preferIPv4Stack=true
```

Run/Debug Configurations → VM options에 상단의 옵션 값 추가

## 실행 결과

### Filter

``` bash
2023-02-20 19:29:17.955  INFO 6593 --- [nio-8080-exec-1] c.e.springlogging.filter.LoggingFilter   : [Pre-filter] 127.0.0.1 - "GET / HTTP/1.1" 200
2023-02-20 19:29:18.077  INFO 6593 --- [nio-8080-exec-1] c.e.springlogging.filter.LoggingFilter   : [Post-filter] 127.0.0.1 - "GET / HTTP/1.1" 200
2023-02-20 19:29:18.091  INFO 6593 --- [nio-8080-exec-2] c.e.springlogging.filter.LoggingFilter   : [Pre-filter] 127.0.0.1 - "GET /js/index.js HTTP/1.1" 200
2023-02-20 19:29:18.091  INFO 6593 --- [nio-8080-exec-3] c.e.springlogging.filter.LoggingFilter   : [Pre-filter] 127.0.0.1 - "GET /css/index.css HTTP/1.1" 200
2023-02-20 19:29:18.103  INFO 6593 --- [nio-8080-exec-2] c.e.springlogging.filter.LoggingFilter   : [Post-filter] 127.0.0.1 - "GET /js/index.js HTTP/1.1" 200
2023-02-20 19:29:18.103  INFO 6593 --- [nio-8080-exec-3] c.e.springlogging.filter.LoggingFilter   : [Post-filter] 127.0.0.1 - "GET /css/index.css HTTP/1.1" 200
2023-02-20 19:29:18.112  INFO 6593 --- [nio-8080-exec-4] c.e.springlogging.filter.LoggingFilter   : [Pre-filter] 127.0.0.1 - "GET /favicon.ico HTTP/1.1" 200
2023-02-20 19:29:18.114  INFO 6593 --- [nio-8080-exec-4] c.e.springlogging.filter.LoggingFilter   : [Post-filter] 127.0.0.1 - "GET /favicon.ico HTTP/1.1" 404
```
