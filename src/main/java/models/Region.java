package models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Region extends BaseModel { //City.
    private String name;

    //private List<Theatre> theatres; /// Depends on access pattern.
}
