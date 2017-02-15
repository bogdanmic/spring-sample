package com.gd.controllers;

import com.gd.dto.MessageDTO;
import com.gd.services.CompletableFutureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class DefferedResultController {
    private static final Long DEFERRED_RESULT_TIMEOUT = 1000L;

    private AtomicLong id = new AtomicLong(0);

    @Autowired
    private CompletableFutureService completableFutureService;

    @RequestMapping("/actor/async-non-blocking")
    public DeferredResult<MessageDTO> getAsyncNonBlocking() {
        DeferredResult<MessageDTO> deferred = new DeferredResult<>(DEFERRED_RESULT_TIMEOUT);
        CompletableFuture<MessageDTO> future = completableFutureService.get("async-non-blocking", id.getAndIncrement());
        future.whenComplete((result, error) -> {
            if (error != null) {
                deferred.setErrorResult(error);
            } else {
                deferred.setResult(result);
            }
        });
        return deferred;
    }
}
