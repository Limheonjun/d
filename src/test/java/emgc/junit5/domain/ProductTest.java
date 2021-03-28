package emgc.junit5.domain;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

//거의 쓸일이 없임
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ProductTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("테스트 시작");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("테스트 끝");
    }

    @BeforeEach
    void beforEach() {
        System.out.println("===Test Start====");
    }

    @AfterEach
    void afterEach() {
        System.out.println("===Test End===");
    }

    @Test
    @Disabled
    @DisplayName("실행하지 않을 테스트")
    void disabled() {
        Product product = new Product();
        product = null;
        assertNull(product);
    }

    @Test
    void createProduct() {
        Product product = new Product();
        assertNotNull(product);
   }

    @Test
    @DisplayName("사용자가 정의한 이름으로 표기")
    void insertProduct() {
        Product product = new Product();
        product.setName("상품");
        assertEquals(product.getName(), "상품");
    }

    @Test
    @DisplayName("모든 assert 한번에 테스트")
    void testAll() {
        Product product = new Product();
        product.setName("스마트폰");
        assertAll(
                () -> assertNotNull(product),
                () -> assertEquals("스마트폰", product.getName()));
    }

    @Test
    @DisplayName("특정 예외 발생 확인")
    void outOfIndexException() {
        int arr[] = new int[1];
        assertThrows(IndexOutOfBoundsException.class, () -> arr[1] = 2);
    }

    @Test
    @DisplayName("특정 시간 안에 완료되는지 확인")
    void Timeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            for(long i=0; i<1_000_000_000; i++) {
                i++;
            }
        });
    }



}