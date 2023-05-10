package br.com.senac.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CampaignInsertDTO {

    @JsonProperty(value = "id_user")
    private Long idUser;

    @JsonProperty(value = "name_campaign")
    private String name;

    @JsonProperty(value = "target_value")
    private Double targetValue;

    @JsonProperty(value = "beneficiary")
    private String beneficiary;

    @JsonProperty(value = "bank_name")
    private String bankName;

    @JsonProperty(value = "account_agency")
    private String accountAgency;

    @JsonProperty(value = "account_identification")
    private String accountIdentification;

    @JsonProperty(value = "campaign_description")
    private String campaignDescription;

    @JsonProperty(value = "url_image")
    private String urlImage;

}
