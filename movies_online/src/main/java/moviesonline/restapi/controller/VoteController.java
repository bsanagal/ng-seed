package moviesonline.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import moviesonline.restapi.service.MoviesService;

@RestController
@RequestMapping("/mostvoted")
public class VoteController {

	@Autowired
	MoviesService service;

	
}
