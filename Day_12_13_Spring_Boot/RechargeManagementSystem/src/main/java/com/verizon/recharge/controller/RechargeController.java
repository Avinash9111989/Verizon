
package com.verizon.recharge.controller;


import com.verizon.recharge.model.Recharge;
import com.verizon.recharge.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recharges")
public class RechargeController {

    @Autowired
    private RechargeService service;

    @PostMapping
    public Recharge addRecharge(@RequestBody Recharge recharge) {
        return service.addRecharge(recharge);
    }

    @GetMapping
    public List<Recharge> getAll() {
        return service.getAllRecharges();
    }

    @GetMapping("/user/{userId}")
    public List<Recharge> getByUser(@PathVariable String userId) {
        return service.getRechargesByUserId(userId);
    }

    @GetMapping("/plan/{planType}")
    public List<Recharge> getByPlan(@PathVariable String planType) {
        return service.getRechargesByPlanType(planType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteRecharge(id);
        return ResponseEntity.noContent().build();
    }
}
