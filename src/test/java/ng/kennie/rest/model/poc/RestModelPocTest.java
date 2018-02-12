package ng.kennie.rest.model.poc;

import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import ng.kennie.rest.model.poc.model.RequestModel;

@Import(Application.class)
@RunWith(SpringRunner.class)
public class RestModelPocTest {

	@Test
	public void testPostMethod() throws URISyntaxException {
		final RequestModel request = new RequestModel();
		request.setId("1");
		request.setValue("abc");

		final RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject("http://localhost:8080", request, String.class, new Object[0]);
	}

}
