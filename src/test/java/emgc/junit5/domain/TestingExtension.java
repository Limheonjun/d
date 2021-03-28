package emgc.junit5.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.junit.jupiter.api.Assertions.*;

//1.선언 - extension 내의 멤버값의 동적 생성이 불가
//@ExtendWith(FindSlowTestExtension.class)
class TestingExtension {

    //2. 주입
    @RegisterExtension
    static FindSlowTestExtension findSlowTestExtension = new FindSlowTestExtension();

    @Test
    void extension() throws InterruptedException {
        Thread.sleep(1005L);
        assertEquals(1,1);
    }

}