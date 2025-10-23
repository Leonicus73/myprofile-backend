package com.expenditure.myprofile_backend.repository;

import com.expenditure.myprofile_backend.entity.Expenditure;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ExpenditureRepository extends JpaRepository<Expenditure, UUID> {

}
