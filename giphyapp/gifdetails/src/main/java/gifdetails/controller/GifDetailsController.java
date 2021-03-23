package gifdetails.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gifdetails.controller.repsonse.MessageResponse;
import gifdetails.controller.repsonse.UserExtendedDataBlockResponse;
import gifdetails.controller.response.AllGifDetailsResponse;
import gifdetails.controller.response.ResponseMessages;
import gifdetails.model.UserExtendedDataBlock;
import gifdetails.service.GifDetailsService;


//@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/gif")
public class GifDetailsController {

	private GifDetailsService gifDetailsService;

	@Autowired
	public GifDetailsController(GifDetailsService gifDetailsService) {
		this.gifDetailsService = gifDetailsService;
	}
	
	@GetMapping("/test")
	public String getTest() {
		return "hello";
	}
	
	@GetMapping("/details")
	public ResponseEntity<?> getDetails(@RequestParam String userId,
			@RequestParam(required = false, defaultValue = "") String gifId) {
		if (gifId.equals("")) {
			AllGifDetailsResponse response = gifDetailsService.getAll(userId);
			return ResponseEntity.ok(response);
		} else {
			UserExtendedDataBlock resultBlock = gifDetailsService.getDetails(userId, gifId);
			UserExtendedDataBlockResponse response = new UserExtendedDataBlockResponse();
			if (resultBlock != null) {
				BeanUtils.copyProperties(resultBlock, response);
				response.setMessage(ResponseMessages.SUCCESS);
				return ResponseEntity.ok(response);
			} else {
				return ResponseEntity.ok(new MessageResponse(ResponseMessages.FAILURE));
			}
		}
	}
}
