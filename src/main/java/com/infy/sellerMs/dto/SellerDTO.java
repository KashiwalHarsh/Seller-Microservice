package com.infy.sellerMs.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerDTO {
    private Long id;
    private String name;
    private String gstNumber;
    private ContactInfoDTO contactInfo;
    private Double rating;
}

