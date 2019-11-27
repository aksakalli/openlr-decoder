package org.openlr.openlrdecoder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DecoderControllerTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void decodingToJSON() throws Exception {
        String url = "http://localhost:" + port + "/?data=CwRbWyNG9RpsCQCb/jsbtAT/6/+jK1lE ";
        String response = this.restTemplate.getForObject(url, String.class);
        System.out.println(response);
    }

    @Test
    public void decodingToXML() throws Exception {
        String url = "http://localhost:" + port + "/xml?data=CwRbWyNG9RpsCQCb/jsbtAT/6/+jK1lE ";
        String response = this.restTemplate.getForObject(url, String.class);
        System.out.println(response);
    }
}
