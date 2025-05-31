package com.ing.stock.exchanger.impl;

import com.ing.stock.exchanger.api.ListOrderApi;
import com.ing.stock.exchanger.db.CustomerAsset;
import com.ing.stock.exchanger.db.ExchangeOrder;
import com.ing.stock.exchanger.db.repos.CustomerAssetRepository;
import com.ing.stock.exchanger.db.repos.ExchangeOrderRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@Slf4j
@RestController
public class ListOrderImpl implements ListOrderApi {

    @Autowired
    private ExchangeOrderRepository exchangeOrderRepository;

    public static LocalDateTime parseDateStartOfDay(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        LocalDate localDate = LocalDate.parse(dateStr, formatter);
        return localDate.atStartOfDay(); // 00:00:00
    }

    public static LocalDateTime parseDateEndOfDay(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        LocalDate localDate = LocalDate.parse(dateStr, formatter);
        return localDate.atTime(LocalTime.MAX); // 23:59:59.999999999
    }

    @Override
    public ResponseEntity<List<ExchangeOrder>> listOrderGet(String customer, String beginDate, String endDate) {

        String loginUser = SecurityContextHolder.getContext().getAuthentication().getName();
        List<ExchangeOrder> exchangeOrders = exchangeOrderRepository.findByCustomerIdAndCreationDateBetween(loginUser,parseDateStartOfDay(beginDate),parseDateEndOfDay(endDate));
        return ResponseEntity.ok().body(exchangeOrders);
    }
}
