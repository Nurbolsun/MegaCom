package com.company.services;

import com.company.models.CheckProduct;

import java.util.List;

public interface CheckProductService {
    void save(CheckProduct check);
    List<CheckProduct> findList();
    CheckProduct findById(Long id);
}
