package gifdetails.controller.repsonse;

import gifdetails.model.UserExtendedDataBlock;

public class UserExtendedDataBlockResponse extends UserExtendedDataBlock {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
