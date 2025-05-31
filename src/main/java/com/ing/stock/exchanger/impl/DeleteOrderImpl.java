package com.ing.stock.exchanger.impl;

import com.ing.stock.exchanger.api.DeleteOrderApi;
import com.ing.stock.exchanger.db.CustomerAsset;
import com.ing.stock.exchanger.db.ExchangeOrder;
import com.ing.stock.exchanger.db.repos.CustomerAssetRepository;
import com.ing.stock.exchanger.db.repos.ExchangeOrderRepository;
import com.ing.stock.exchanger.exceptions.HandleCreateExchangeOrderException;
import com.ing.stock.exchanger.models.DeleteRes;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;

@Data
@Slf4j
@RestController
public class DeleteOrderImpl implements DeleteOrderApi {

    @Autowired
    private ExchangeOrderRepository exchangeOrderRepository;

    @Autowired
    private CustomerAssetRepository customerAssetRepository;
    @Override
    public ResponseEntity<DeleteRes> deleteOrderDelete(Long uniqueOrderId) {

        String requestUser = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<ExchangeOrder> byId;
        try{
            // B: retrieve order request
            try{
                byId = exchangeOrderRepository.findById(uniqueOrderId);
            }
            catch (Exception e) {
                throw new HandleCreateExchangeOrderException("NOT FOUND!");
            }
            // E: retrieve order request

            if (!"PENDING".equals(byId.get().getStatus())){
                throw new HandleCreateExchangeOrderException("ONLY PENDING ORDERS CAN BE CANCELLED");
            }
            // B: delete order request
            try {
                exchangeOrderRepository.deleteAllById(Collections.singleton(uniqueOrderId));
            }
            catch (Exception e){
                throw new HandleCreateExchangeOrderException("unhandled error on deletion: "+e.toString());
            }
            // E: delete order request

            // B: update usable size
            try {
                CustomerAsset customerAsset = customerAssetRepository.findByCustomerIdAndAssetName(requestUser, byId.get().getAsset());
                customerAsset.setUsableSize(customerAsset.getUsableSize() + byId.get().getSize());
                customerAssetRepository.save(customerAsset);
            }
            catch (Exception e){
                throw new HandleCreateExchangeOrderException("unhandled error on updating size: "+e.toString());
            }
            // B: update usable size
        } catch (HandleCreateExchangeOrderException eoe)
        {
            DeleteRes deleteRes = new DeleteRes();
            deleteRes.setStatusCode("E");
            deleteRes.setStatusMessage(eoe.getMessage());
            return ResponseEntity.ok().body(deleteRes);
        }


        DeleteRes deleteRes = new DeleteRes();
        deleteRes.setStatusCode("S");
        deleteRes.setStatusMessage("ORDER IS CANCELLED");
        return ResponseEntity.ok().body(deleteRes);
    }
}
