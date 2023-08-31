package com.example.fortlomtsp.backend.domain.model.entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@With
@AllArgsConstructor
@Table(name="images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String imagenUrl;

    private String imagenId;

    @ManyToOne(targetEntity = UserAccount.class)
    @JoinColumn(name = "userid")
    private UserAccount userAccount;

    @ManyToOne(targetEntity = Publication.class)
    @JoinColumn(name = "publicationid")
    private Publication publication;


}
