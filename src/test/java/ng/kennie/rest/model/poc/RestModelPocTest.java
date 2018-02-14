package ng.kennie.rest.model.poc;

import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import ng.kennie.rest.model.poc.model.RequestModel;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class RestModelPocTest {

	@Test
	public void testPostMethod() throws URISyntaxException {
		final RequestModel request = new RequestModel();
		request.setId("1");
		request.setValue("abc");
//		Gson gson = new Gson();
//		String jsonString = gson.toJson(request);

		final RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject("http://localhost:8080/pocPostObject", request, String.class);
	}

}
