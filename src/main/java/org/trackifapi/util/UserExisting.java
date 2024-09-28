package org.trackifapi.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trackifapi.modal.repository.UserDefaultRepository;
import org.trackifapi.modal.repository.UsuarioChildRepository;

@Service
public class UserExisting {
    @Autowired
    private UserDefaultRepository userDefaultRepository;

    @Autowired
    private UsuarioChildRepository usuarioChildRepository;

    public boolean userExists(String cpf, String rg, String telefone, String email) {
        return userDefaultRepository.findByCpf(cpf).isPresent() || usuarioChildRepository.findByCpf(cpf).isPresent() ||
                userDefaultRepository.findByRg(rg).isPresent() || usuarioChildRepository.findByRg(rg).isPresent() ||
                userDefaultRepository.findByTelefone(telefone).isPresent() || usuarioChildRepository.findByTelefone(telefone).isPresent() ||
                userDefaultRepository.findByEmail(email).isPresent() || usuarioChildRepository.findByEmail(email).isPresent();
    }
}
