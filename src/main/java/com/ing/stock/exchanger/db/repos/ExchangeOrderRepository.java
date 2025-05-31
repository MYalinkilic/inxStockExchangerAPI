package com.ing.stock.exchanger.db.repos;

import com.ing.stock.exchanger.db.ExchangeOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExchangeOrderRepository extends JpaRepository <ExchangeOrder,Long>{
    List<ExchangeOrder> findByCustomerId(String customerId);
    Optional<ExchangeOrder> findById(Long id);
    List<ExchangeOrder> findByCustomerIdAndCreationDateBetween(
            String customerId,
            LocalDateTime beginDate,
            LocalDateTime endDate
    );
}
