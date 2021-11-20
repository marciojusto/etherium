package com.etherium.controller;

import co.elastic.apm.api.ElasticApm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1/eth")
@Slf4j
public class EtcController {

    @PostMapping("/{value}")
    public String buyETH(@PathVariable double value) {
        log.info("transactionId: {} - traceId: {}, Buying ETH for {}", ElasticApm.currentTransaction().getId(), ElasticApm.currentTransaction().getTraceId(), value);
        return "you bought $" + value + " in ETH";
    }

    @GetMapping
    public String getETHValue() {
        log.info("transactionId: {} - traceId: {}, Showing ETH price", ElasticApm.currentTransaction().getId(), ElasticApm.currentTransaction().getTraceId());
        return "ETH today is $3.000";
    }

    @GetMapping("/exception/{throwException}")
    public void showException(@PathVariable boolean throwException) {
        log.info("transactionId: {} - traceId: {}, throwing an Exception", ElasticApm.currentTransaction().getId(), ElasticApm.currentTransaction().getTraceId());
        try {
            if(throwException) {
                throw new IllegalStateException("Just an exception test");
            }
        }
        catch (IllegalStateException e) {
            log.error("An exception log test was threw", e);
        }
    }
}
