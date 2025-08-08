
package com.verizon.recharge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.verizon.recharge.model.Recharge;

import java.util.List;

public interface RechargeRepository extends JpaRepository<Recharge, Long> {
    List<Recharge> findByUserId(String userId);
    List<Recharge> findByPlanType(String planType);
}
