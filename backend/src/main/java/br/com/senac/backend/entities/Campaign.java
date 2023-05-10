package br.com.senac.backend.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_campaign")
public class Campaign implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double targetValue;
    private String beneficiary;
    private String bankName;
    private String accountAgency;
    private String accountIdentification;
    private String campaignDescription;
    private String urlImage;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Campaign() {
    }

    public Campaign(Long id, String name, Double targetValue, String beneficiary, String bankName, String accountAgency, String accountIdentification, String campaignDescription, String urlImage, User user) {
        this.id = id;
        this.name = name;
        this.targetValue = targetValue;
        this.beneficiary = beneficiary;
        this.bankName = bankName;
        this.accountAgency = accountAgency;
        this.accountIdentification = accountIdentification;
        this.campaignDescription = campaignDescription;
        this.urlImage = urlImage;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Double getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(Double targetValue) {
        this.targetValue = targetValue;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String getAccountAgency() {
        return accountAgency;
    }

    public void setAccountAgency(String accountAgency) {
        this.accountAgency = accountAgency;
    }

    public String getAccountIdentification() {
        return accountIdentification;
    }

    public void setAccountIdentification(String accountIdentification) {
        this.accountIdentification = accountIdentification;
    }

    public String getCampaignDescription() {
        return campaignDescription;
    }

    public void setCampaignDescription(String campaignDescription) {
        this.campaignDescription = campaignDescription;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", targetValue=" + targetValue +
                ", beneficiary='" + beneficiary + '\'' +
                ", bankName='" + bankName + '\'' +
                ", accountAgency='" + accountAgency + '\'' +
                ", accountIdentification='" + accountIdentification + '\'' +
                ", campaignDescription='" + campaignDescription + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Campaign)) return false;
        Campaign campaign = (Campaign) o;
        return Objects.equals(id, campaign.id) && Objects.equals(name, campaign.name) && Objects.equals(targetValue, campaign.targetValue) && Objects.equals(beneficiary, campaign.beneficiary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, targetValue, beneficiary);
    }
}
