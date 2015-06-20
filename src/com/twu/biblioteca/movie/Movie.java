package com.twu.biblioteca.movie;

import com.twu.biblioteca.BorrowableItem;

public abstract class Movie implements BorrowableItem {
    protected String name;
    protected String year;
    protected String director;
    protected String rating;

    public Movie(String name, String year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;

        Movie movie = (Movie) o;

        return !(name != null ? !name.equals(movie.name) : movie.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public boolean isSameItem(String movieName) {
        return name.equals(movieName);
    }
}
