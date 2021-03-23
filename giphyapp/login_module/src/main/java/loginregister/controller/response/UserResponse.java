package loginregister.controller.response;

import loginregister.model.User;

public class UserResponse extends User {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
