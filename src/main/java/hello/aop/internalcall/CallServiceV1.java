package hello.aop.internalcall;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV1 {

//    @Autowired
    private CallServiceV1 callServiceV1;

    /**
     * 스프링 부트 2.6 릴리즈 노트를 확인해보니 순환 참조를 기본적으로 금지하도록 변경되었습니다.
     * application.properties 파일에 다음을 추가해야합니다.
     * spring.main.allow-circular-references=true
     */
    // constructor 는 순환참조 생성X
    @Autowired
    public void setCallServiceV1(CallServiceV1 callServiceV1) {
        log.info("callServiceV1 setter={}", callServiceV1.getClass());
        this.callServiceV1 = callServiceV1;
    }

    public void external() {
        log.info("call external");
        callServiceV1.internal();
    }

    public void internal() {
        log.info("call internal");
    }
}
