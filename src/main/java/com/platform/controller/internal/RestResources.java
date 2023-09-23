package com.platform.controller.internal;


import com.platform.dto.TestDTO;
import com.platform.common.dto.response.ResponseWithBody;
import com.platform.common.utils.ResponseUtil;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

import static com.platform.common.constant.CommonConstants.TRACE_ID;


@RestController
@RequestMapping("/v1")
@Tag(name = "Rest", description = "Rest Resources API")
@Slf4j
@RequiredArgsConstructor
public class RestResources {


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "500", description = "error")})
    @PostMapping(value = "/send-rest", consumes = "application/json",produces = "application/json")
    public ResponseEntity<ResponseWithBody<?>> sendRest(@RequestBody @Valid TestDTO testDTO){
        String traceId = UUID.randomUUID().toString();
        MDC.put(TRACE_ID, traceId);
        log.info("tutruong");

        MDC.clear();
        return ResponseEntity.ok(new ResponseWithBody("TT", ResponseUtil.createSuccessStatus()));
    }
}
