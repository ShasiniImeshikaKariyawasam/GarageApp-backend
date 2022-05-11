package com.thecodeveal.app.controllers;

import com.thecodeveal.app.kafka.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AppController {

	@Autowired
	Producer producer;

	@GetMapping
	public String testApp() {
		return "Hello Spring Security!";
	}

	@PutMapping("orderStatusChange")
	public void  sendMessage(@RequestParam("msg") String orderStatusChange) {

		producer.orderStatusChangeTopic(orderStatusChange);
//		producer.orderStatusChangeTopic(orderStatusChange);
//		dataResponse = new DataResponse("msg sent successfully",true);
//		return new ResponseEntity<>(dataResponse,
//				HttpStatus.OK);
	}

}
