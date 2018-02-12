package ng.kennie.rest.model.poc.model;

public class RequestModel {
	private String id;
	private String value;

	@Override
	public String toString() {
		return "Id=" + id + ", Value=" + value;
	}

	public String getId() {
		return this.id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(final String value) {
		this.value = value;
	}
}
