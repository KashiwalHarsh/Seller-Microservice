package com.infy.sellerMs.controller;
import com.infy.sellerMs.dto.SellerDTO;
import com.infy.sellerMs.service.Interface.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {
    @Autowired private SellerService sellerService;

    @PostMapping
    public SellerDTO create(@RequestBody SellerDTO dto) {
        return sellerService.createSeller(dto);
    }

    @GetMapping
    public List<SellerDTO> getAll() {
        return sellerService.getAllSellers();
    }

    @GetMapping("/{id}")
    public SellerDTO getById(@PathVariable Long id) {
        return sellerService.getSellerById(id);
    }
}