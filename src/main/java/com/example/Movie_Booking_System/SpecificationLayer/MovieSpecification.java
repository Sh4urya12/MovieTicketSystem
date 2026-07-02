package com.example.Movie_Booking_System.SpecificationLayer;

import com.example.Movie_Booking_System.ClassLayer.Movie;
import com.example.Movie_Booking_System.DTOlayer.SearchAndFilterDTO;

import org.springframework.data.jpa.domain.Specification;

public class MovieSpecification
{

    public static Specification<Movie> filterMovies(SearchAndFilterDTO dto)
    {
        return (root, query, criteriaBuilder) ->
        {
            var predicate = criteriaBuilder.conjunction();

            if(dto.getMovieName() != null && !dto.getMovieName().isEmpty())
            {
                predicate.getExpressions().add(criteriaBuilder.like(criteriaBuilder.lower(root.get("movieName")),
                        "%" + dto.getMovieName().toLowerCase() + "%" ) );
            }

            if(dto.getGenre() != null && !dto.getGenre().isEmpty())
            {
                predicate.getExpressions().add(criteriaBuilder.equal(criteriaBuilder.lower(root.get("genre")),
                        dto.getGenre().toLowerCase()));
            }

            if(dto.getLanguage() != null && !dto.getLanguage().isEmpty())
            {
                predicate.getExpressions().add( criteriaBuilder.equal( criteriaBuilder.lower(root.get("language") ),
                        dto.getLanguage().toLowerCase() ) );
            }

            if(dto.getMinPrice() != null)
            {
                predicate.getExpressions().add( criteriaBuilder.greaterThanOrEqualTo(root.get("ticketPrice"),
                        dto.getMinPrice() ) );
            }

            if(dto.getMaxPrice() != null)
            {
                predicate.getExpressions().add( criteriaBuilder.lessThanOrEqualTo(root.get("ticketPrice"),
                        dto.getMaxPrice() ) );
            }

            if(dto.getMinDuration() != null)
            {
                predicate.getExpressions().add( criteriaBuilder.greaterThanOrEqualTo(root.get("duration"),
                        dto.getMinDuration() ) );
            }

            if(dto.getMaxDuration() != null)
            {
                predicate.getExpressions().add( criteriaBuilder.lessThanOrEqualTo(root.get("duration"),
                        dto.getMaxDuration() ) );
            }

            if(dto.getAvailableSeats() != null)
            {
                predicate.getExpressions().add(criteriaBuilder.greaterThanOrEqualTo(root.get("availableSeats"),
                        dto.getAvailableSeats() ) );
            }
            return predicate;
        };
    }
}
