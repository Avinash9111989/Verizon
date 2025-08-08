
package com.verizon.recharge.service;

import com.verizon.recharge.model.Recharge;
import com.verizon.recharge.repository.RechargeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RechargeService {

    @Autowired
    private RechargeRepository repository;

    public Recharge addRecharge(Recharge recharge) {
        return repository.save(recharge);
    }

    public List<Recharge> getAllRecharges() {
        return repository.findAll();
    }

    public List<Recharge> getRechargesByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    public List<Recharge> getRechargesByPlanType(String planType) {
        return repository.findByPlanType(planType);
    }

    public void deleteRecharge(Long id) {
        repository.deleteById(id);
    }
}
