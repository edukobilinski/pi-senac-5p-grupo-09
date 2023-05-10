package br.com.senac.backend.resources;

import br.com.senac.backend.dto.CampaignDTO;
import br.com.senac.backend.dto.CampaignInsertDTO;
import br.com.senac.backend.dto.CampaignSavedDTO;
import br.com.senac.backend.dto.CampaignUpdateDTO;
import br.com.senac.backend.services.CampaignService;
import br.com.senac.backend.utils.ContextLog;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static br.com.senac.backend.utils.MessageLogsEnum.*;

@Log
@RestController
@CrossOrigin
@RequestMapping(value = "/campaigns")
public class CampaignResource {

    @Autowired
    private CampaignService campaignService;

    @GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CampaignDTO>> findCampaignByUserId(@PathVariable Long id) {
        var context = ContextLog.builder()
                .classe(Thread.currentThread().getStackTrace()[1].getClassName())
                .metodo(Thread.currentThread().getStackTrace()[1].getMethodName())
                .build();
        log.info(RSC_0001D.logContext(context.getClasse(), context.getMetodo()));

        var userList = campaignService.findCampaignByUserId(id);

        log.info(RSC_0002D.logContext(context.getClasse(), context.getMetodo()));
        return ResponseEntity.ok(userList);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CampaignDTO>> findAll() {
        var context = ContextLog.builder()
                .classe(Thread.currentThread().getStackTrace()[1].getClassName())
                .metodo(Thread.currentThread().getStackTrace()[1].getMethodName())
                .build();
        log.info(RSC_0001D.logContext(context.getClasse(), context.getMetodo()));

        var list = campaignService.findAll();

        log.info(RSC_0002D.logContext(context.getClasse(), context.getMetodo()));
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CampaignDTO> findById(@PathVariable Long id) {
        var context = ContextLog.builder()
                .classe(Thread.currentThread().getStackTrace()[1].getClassName())
                .metodo(Thread.currentThread().getStackTrace()[1].getMethodName())
                .build();
        log.info(RSC_0001D.logContext(context.getClasse(), context.getMetodo()));

        var obj = campaignService.findById(id);

        log.info(RSC_0002D.logContext(context.getClasse(), context.getMetodo()));
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CampaignSavedDTO> insert(@RequestBody CampaignInsertDTO obj) {
        var context = ContextLog.builder()
                .classe(Thread.currentThread().getStackTrace()[1].getClassName())
                .metodo(Thread.currentThread().getStackTrace()[1].getMethodName())
                .build();
        log.info(RSC_0001D.logContext(context.getClasse(), context.getMetodo()));

        var objSaved = campaignService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(objSaved.getId()).toUri();

        log.info(RSC_0003D.getObjDescription(uri.toString()));
        log.info(RSC_0002D.logContext(context.getClasse(), context.getMetodo()));
        return ResponseEntity.created(uri).body(objSaved);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        var context = ContextLog.builder()
                .classe(Thread.currentThread().getStackTrace()[1].getClassName())
                .metodo(Thread.currentThread().getStackTrace()[1].getMethodName())
                .build();
        log.info(RSC_0001D.logContext(context.getClasse(), context.getMetodo()));

        campaignService.delete(id);

        log.info(RSC_0004D.getObjDescription(id.toString()));
        log.info(RSC_0002D.logContext(context.getClasse(), context.getMetodo()));
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CampaignSavedDTO> update(@PathVariable Long id, @RequestBody CampaignUpdateDTO obj) {
        var context = ContextLog.builder()
                .classe(Thread.currentThread().getStackTrace()[1].getClassName())
                .metodo(Thread.currentThread().getStackTrace()[1].getMethodName())
                .build();
        log.info(RSC_0001D.logContext(context.getClasse(), context.getMetodo()));

        var objUpdated = campaignService.update(id, obj);

        log.info(RSC_0005D.getObjDescription(obj.toString()));
        log.info(RSC_0002D.logContext(context.getClasse(), context.getMetodo()));
        return ResponseEntity.ok().body(objUpdated);
    }

}
