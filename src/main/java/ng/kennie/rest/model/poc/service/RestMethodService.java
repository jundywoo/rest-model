package ng.kennie.rest.model.poc.service;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ng.kennie.rest.model.poc.SpomsSessionBeanClient;
import ng.kennie.rest.model.poc.model.LoginInfo;

public class RestMethodService<T> {

	public static final String SPOMS_LOGIN_PARAM = "X-SPOMS-Login";
	public static final String SPOMS_PASSWORD_PARAM = "X-SPOMS-Password";

	private static final Logger LOG = LoggerFactory.getLogger(SpomsSessionBeanClient.class);
	private static final Gson GSON = new Gson();
	private static final Map<String, String> EMPTY_PARAMS = new HashMap<String, String>();


	private String url;
	private Class<?> clazz;
	private Class<?> rawClazz;
	private Class<?>[] elementClazz;
	private LoginInfo loginInfo;
	
	protected RestMethodService(String url, LoginInfo loginInfo) {
		this.url = url;
		this.loginInfo = loginInfo;		
	}

	public RestMethodService(String url, LoginInfo loginInfo, Class<?> clazz) {
		this(url, loginInfo);
		this.clazz = clazz;
	}
	
	public RestMethodService(String url, LoginInfo loginInfo, Class<?> rawClazz, Class<?>... elementclazz) {
		this(url, loginInfo);
		this.rawClazz = rawClazz;
		this.elementClazz = elementclazz;
	}

	public T getRest() {
		return getRest(EMPTY_PARAMS);
	}

	public T getRest(Map<String, String> requestParams) {
		return doRequest(HttpMethod.GET, requestParams, null);
	}

	public T postRest(Object requestObject) {
		return postRest(EMPTY_PARAMS, requestObject);
	}

	public T postRest(Map<String, String> requestParams, Object requestObject) {
		return doRequest(HttpMethod.POST, requestParams, requestObject);
	}

	private T doRequest(HttpMethod httpMethod, Map<String, String> requestParams, Object requestObject) {
		String expendedUrl = expendUrl(requestParams);
		if (LOG.isDebugEnabled()) {
			LOG.debug("Get Method requesting to {}, params: {}", expendedUrl, requestParams);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set(SPOMS_LOGIN_PARAM, loginInfo.getLogin());
		headers.set(SPOMS_PASSWORD_PARAM, Base64.getEncoder().encodeToString(loginInfo.getPassword().getBytes()));

		HttpEntity<Object> entityReq = new HttpEntity<Object>(requestObject, headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> responseEntity = restTemplate.exchange(expendedUrl, httpMethod, entityReq, String.class, requestParams);

		String jsonString = responseEntity.getBody();
		if (LOG.isDebugEnabled()) {
			LOG.debug("Return: {}", jsonString);
		}

		return fromJson(jsonString);
	}

	private String expendUrl(Map<String, String> params) {
		if (params != null && !params.isEmpty()) {
			StringBuilder builder = new StringBuilder(url);
			builder.append('?');
			for (String key : params.keySet()) {
				builder.append(key).append("={").append(key).append("}&");
			}
			builder.deleteCharAt(builder.length() - 1);
			return builder.toString();
		} else {
			return url;
		}
	}

	private T fromJson(String jsonString) {
		if (StringUtils.isNotBlank(jsonString)) {
			Type type = (rawClazz == null) ? TypeToken.getParameterized(clazz).getType() : TypeToken.getParameterized(rawClazz, elementClazz).getType(); 
			T result = GSON.fromJson(jsonString, type);

			return result;
		} else {
			return null;
		}
	}
}
