package ng.kennie.rest.model.poc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ng.kennie.com.hsbc.hk.hbap.spoms.bnd.vo.ProductBondVo;
import ng.kennie.rest.model.poc.model.LoginInfo;
import ng.kennie.rest.model.poc.model.LoginResult;
import ng.kennie.rest.model.poc.service.RestMethodService;

public class SpomsSessionBeanClient {

	public static void main(String[] args) {
		login();
		getProductIdListPerEntity();
	}

	private static LoginInfo loginInfo = new LoginInfo("WMSUSR01", "abc123");

	private static void login() {
		RestMethodService<LoginResult> proxy = new RestMethodService<>(
				"http://localhost:9085/spoms/sessionBean/approvalManager/login.session", loginInfo, LoginResult.class);
		LoginResult result = proxy.postRest(null);
		System.out.println(result);
	}

	private static void getProductIdListPerEntity() {
		RestMethodService<List<ProductBondVo>> proxy = new RestMethodService<>(
				"http://localhost:9085/spoms/sessionBean/bondManager/getProductIdListPerEntity.session", loginInfo, List.class,
				ProductBondVo.class);
		Map<String, String> params = new HashMap<String, String>();
		params.put("entityCode", "HSBC-HK-PFS");

		List<ProductBondVo> resultList = proxy.getRest(params);
		resultList.forEach(result -> System.out.println(result));
		System.out.println(resultList.size());
	}

}
