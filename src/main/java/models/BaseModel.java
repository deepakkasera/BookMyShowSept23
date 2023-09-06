package models;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseModel {
    @Id
    private Long id; // Primary Key
    private Date createdAt;
    private Date lastModifiedAt;
}
