package org.bootcamp.spring.mycashapi.web.api;

import org.bootcamp.spring.mycashapi.web.dto.UsuarioDTO;
import org.modelmapper.ModelMapper;

import org.bootcamp.spring.mycashapi.domain.Usuario;
import org.bootcamp.spring.mycashapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UsuarioDTO> usuarios() {
        List<Usuario> usuarios = usuarioService.findAll();
        return usuarios
                .stream()
                .map(usuario -> mapper.map(usuario, UsuarioDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{email}")
    @PreAuthorize("#email == authentication.getName() or hasRole('ROLE_ADMIN')")
    public Usuario usuarioPorEmail(@PathVariable("email") String email) {
        return usuarioService.findByEmail(email);
    }

    @PostMapping
    public Usuario criar(
            @RequestParam(required = true) String email,
            @RequestParam(required = true) String senha) {

        return usuarioService.criaUsuarioUser(email, senha);
    }

    @PutMapping("/{email}")
    @PreAuthorize("#email == authentication.getName()")
    public Usuario alterarSenha(
            @PathVariable("email") String email,
            @RequestParam(required = true) String senhaAntiga,
            @RequestParam(required = true) String senhaNova) {
        return usuarioService.alterarSenha(email, senhaAntiga, senhaNova);
    }

    @PutMapping("/reset/{email}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Usuario resetarSenha(
            @PathVariable("email") String email,
            @RequestParam(required = true) String senhaNova) {
        return usuarioService.resetarSenha(email, senhaNova);
    }

}
