package com.ing.stock.exchanger.impl;

import com.ing.stock.exchanger.api.ListAssetsApi;
import com.ing.stock.exchanger.db.CustomerAsset;
import com.ing.stock.exchanger.db.repos.CustomerAssetRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@Slf4j
@RestController
public class ListAssetsImpl implements ListAssetsApi {

    @Autowired
    private CustomerAssetRepository customerAssetRepository;
    @Override
    public ResponseEntity<List<CustomerAsset>> listAssetsGet(String customer) {
        String loginUser = SecurityContextHolder.getContext().getAuthentication().getName();
        // for bonus 2
        if("admin".equals(SecurityContextHolder.getContext().getAuthentication().getName()))
            loginUser = customer;
        // for bonus 2

        List<CustomerAsset> assets = customerAssetRepository.findByCustomerId(loginUser);
        return ResponseEntity.ok().body(assets);
    }
}
