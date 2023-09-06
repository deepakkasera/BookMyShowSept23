package models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Region extends BaseModel { //City.
    private String name;

    //private List<Theatre> theatres; /// Depends on access pattern.
}
