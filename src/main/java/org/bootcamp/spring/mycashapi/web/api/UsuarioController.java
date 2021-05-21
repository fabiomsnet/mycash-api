package org.bootcamp.spring.mycashapi.web.api;

import org.bootcamp.spring.mycashapi.domain.Usuario;
import org.bootcamp.spring.mycashapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> usuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/{email}")
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
    public Usuario trocarSenha(
            @PathVariable("email") String email,
            @RequestParam(required = true) String senhaAntiga,
            @RequestParam(required = true) String senhaNova) {
        return usuarioService.alterarSenha(email, senhaAntiga, senhaNova);
    }

}
