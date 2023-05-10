package br.com.senac.backend.services;

import br.com.senac.backend.dto.UserLoggedDTO;
import br.com.senac.backend.entities.User;
import br.com.senac.backend.exceptions.DatabaseException;
import br.com.senac.backend.exceptions.ResourceNotFoundException;
import br.com.senac.backend.repositories.UserRepository;
import br.com.senac.backend.utils.ContextLog;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static br.com.senac.backend.utils.MessageLogsEnum.*;

@Log
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        var context = ContextLog.builder()
                .classe(Thread.currentThread().getStackTrace()[1].getClassName())
                .metodo(Thread.currentThread().getStackTrace()[1].getMethodName())
                .build();
        var list = userRepository.findAll();

        log.info(SRV_0001D.logContext(context.getClasse(), context.getMetodo()));

        return list;
    }

    public User findById(Long id) {
        var context = ContextLog.builder()
                .classe(Thread.currentThread().getStackTrace()[1].getClassName())
                .metodo(Thread.currentThread().getStackTrace()[1].getMethodName())
                .build();
        var obj = userRepository.findById(id);

        if (!obj.isEmpty()) {
            log.info(SRV_0001D.logContext(context.getClasse(), context.getMetodo()));
        } else {
            log.severe(SRV_0001E.getObjDescription(id.toString()));
        }
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
        var context = ContextLog.builder()
                .classe(Thread.currentThread().getStackTrace()[1].getClassName())
                .metodo(Thread.currentThread().getStackTrace()[1].getMethodName())
                .build();

        var objSaved = userRepository.save(obj);
        if (objSaved != null) {
            log.info(SRV_0001D.logContext(context.getClasse(), context.getMetodo()));
        }
        return objSaved;
    }

    public void delete(Long id) {
        var context = ContextLog.builder()
                .classe(Thread.currentThread().getStackTrace()[1].getClassName())
                .metodo(Thread.currentThread().getStackTrace()[1].getMethodName())
                .build();
        try {
            userRepository.deleteById(id);
            log.info(SRV_0001D.logContext(context.getClasse(), context.getMetodo()));
        } catch (EmptyResultDataAccessException e) {
            log.severe(SRV_0001E.getObjDescription(id.toString()));
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            log.severe(SRV_0002E.getDescriptionAndException(e.getMessage()));
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj) {
        var context = ContextLog.builder()
                .classe(Thread.currentThread().getStackTrace()[1].getClassName())
                .metodo(Thread.currentThread().getStackTrace()[1].getMethodName())
                .build();
        try {
            User entity = userRepository.getReferenceById(id);

            updateData(entity, obj);

            var objSaved = userRepository.save(entity);

            if (objSaved != null) {
                log.info(SRV_0001D.logContext(context.getClasse(), context.getMetodo()));
            }
            return objSaved;
        } catch (EntityNotFoundException e) {
            log.severe(SRV_0001E.getObjDescription(id.toString()));
            throw new ResourceNotFoundException(id);
        }
    }

    public UserLoggedDTO userLogIn(Long idUser, String password){
        var user = findById(idUser);
        if (user.getPassword().equals(password)){
            return UserLoggedDTO.builder().active(true).build();
        } else {
            return UserLoggedDTO.builder().active(false).build();
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setCpf(obj.getCpf());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
        entity.setPassword(obj.getPassword());
        entity.setZipCode(obj.getZipCode());
        entity.setAddress(obj.getAddress());
        entity.setCity(obj.getCity());
        entity.setState(obj.getState());
        entity.setCountry(obj.getCountry());
    }

}
