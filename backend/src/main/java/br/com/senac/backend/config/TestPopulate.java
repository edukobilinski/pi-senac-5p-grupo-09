package br.com.senac.backend.config;

import br.com.senac.backend.entities.Campaign;
import br.com.senac.backend.entities.User;
import br.com.senac.backend.repositories.CampaignRepository;
import br.com.senac.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TestPopulate implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CampaignRepository campaignRepository;

    @Override
    public void run(String... args) throws Exception {

        User user01 = new User(null, "José Pedro Henrique Augusto da Mata", "201.682.958-30", "jose_pedro_damata@autbook.com", "11989092497", "dNwd0o0nMn", "08080363", "Travessa Ilhas Canárias, 164 apto 1501", "São Paulo", "SP", "BR");
        User user02 = new User(null, "Fábio Renan Thiago da Cruz", "354.480.868-45","fabiorenandacruz@schon.com.br", "11983469775", "40rbxRbfMB", "02052090", "Rua José Balta, 618", "São Paulo", "SP", "BR");
        User user03 = new User(null, "Filipe Renato Peixoto", "144.520.358-84","filipe-peixoto85@maorifilmes.com.br", "11987425568", "DIgyEbjC6l", "02374130", "Rua José Benedito Nogueira, 963", "São Paulo", "SP", "BR");

        userRepository.saveAll(Arrays.asList(user01, user02, user03));

        Campaign campaign01 = new Campaign(null, "Financia Meu Curso", 5000.0, user01.getName(), "Itaú-341", "0452", "52437-4", "Me ajuda na minha campanha por favor", "https://clickpetroleoegas.com.br/wp-content/uploads/2021/02/SENAC-2-738x490.jpg", user01);
        Campaign campaign02 = new Campaign(null, "Conserta essa lata velha", 1599.0, user02.getName(), "Santander-033", "0661", "48420371-8", "Ajuda a ressucitar meu carro velho!", "http://1.bp.blogspot.com/-6-LxO_AG0Fs/Tlfl4_nMS4I/AAAAAAAACK8/cHMgY6-e72g/s1600/vendendo-o-carro-velho.jpg", user02);
        Campaign campaign03 = new Campaign(null, "Churrasco para o meu aniversário", 900.0, user02.getName(), "Banco do Brasil-001", "2026", "1003686-5", "Preciso de ajuda com minha festa de aniversário, me ajuda a ser feliz!", "https://i.pinimg.com/originals/24/40/f9/2440f9e27310e5917f753ad4ce65696c.jpg", user03);
        Campaign campaign04 = new Campaign(null, "Apoia minha academia", 50.0, user01.getName(), "Itaú-341", "0452", "52437-4", "Me ajuda a ser fitness", "https://news.gympass.com/wp-content/uploads/2018/07/escolher-a-melhor-academia.jpg", user01);

        campaignRepository.saveAll(Arrays.asList(campaign01, campaign02, campaign03, campaign04));
    }
}
