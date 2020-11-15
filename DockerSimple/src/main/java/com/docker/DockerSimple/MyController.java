package com.docker.DockerSimple;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@GetMapping("/dockerDemo")
	public String dockerDemo()
	{
		System.out.println("This is  Docker");
		return "This IS a Docker Demo !!!";
	}

}
