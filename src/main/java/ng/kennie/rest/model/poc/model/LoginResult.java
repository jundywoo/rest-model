package ng.kennie.rest.model.poc.model;

public class LoginResult {
	private int userId;
	private String userName;
	private String entityCode; 

	@Override
	public String toString() {
		return String.format("UserId=[%s] UserNmae=[%s] EntityCode=[%s]", userId, userName, entityCode);
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEntityCode() {
		return entityCode;
	}

	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}
}
