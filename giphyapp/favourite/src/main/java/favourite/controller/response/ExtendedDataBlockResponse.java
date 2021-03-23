package favourite.controller.response;

import favourite.model.ExtendedDataBlock;

public class ExtendedDataBlockResponse extends ExtendedDataBlock {
	private String message;

	public ExtendedDataBlockResponse() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
