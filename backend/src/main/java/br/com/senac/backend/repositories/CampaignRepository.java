package br.com.senac.backend.repositories;

import br.com.senac.backend.entities.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    public List<Campaign> findCampaignByUser_Id(Long id);

}
