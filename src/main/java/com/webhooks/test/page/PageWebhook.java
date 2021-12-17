package com.webhooks.test.page;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/test_webhook")
public class PageWebhook {
	
	@GetMapping("/webhook")
	public ResponseEntity webhookVerification(@RequestParam("hub.mode") String mode,
            @RequestParam("hub.verify_token") String verifyToken,
            @RequestParam("hub.challenge") String challenge) {
//		System.out.println("tesiting webhook verfication");
		
		if(verifyToken.equals("webhook_verify_token")) {
			System.out.println("verfication success");
			return ResponseEntity.ok(challenge);
		}else {
			System.out.println("verfication failed");
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}
	

	
	

}
