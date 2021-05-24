package org.bootcamp.spring.mycashapi.service;

import org.bootcamp.spring.mycashapi.domain.Usuario;
import org.bootcamp.spring.mycashapi.domain.UsuarioRole;
import org.bootcamp.spring.mycashapi.exception.UsuarioException;
import org.bootcamp.spring.mycashapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(EntityNotFoundException::new);
    }

    public void criaUsuarioAdmin(String email, String senha) {
        if (repository.findByEmail(email).isEmpty()) {
            var usuario = new Usuario(email, passwordEncoder.encode(senha), UsuarioRole.ROLE_ADMIN);
            repository.save(usuario);
        }
    }

    public Usuario criaUsuarioUser(String email, String senha) {
        var usuario = new Usuario(email, passwordEncoder.encode(senha), UsuarioRole.ROLE_USER);

        if (repository.findByEmail(email).isPresent())
            throw new UsuarioException("Já existe usuário com este e-mail");
        return repository.save(usuario);
    }

    public Usuario alterarSenha(String email, String senhaAntiga, String senhaNova) {
        var usuario = findByEmail(email);
        if (!passwordEncoder.matches(senhaAntiga, usuario.getSenha()))
            throw new UsuarioException("Senha antiga não confere");
        usuario.setSenha(passwordEncoder.encode(senhaNova));
        return repository.save(usuario);
    }

    public Usuario resetarSenha(String email, String senhaNova) {
        var usuario = findByEmail(email);
        usuario.setSenha(passwordEncoder.encode(senhaNova));
        return repository.save(usuario);
    }
}
