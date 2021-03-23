package favourite.controller;

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

import favourite.controller.response.ExtendedDataBlockResponse;
import favourite.controller.response.MessageResponse;
import favourite.controller.response.ResponseMessages;
import favourite.model.DataBlock;
import favourite.model.ExtendedDataBlock;
import favourite.service.FavoritesService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/favorites")
public class FavouritesController {

	private FavoritesService favoriteService;

	@Autowired
	public FavouritesController(FavoritesService favoriteService) {
		this.favoriteService = favoriteService;
	}
	
	@GetMapping("/test")
	public String getTest() {
		return "hello";
	}

	@GetMapping("/get")
	public ResponseEntity<List<ExtendedDataBlock>> getAllFavorites(@RequestParam String userId) {
		try {
			System.out.println("get method");
			List<ExtendedDataBlock> list = favoriteService.getAllFavoritesOfUser(userId);
			return ResponseEntity.ok(list);

		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/add")
	public ResponseEntity<?> addFavorite(@RequestParam String userId, @RequestBody DataBlock data) {
		try {
			if (favoriteService.addFavoriteToUser(userId, data) == null) {
				// favorites already exists then returns string
				return ResponseEntity.ok(new MessageResponse(ResponseMessages.FAVORITES_EXISTS));
			}
			// favorites added and returns status '202'
			ExtendedDataBlockResponse response = new ExtendedDataBlockResponse();
			BeanUtils.copyProperties(data, response);
			response.setMessage(ResponseMessages.SUCCESS);
			return ResponseEntity.ok(response);

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/remove")
	public ResponseEntity<?> removeFavorite(@RequestParam String userId, @RequestBody DataBlock data) {
		try {
			ExtendedDataBlock block = favoriteService.removeFavoriteFromUser(userId, data);
			if (block != null) {
				ExtendedDataBlockResponse response = new ExtendedDataBlockResponse();
				BeanUtils.copyProperties(block, response);
				response.setMessage(ResponseMessages.SUCCESS);
				return ResponseEntity.ok(response);
			} else
				return ResponseEntity.ok(new MessageResponse(ResponseMessages.FAVORITES_NOT_EXISTS));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}