package moviesonline.restapi.service;

import java.util.List;

import moviesonline.restapi.entity.MoviesTV;

public interface MoviesService {

	List<MoviesTV> findAll();

	MoviesTV findOne(String movieId);

	MoviesTV create(MoviesTV movie);

	MoviesTV update(String movieId, MoviesTV movie);

	void delete(String imdbId);

	List<MoviesTV> findGenre(String genre);

	List<MoviesTV> findType(String type);

}
