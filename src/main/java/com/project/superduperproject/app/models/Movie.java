package com.project.superduperproject.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "_movies_")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @SequenceGenerator(
            name = "sequence_movie",
            sequenceName = "sequence_movie",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "sequence_movie",
            strategy = GenerationType.SEQUENCE
    )
    private Long idMovie;
    private String nameMovie;
    private LocalDate releaseDate;
    private String genre;
    private String description;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Review> reviewList;

}
