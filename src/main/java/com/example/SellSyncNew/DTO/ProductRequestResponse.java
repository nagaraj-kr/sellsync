package com.example.SellSyncNew.DTO;

import com.example.SellSyncNew.Model.ProductRequest;
import lombok.Data;

@Data
public class ProductRequestResponse {

    private Long id;
    private String productName;
    private String category;
    private String manufacturer;
    private int quantity;
    private String specifications;
    private String deadline;
    private String status;

    private Long wholesalerId;
    private String wholesalerBusinessName;
    private String wholesalerEmail;

    public ProductRequestResponse(ProductRequest pr) {
        this.id = pr.getId();
        this.productName = pr.getProductName();
        this.category = pr.getCategory();
        this.manufacturer = pr.getManufacturer();
        this.quantity = pr.getQuantity();
        this.specifications = pr.getSpecifications();
        this.deadline = pr.getDeadline();
        this.status = pr.getStatus();

        if (pr.getWholesaler() != null) {
            this.wholesalerId = pr.getWholesaler().getId();
            this.wholesalerBusinessName = pr.getWholesaler().getOrganizationName();
            this.wholesalerEmail = pr.getWholesaler().getEmail();
        }
    }
}