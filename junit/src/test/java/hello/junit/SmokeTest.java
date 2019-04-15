package hello.junit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

    @Autowired
    private HomeController controller;

    /**
     * Tiếp theo, sau khi test khởi tạo instance app và context thành công.
     * Test app có tạo thành công controller hay không.
     * @throws Exception nếu tạo không thành công.
     */
    @Test
    public void contextLoads() throws Exception {
         /* Kiểm tra việc tạo controller với dependency injection có thành công không. */
        assertThat(controller).isNotNull();
    }
}