package com.infy.sellerMs.service.Interface;
import com.infy.sellerMs.dto.SellerDTO;
import java.util.List;

public interface SellerService {
    SellerDTO createSeller(SellerDTO sellerDTO);
    List<SellerDTO> getAllSellers();
    SellerDTO getSellerById(Long id);
}