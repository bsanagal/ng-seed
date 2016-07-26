package moviesonline.restapi.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import moviesonline.restapi.entity.MoviesTV;
import moviesonline.restapi.exceptions.MovieAlreayExisting;
import moviesonline.restapi.exceptions.MovieNotFound;
import moviesonline.restapi.exceptions.NotValid;
import moviesonline.restapi.repository.MoviesRepository;

@Service
@Transactional
public class MovieServiceImpl implements MoviesService {

	@Autowired
	MoviesRepository repository;

	@Override
	public List<MoviesTV> findAll() {
		return repository.findAll();
	}

	@Override
	public MoviesTV findOne(String movieId) {
		MoviesTV existing = repository.findOne(movieId);
		if (existing == null) {
			throw new MovieNotFound("Movie/TV with id " + movieId + "not found");
		}
		return existing;
	}

	@Override
	public MoviesTV create(MoviesTV movie) {
		MoviesTV existing = repository.findOne(movie.getImdbID());
		if (existing != null) {
			throw new MovieAlreayExisting("This Movie ID is already in use");
		}
		return repository.create(movie);
	}

	@Override
	public MoviesTV update(String movieId, MoviesTV movie) {

		MoviesTV existing = repository.findOne(movieId);
		if (existing == null) {
			throw new MovieNotFound("Movie with id " + movieId + "not found");
		}

		if (movieId != movie.getImdbID()) {
			throw new NotValid("Requested ID doesn't match with to be updated movie ID");
		}
		return repository.update(movie);
	}

	@Override
	public void delete(String imdbId) {
		MoviesTV existing = repository.findOne(imdbId);
		if (existing == null) {
			throw new MovieNotFound("Movie/TV with id " + imdbId + "not found");
		}
		repository.delete(existing);
	}

	@Override
	public List<MoviesTV> findGenre(String genre) {
		// Get the list of all the movies and TV shows
		List<MoviesTV> moviestvList = repository.findAll();

		ArrayList<MoviesTV> genreList = new ArrayList<MoviesTV>();
		Iterator it = moviestvList.iterator();

		// Iterate through the list and check the specific genre
		while (it.hasNext()) {
			MoviesTV element = (MoviesTV) it.next();
			if (element.getGenre().toLowerCase().contains(genre.toLowerCase())) {
				genreList.add(element);
			}
		}
		return genreList;
	}

	@Override
	public List<MoviesTV> findType(String type) {
		List<MoviesTV> typeList = repository.findByType(type);
		return typeList;
	}

}
