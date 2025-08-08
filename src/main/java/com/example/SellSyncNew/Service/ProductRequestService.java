package com.example.SellSyncNew.Service;

import com.example.SellSyncNew.DTO.ProductRequestResponse;
import com.example.SellSyncNew.Model.ProductRequest;
import com.example.SellSyncNew.Model.Wholesaler;
import com.example.SellSyncNew.Repository.ProductRequestRepository;
import com.example.SellSyncNew.Repository.WholesalerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductRequestService {

    @Autowired
    private ProductRequestRepository repository;

    @Autowired
    private WholesalerRepository wholesalerRepository;

    public ProductRequest save(ProductRequest request) {
        return repository.save(request);
    }

    public List<ProductRequest> getAll() {
        return repository.findAll();
    }

    public List<ProductRequestResponse> getAllWithWholesalerDetails() {
        List<ProductRequest> requests = repository.findAll();
        return requests.stream()
                .map(ProductRequestResponse::new)
                .collect(Collectors.toList());
    }

    public ProductRequest getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<ProductRequestResponse> getRequestsByWholesalerEmail(String email) {
        Optional<Wholesaler> optionalWholesaler = wholesalerRepository.findByEmail(email);
        if (optionalWholesaler.isEmpty()) {
            return List.of(); // or throw an exception if preferred
        }

        Wholesaler wholesaler = optionalWholesaler.get();

        List<ProductRequest> requests = repository.findByWholesalerId(wholesaler.getId());
        return requests.stream()
                .map(ProductRequestResponse::new)
                .collect(Collectors.toList());
    }




}