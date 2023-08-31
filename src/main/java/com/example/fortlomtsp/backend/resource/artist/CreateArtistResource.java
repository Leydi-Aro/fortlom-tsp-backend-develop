package com.example.fortlomtsp.backend.resource.artist;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateArtistResource {
    private String username;

    private String realname;

    private String lastname;

    private String email;

    private String password;

    private Long artistfollowers;
}
