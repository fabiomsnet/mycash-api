package org.bootcamp.spring.mycashapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usuario", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String email;

    @JsonIgnore
    private String senha;

    @Enumerated(EnumType.STRING)
    private UsuarioRole role;

    public Usuario(String email, String senha, UsuarioRole role) {
        this.email = email;
        this.senha = senha;
        this.role = role;
    }
}
