package com.platform.controller.publish;


import com.platform.common.dto.response.ResponseWithBody;
import com.platform.common.utils.ResponseUtil;
import com.platform.dto.author.AuthorCreateDTO;
import com.platform.dto.author.AuthorDTO;
import com.platform.service.AuthorService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.platform.common.constant.CommonConstants.TRACE_ID;


@RestController
@RequestMapping("api/v1/authors")
@Tag(name = "Author", description = "Author Resources API")
@Slf4j
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Indicates that the request was executed successfully"),
            @ApiResponse(responseCode = "500", description = "Indicates that there is a server error occurs during executing the request")})
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ResponseWithBody<AuthorDTO>> findAuthorById(@PathVariable Long id){
        String traceId = UUID.randomUUID().toString();
        MDC.put(TRACE_ID, traceId);
        AuthorDTO authorDTO = authorService.findById(id);

        MDC.clear();
        return ResponseEntity.ok(new ResponseWithBody(authorDTO, ResponseUtil.createSuccessStatus()));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Indicates that the request was executed successfully"),
            @ApiResponse(responseCode = "500", description = "Indicates that there is a server error occurs during executing the request")})
    @PostMapping(value = "/create", consumes = "application/json",produces = "application/json")
    public ResponseEntity<ResponseWithBody<AuthorDTO>> createAuthor(@RequestBody AuthorCreateDTO authorCreateDTO){
        String traceId = UUID.randomUUID().toString();
        MDC.put(TRACE_ID, traceId);

        AuthorDTO authorDTO = authorService.save(authorCreateDTO);

        MDC.clear();
        return ResponseEntity.ok(new ResponseWithBody(authorDTO, ResponseUtil.createSuccessStatus()));
    }
}
