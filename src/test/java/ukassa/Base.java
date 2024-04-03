package ukassa;

import org.junit.jupiter.api.AfterEach;

import java.util.concurrent.TimeUnit;


public class Base {

    @AfterEach
    void afteEach() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5000);
    }


}
