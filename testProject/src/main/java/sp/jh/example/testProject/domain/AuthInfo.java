package sp.jh.example.testProject.domain;

public class AuthInfo {
	private String id;
	private String name;
	public AuthInfo(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}
}
