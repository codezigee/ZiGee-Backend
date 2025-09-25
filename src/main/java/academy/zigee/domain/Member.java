package academy.zigee.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Member {

    @Id
    private Integer id;

    private String name;

    private String loginType;

    private String profileImageUrl;

    private String role;

    private Date joinDate;

    private Date updatedAt;

}
