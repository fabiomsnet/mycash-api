package org.bootcamp.spring.mycashapi.web.dto;

import lombok.Getter;
import lombok.Setter;
import org.bootcamp.spring.mycashapi.domain.UsuarioRole;

@Getter
@Setter
public class UsuarioDTO {

    private Integer id;

    private String email;

    private UsuarioRole role;

    public boolean isAdmin() {
        return UsuarioRole.ROLE_ADMIN.equals(this.role);
    }

}
