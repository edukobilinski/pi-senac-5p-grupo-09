package br.com.senac.backend.services;

import br.com.senac.backend.dto.CampaignDTO;
import br.com.senac.backend.dto.CampaignInsertDTO;
import br.com.senac.backend.dto.CampaignSavedDTO;
import br.com.senac.backend.dto.CampaignUpdateDTO;
import br.com.senac.backend.entities.Campaign;
import br.com.senac.backend.exceptions.DatabaseException;
import br.com.senac.backend.exceptions.ResourceNotFoundException;
import br.com.senac.backend.mappers.CampaignMapper;
import br.com.senac.backend.repositories.CampaignRepository;
import br.com.senac.backend.utils.ContextLog;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.senac.backend.utils.MessageLogsEnum.*;

@Log
@Service
public class CampaignService {

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private CampaignMapper campaignMapper;

    public List<CampaignDTO> findCampaignByUserId(Long id) {
        var context = ContextLog.builder()
                .classe(Thread.currentThread().getStackTrace()[1].getClassName())
                .metodo(Thread.currentThread().getStackTrace()[1].getMethodName())
                .build();
        var list = campaignRepository.findCampaignByUser_Id(id)
                .stream().map(c -> campaignMapper.mapToDTO(c)).collect(Collectors.toList());

        if (!list.isEmpty()) {
            log.info(SRV_0001D.logContext(context.getClasse(), context.getMetodo()));
        } else {
            log.severe(SRV_0003E.getObjDescription(id.toString()));
            throw new ResourceNotFoundException(id);
        }

        return list;
    }

    public List<CampaignDTO> findAll() {
        var context = ContextLog.builder()
                .classe(Thread.currentThread().getStackTrace()[1].getClassName())
                .metodo(Thread.currentThread().getStackTrace()[1].getMethodName())
                .build();
        var list = campaignRepository.findAll()
                .stream().map(c -> campaignMapper.mapToDTO(c)).collect(Collectors.toList());

        log.info(SRV_0001D.logContext(context.getClasse(), context.getMetodo()));

        return list;
    }

    public CampaignDTO findById(Long id) {
        var context = ContextLog.builder()
                .classe(Thread.currentThread().getStackTrace()[1].getClassName())
                .metodo(Thread.currentThread().getStackTrace()[1].getMethodName())
                .build();
        var obj = campaignRepository.findById(id).stream().map(o -> campaignMapper.mapToDTO(o)).findFirst();

        if (!obj.isEmpty()) {
            log.info(SRV_0001D.logContext(context.getClasse(), context.getMetodo()));
        } else {
            log.severe(SRV_0001E.getObjDescription(id.toString()));
        }
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public CampaignSavedDTO insert(CampaignInsertDTO objInsert) {
        var context = ContextLog.builder()
                .classe(Thread.currentThread().getStackTrace()[1].getClassName())
                .metodo(Thread.currentThread().getStackTrace()[1].getMethodName())
                .build();
        var obj = campaignMapper.mapDtoToCampaign(objInsert);

        var objSaved = campaignMapper.mapToSavedDTO(campaignRepository.save(obj));
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
            campaignRepository.deleteById(id);
            log.info(SRV_0001D.logContext(context.getClasse(), context.getMetodo()));
        } catch (EmptyResultDataAccessException e) {
            log.severe(SRV_0001E.getObjDescription(id.toString()));
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            log.severe(SRV_0002E.getDescriptionAndException(e.getMessage()));
            throw new DatabaseException(e.getMessage());
        }
    }

    public CampaignSavedDTO update(Long id, CampaignUpdateDTO obj) {
        var context = ContextLog.builder()
                .classe(Thread.currentThread().getStackTrace()[1].getClassName())
                .metodo(Thread.currentThread().getStackTrace()[1].getMethodName())
                .build();
        try {
            Campaign entity = campaignRepository.getReferenceById(id);

            updateData(entity, obj);

            var objSaved = campaignMapper.mapToSavedDTO(campaignRepository.save(entity));

            if (objSaved != null) {
                log.info(SRV_0001D.logContext(context.getClasse(), context.getMetodo()));
            }
            return objSaved;
        } catch (EntityNotFoundException e) {
            log.severe(SRV_0001E.getObjDescription(id.toString()));
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Campaign entity, CampaignUpdateDTO obj) {
        entity.setName(obj.getName());
        entity.setTargetValue(obj.getTargetValue());
        entity.setBeneficiary(obj.getBeneficiary());
        entity.setBankName(obj.getBankName());
        entity.setAccountAgency(obj.getAccountAgency());
        entity.setAccountIdentification(obj.getAccountIdentification());
        entity.setCampaignDescription(obj.getCampaignDescription());
        entity.setUrlImage(obj.getUrlImage());
    }

}
