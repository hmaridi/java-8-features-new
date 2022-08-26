
package com.java8.demo.files;

import java.util.HashSet;
import java.util.Set;

public class Movie {
	private String title;
	private int releaseYear;

	private Set<Actor> actors = new HashSet<>();

	public Movie(String title, int releaseYear) {
		this.title = title;
		this.releaseYear = releaseYear;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

	public void addActor(Actor actor) {
        this.actors.add(actor) ;
    }
	
	@Override
	public String toString() {
		return "Movie{" + "title=" + title + ", releaseYear=" + releaseYear + ", actors=" + actors + '}';
	}
}
