package com.ing.stock.exchanger.db.repos;

import com.ing.stock.exchanger.db.CustomerAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerAssetRepository extends JpaRepository<CustomerAsset,Long> {
    CustomerAsset findByCustomerIdAndAssetName(String customerId, String assetName);

    List<CustomerAsset> findByCustomerId(String customerId);
}
