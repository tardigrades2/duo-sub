package app.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import app.dao.GenericDAO;
import app.dao.MovieDAO;
import app.model.Movie;

public class MovieDAOImpl extends GenericDAO<Integer, Movie> implements MovieDAO {

  public MovieDAOImpl() {
    super(Movie.class);
  }

  public MovieDAOImpl(SessionFactory sessionfactory) {
    setSessionFactory(sessionfactory);
  }

  public void addMovie(Movie movie) {
    getSession().saveOrUpdate(movie);
  }

  public Movie findByTitle(String title) {
    return getSession().get(Movie.class, title);
  }

  @SuppressWarnings("unchecked")
  public List<Movie> loadAll() {
    return getSession().createQuery("from Movie").getResultList();
  }
}
