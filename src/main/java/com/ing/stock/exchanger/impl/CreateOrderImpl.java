package com.ing.stock.exchanger.impl;

import com.ing.stock.exchanger.api.CreateOrderApi;
import com.ing.stock.exchanger.db.CustomerAsset;
import com.ing.stock.exchanger.db.ExchangeOrder;
import com.ing.stock.exchanger.db.repos.CustomerAssetRepository;
import com.ing.stock.exchanger.db.repos.ExchangeOrderRepository;
import com.ing.stock.exchanger.exceptions.HandleCreateExchangeOrderException;
import com.ing.stock.exchanger.models.OrderReq;
import com.ing.stock.exchanger.models.OrderRes;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;

@Data
@Slf4j
@RestController
public class CreateOrderImpl implements CreateOrderApi {

    @Autowired
    private ExchangeOrderRepository exchangeOrderRepository;

    @Autowired
    private CustomerAssetRepository customerAssetRepository;
    @Override
    public ResponseEntity<OrderRes> createOrderPost(@Valid @RequestBody OrderReq orderReq) {

        OrderRes orderRes = new OrderRes();
        String requestUser = SecurityContextHolder.getContext().getAuthentication().getName();

        try {
            if (!"SELL".equals(orderReq.getSide()) && !"BUY".equals(orderReq.getSide()))
                throw new HandleCreateExchangeOrderException("side can be only 'BUY' or 'SELL'");
            if ("SELL".equals(orderReq.getSide())) {
                try {
                    // B: retrieve existing stock
                    CustomerAsset customerAsset = customerAssetRepository.findByCustomerIdAndAssetName(requestUser, orderReq.getAsset());
                    // E: retrieve existing stock
                    if (customerAsset == null) {
                        throw new HandleCreateExchangeOrderException("You cannot SELL if you do not have it!");
                    } else if ((orderReq.getSize() > customerAsset.getUsableSize())) {
                        throw new HandleCreateExchangeOrderException("REQUESTED SIZE CANNOT BE MORE THAN USABLE SIZE");
                    } else
                        customerAsset.setUsableSize((customerAsset.getUsableSize() - orderReq.getSize()));
                    // B: update usable asset
                    customerAssetRepository.save(customerAsset);
                    // B: update usable asset
                } catch (Exception e) {
                    throw new HandleCreateExchangeOrderException("UNEXPECTED ERROR: "+e.toString());
                }
            }
            ExchangeOrder newExchangeOrder = new ExchangeOrder();
            // B: Set the requested user
            if("admin".equals(requestUser))
                newExchangeOrder.setCustomerId(orderReq.getCustomerID());
            else
                newExchangeOrder.setCustomerId(requestUser);
            // E: Set the requested user

            // B: create order request
            newExchangeOrder.setAsset(orderReq.getAsset());
            newExchangeOrder.setSide(orderReq.getSide());
            newExchangeOrder.setSize(orderReq.getSize());
            newExchangeOrder.setPrice(orderReq.getPrice());
            newExchangeOrder.setCreationDate(LocalDateTime.now());
            newExchangeOrder.setStatus("PENDING");
            ExchangeOrder saved = exchangeOrderRepository.save(newExchangeOrder);
            orderRes.setStatusCode("S");
            orderRes.setStatus("PENDING");
            orderRes.setStatusMessage(saved.getId().toString());
            // E: save the request
        }
        catch (HandleCreateExchangeOrderException eoe){
            orderRes.setStatusCode("E");
            orderRes.setStatus("ERROR");
            orderRes.setStatusMessage(eoe.getMessage());
        }


        try{
            return ResponseEntity.ok().body(orderRes);
        }
        catch (Exception e){
            orderRes.setStatusCode("E");
            orderRes.setStatusMessage(e.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(orderRes);
        }
    }
}
