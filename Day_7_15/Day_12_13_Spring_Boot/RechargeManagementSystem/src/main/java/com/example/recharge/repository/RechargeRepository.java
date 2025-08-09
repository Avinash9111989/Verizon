
package com.example.recharge.repository;

import com.example.recharge.model.Recharge;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RechargeRepository extends JpaRepository<Recharge, Long> {
    List<Recharge> findByUserId(String userId);
    List<Recharge> findByPlanType(String planType);
}
