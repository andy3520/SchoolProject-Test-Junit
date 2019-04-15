package hello.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * webEnvironment=RANDOM_PORT để start server trên một port ngẫu nhiên
 * tránh trường hợp bị đụng port app hoặc test khác
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    /* Truyền port start test vào */
    @LocalServerPort
    private int port;

    /* Template do Spring boot cung cấp để test rest api */
    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * Tạo một HttpRequest tới route "/"
     * Test thành công
     */
    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class))
                .contains("Hello World");
    }

    /**
     * Test thất bại
     */
    @Test
    public void greetingShouldFail() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class))
                .contains("Hello Andy");
    }
}
