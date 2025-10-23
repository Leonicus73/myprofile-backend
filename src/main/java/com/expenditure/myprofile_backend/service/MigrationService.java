package com.expenditure.myprofile_backend.service;

import com.expenditure.myprofile_backend.dto.MongoExpenditureDTO;
import com.expenditure.myprofile_backend.entity.Expenditure;
import com.expenditure.myprofile_backend.repository.ExpenditureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MigrationService {

    @Autowired
    private ExpenditureRepository postgresRepo;

    private final RestTemplate restTemplate = new RestTemplate();

    public void migrateFromMongo() {
        String mongoApiUrl = "http://192.168.1.6:5000/expenditures";

        try {
            ResponseEntity<MongoExpenditureDTO[]> response = restTemplate.getForEntity(
                mongoApiUrl, MongoExpenditureDTO[].class);

            MongoExpenditureDTO[] mongoData = response.getBody();

            if (mongoData != null) {
                List<Expenditure> expenditures = Arrays.stream(mongoData)
                    .map(m -> {
                        Expenditure e = new Expenditure();
                        e.setId(null); // or UUID.fromString(m.getId()) if valid
                        e.setName(m.getName());
                        e.setPrice(m.getPrice());
                        return e;
                    })
                    .collect(Collectors.toList());

                postgresRepo.saveAll(expenditures);
                System.out.println("Migration complete: " + expenditures.size() + " items saved.");
            } else {
                System.out.println("No data received from MongoDB API.");
            }

        } catch (Exception e) {
            System.err.println("Migration failed:");
            e.printStackTrace();
        }
    }


}
