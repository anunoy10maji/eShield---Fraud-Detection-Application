package org.proj.Repository;

import org.proj.Entity.FraudHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudDetectionRepo extends JpaRepository<FraudHistory,Long> {
}
