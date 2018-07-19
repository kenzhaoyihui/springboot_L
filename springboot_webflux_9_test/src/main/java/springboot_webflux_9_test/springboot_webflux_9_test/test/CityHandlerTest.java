package springboot_webflux_9_test.springboot_webflux_9_test.test;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import springboot_webflux_9_test.springboot_webflux_9_test.domain.City;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CityHandlerTest {

    @Autowired
    private WebTestClient webTestClient;

    private static Map<String, City> cityMap = new HashMap<>();

    @BeforeClass
    public static void setup() {
        City city = new City();
        city.setId(1L);
        city.setProvinceId(2L);
        city.setCityName("Nanjing");
        city.setDescription("Nanjing is a nice City1");
        cityMap.put("Nanjing", city);
    }

    @Test
    public void testSave() {
        City city = webTestClient.post().uri("/city")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(cityMap.get("Nanjing")))
                .exchange()
                .expectStatus().isOk()
                .expectBody(City.class).returnResult().getResponseBody();

        Assert.assertNotNull(city);
        Assert.assertEquals(city.getId(), cityMap.get("Nanjing").getId());
        Assert.assertEquals(city.getCityName(), cityMap.get("Nanjing").getCityName());
    }
}
