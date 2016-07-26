package moviesonline.restapi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import moviesonline.restapi.entity.MoviesTV;

@Repository
public class MoviesRepositoryImpl implements MoviesRepository {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<MoviesTV> findAll() {
		TypedQuery<MoviesTV> query = em.createQuery("SELECT m from MoviesTV m ORDER BY m.Year", MoviesTV.class);
		return query.getResultList();
	}

	@Override
	public MoviesTV findOne(String movieId) {
		MoviesTV movietv = em.find(MoviesTV.class, movieId);
		return movietv;
	}

	@Override
	public List<MoviesTV> findByType(String type) {
		TypedQuery<MoviesTV> query = em.createNamedQuery("moviestv.findByType", MoviesTV.class);
		query.setParameter("pType", type);
		List<MoviesTV> moviestv = query.getResultList();
		return moviestv;
	}

	@Override
	public MoviesTV create(MoviesTV movie) {
		em.persist(movie);
		return movie;
	}

	@Override
	public MoviesTV update(MoviesTV movie) {
		return em.merge(movie);
	}

	@Override
	public void delete(MoviesTV existing) {
		em.remove(existing);
	}
}
