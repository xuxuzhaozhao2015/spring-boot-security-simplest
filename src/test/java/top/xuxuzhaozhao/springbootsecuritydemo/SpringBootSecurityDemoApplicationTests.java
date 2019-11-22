package top.xuxuzhaozhao.springbootsecuritydemo;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootSecurityDemoApplicationTests {

    @Test
    void contextLoads() {

        Observable<String> myStrings = Observable.just("apple","orange","grape");

        myStrings.map(s -> s.length()).subscribe(s-> System.out.println(s));
    }

}
