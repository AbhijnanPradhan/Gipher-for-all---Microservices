package recommend.controller;


import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import recommend.controller.response.ExtendedDataBlockResponse;
import recommend.controller.response.ResponseMessages;
import recommend.model.DataBlock;
import recommend.model.ExtendedDataBlock;
import recommend.service.RecommendedService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/recommended")
public class RecommendedController {

	private RecommendedService recommendedService;

	@Autowired
	public RecommendedController(RecommendedService recommendedService) {
		this.recommendedService = recommendedService;
	}
	
	@GetMapping("/test")
	public String getTest() {
		return "hello";
	}

	@GetMapping("/get")
	public ResponseEntity<List<ExtendedDataBlock>> getRecommended(@RequestParam String userId) {
		try {
			List<ExtendedDataBlock> list = recommendedService.getRecommends(userId);
			return ResponseEntity.ok(list);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/add")
	public ResponseEntity<?> addRecommended(@RequestParam String userId, @RequestBody DataBlock data) {
		System.out.println(data);
		try {
			ExtendedDataBlockResponse response = new ExtendedDataBlockResponse();
			ExtendedDataBlock resultBlock = recommendedService.addRecommend(userId, data);

			if (resultBlock != null) {
				BeanUtils.copyProperties(resultBlock, response);
				response.setMessage(ResponseMessages.SUCCESS);
			} else {
				response.setMessage(ResponseMessages.RECOMMENDATION_EXISTS);
			}
			return ResponseEntity.ok(response);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping("/remove")
	public ResponseEntity<?> removeRecommended(@RequestParam String userId, @RequestBody DataBlock data) {
		System.out.println(data);
		try {
			ExtendedDataBlockResponse response = new ExtendedDataBlockResponse();
			ExtendedDataBlock resultBlock = recommendedService.removeRecommend(userId, data);

			if (resultBlock != null) {
				BeanUtils.copyProperties(resultBlock, response);
				response.setMessage(ResponseMessages.SUCCESS);
			} else {
				response.setMessage(ResponseMessages.RECOMMENDATION_NOT_EXISTS);
			}
			return ResponseEntity.ok(response);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
