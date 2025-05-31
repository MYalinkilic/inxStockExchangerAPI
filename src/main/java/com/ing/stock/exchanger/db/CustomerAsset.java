package com.ing.stock.exchanger.db;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customer_assets")
public class CustomerAsset {

    @Id
    private Long id;
    private String customerId;
    private String assetName;
    private float size;
    private float usableSize;


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getUsableSize() {
        return usableSize;
    }

    public void setUsableSize(float usableSize) {
        this.usableSize = usableSize;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
