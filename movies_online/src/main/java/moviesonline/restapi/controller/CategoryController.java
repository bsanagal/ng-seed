package moviesonline.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import moviesonline.restapi.entity.MoviesTV;
import moviesonline.restapi.service.MoviesService;

@RestController
@RequestMapping("/category/")
public class CategoryController {

	@Autowired
	MoviesService service;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MoviesTV> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MoviesTV findOne(@PathVariable("id") String movieId) {
		return service.findOne(movieId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{genre}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MoviesTV> findByGenre(@PathVariable("genre") String genre) {
		return service.findGenre(genre);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{type}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MoviesTV> findType(@PathVariable("type") String type) {
		return service.findType(type);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MoviesTV create(@RequestBody MoviesTV movie) {
		return service.create(movie);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MoviesTV update(@PathVariable("id") String movieId, @RequestBody MoviesTV movie) {
		return service.update(movieId, movie);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(@PathVariable("id") String imdbId) {
		service.delete(imdbId);
	}

}
