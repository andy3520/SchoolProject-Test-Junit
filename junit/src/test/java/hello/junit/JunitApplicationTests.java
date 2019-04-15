package hello.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Sử dụng @{@link SpringBootTest} để tìm ứng dụng Spring Boot.
 * Tạo một instance của app để khởi tạo ngữ cảnh(context) test giống như khi chạy một app thực.
 * Giúp kiểm tra xem khởi tạo context hay app có thành công hay không.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JunitApplicationTests {

    @Test
    public void contextLoads() {
    }

}
