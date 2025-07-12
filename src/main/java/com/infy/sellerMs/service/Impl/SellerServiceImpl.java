package com.infy.sellerMs.service.Impl;
import com.infy.sellerMs.dto.SellerDTO;
import com.infy.sellerMs.entity.Seller;
import com.infy.sellerMs.repository.SellerRepository;
import com.infy.sellerMs.service.Interface.SellerService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SellerDTO createSeller(SellerDTO sellerDTO) {
        Seller seller = modelMapper.map(sellerDTO, Seller.class);
        return modelMapper.map(sellerRepository.save(seller), SellerDTO.class);
    }

    @Override
    public List<SellerDTO> getAllSellers() {
        return sellerRepository.findAll().stream()
            .map(seller -> modelMapper.map(seller, SellerDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public SellerDTO getSellerById(Long id) {
        Seller seller = sellerRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Seller not found with ID: " + id));
        return modelMapper.map(seller, SellerDTO.class);
    }
}