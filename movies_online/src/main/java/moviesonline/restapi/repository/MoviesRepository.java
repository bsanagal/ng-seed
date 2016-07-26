package moviesonline.restapi.repository;

import java.util.List;

import moviesonline.restapi.entity.MoviesTV;

public interface MoviesRepository {

	List<MoviesTV> findAll();

	MoviesTV findOne(String movieId);

	List<MoviesTV> findByType(String type);

	MoviesTV create(MoviesTV movie);

	MoviesTV update(MoviesTV movie);

	void delete(MoviesTV existing);

}
