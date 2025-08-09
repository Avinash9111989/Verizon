
package com.example.recharge.controller;

import com.example.recharge.model.Recharge;
import com.example.recharge.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recharges")
public class RechargeController {

    @Autowired
    private RechargeService service;

    @PostMapping
    public Recharge createRecharge(@RequestBody Recharge recharge) {
        return service.addRecharge(recharge);
    }

    @GetMapping
    public List<Recharge> getAll() {
        return service.getAllRecharges();
    }

    @GetMapping("/user/{userId}")
    public List<Recharge> getByUserId(@PathVariable String userId) {
        return service.getRechargesByUserId(userId);
    }

    @GetMapping("/plan/{planType}")
    public List<Recharge> getByPlanType(@PathVariable String planType) {
        return service.getRechargesByPlanType(planType);
    }

    @DeleteMapping("/{id}")
    public void deleteRecharge(@PathVariable Long id) {
        service.deleteRecharge(id);
    }
}
