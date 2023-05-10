package br.com.senac.backend.mappers;

import br.com.senac.backend.dto.CampaignDTO;
import br.com.senac.backend.dto.CampaignInsertDTO;
import br.com.senac.backend.dto.CampaignSavedDTO;
import br.com.senac.backend.entities.Campaign;
import br.com.senac.backend.entities.User;
import org.springframework.stereotype.Component;

@Component
public class CampaignMapper {

    public CampaignDTO mapToDTO(Campaign campaign) {
        return CampaignDTO.builder()
                .id(campaign.getId())
                .name(campaign.getName())
                .targetValue(campaign.getTargetValue())
                .beneficiary(campaign.getBeneficiary())
                .bankName(campaign.getBankName())
                .accountAgency(campaign.getAccountAgency())
                .accountIdentification(campaign.getAccountIdentification())
                .campaignDescription(campaign.getCampaignDescription())
                .urlImage(campaign.getUrlImage())
                .user(campaign.getUser().getName())
                .build();
    }

    public CampaignSavedDTO mapToSavedDTO(Campaign campaign) {
        return CampaignSavedDTO.builder()
                .id(campaign.getId())
                .name(campaign.getName())
                .targetValue(campaign.getTargetValue())
                .beneficiary(campaign.getBeneficiary())
                .bankName(campaign.getBankName())
                .accountAgency(campaign.getAccountAgency())
                .accountIdentification(campaign.getAccountIdentification())
                .campaignDescription(campaign.getCampaignDescription())
                .urlImage(campaign.getUrlImage())
                .build();
    }

    public Campaign mapDtoToCampaign(CampaignInsertDTO campaign) {
        Campaign objSave = new Campaign();

        User user = new User();
        user.setId(campaign.getIdUser());

        objSave.setName(campaign.getName());
        objSave.setTargetValue(campaign.getTargetValue());
        objSave.setBeneficiary(campaign.getBeneficiary());
        objSave.setBankName(campaign.getBankName());
        objSave.setAccountAgency(campaign.getAccountAgency());
        objSave.setAccountIdentification(campaign.getAccountIdentification());
        objSave.setCampaignDescription(campaign.getCampaignDescription());
        objSave.setUrlImage(campaign.getUrlImage());
        objSave.setUser(user);

        return objSave;
    }

}
