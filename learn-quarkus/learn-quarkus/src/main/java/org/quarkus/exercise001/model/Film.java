package org.quarkus.exercise001.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "film", schema = "sakila")
public class Film {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "film_id")
    private short filmId;

    @Basic
    @Column(name = "title")
    private String title;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "release_year")
    private Object releaseYear;

    @Basic
    @Column(name = "language_id")
    private short languageId;

    @Basic
    @Column(name = "original_language_id")
    private Short originalLanguageId;

    @Basic
    @Column(name = "rental_duration")
    private short rentalDuration;

    @Basic
    @Column(name = "rental_rate")
    private BigDecimal rentalRate;

    @Basic
    @Column(name = "length")
    private Short length;

    @Basic
    @Column(name = "replacement_cost")
    private BigDecimal replacementCost;

    @Basic
    @Column(name = "rating", columnDefinition = "enum('G', 'PG', 'PG-13', 'R', 'NC-17')")
    private Object rating;

    @Basic
    @Column(name = "special_features", columnDefinition = "enum('Trailers', 'Commentaries', 'Deleted Scenes', 'Behind the Scenes')")
    private Object specialFeatures;

    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "film_actor",
            joinColumns = { @JoinColumn(name = "film_id") },
            inverseJoinColumns = { @JoinColumn(name = "actor_id")}
    )
    private List<Actor> actors = new ArrayList<>();


    public short getFilmId() {
        return filmId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Object releaseYear) {
        this.releaseYear = releaseYear;
    }

    public short getLanguageId() {
        return languageId;
    }

    public void setLanguageId(short languageId) {
        this.languageId = languageId;
    }

    public Short getOriginalLanguageId() {
        return originalLanguageId;
    }

    public void setOriginalLanguageId(Short originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
    }

    public short getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(short rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Short getLength() {
        return length;
    }

    public void setLength(Short length) {
        this.length = length;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public Object getRating() {
        return rating;
    }

    public void setRating(Object rating) {
        this.rating = rating;
    }

    public Object getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(Object specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
