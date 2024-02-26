package hello.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV0 {

    public void external() {
        log.info("call external");
        internal(); // this.internal(); 내부 호출은 proxy를 거치지 않는다.
    }

    public void internal() {
        log.info("call internal");
    }
}
