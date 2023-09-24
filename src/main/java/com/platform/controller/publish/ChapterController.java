package com.platform.controller.publish;


import com.platform.common.dto.response.ResponseWithBody;
import com.platform.common.utils.ResponseUtil;
import com.platform.dto.chapter.ChapterCreateDTO;
import com.platform.dto.chapter.ChapterDTO;
import com.platform.dto.novel.NovelCreateDTO;
import com.platform.dto.novel.NovelDTO;
import com.platform.service.ChapterService;
import com.platform.service.NovelService;
import io.swagger.v3.oas.annotations.Parameter;
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
@RequestMapping("api/v1/chapters")
@Tag(name = "Chapter", description = "Chapter Resources API")
@Slf4j
@RequiredArgsConstructor
public class ChapterController {

    private final ChapterService chapterService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Indicates that the request was executed successfully"),
            @ApiResponse(responseCode = "500", description = "Indicates that there is a server error occurs during executing the request")})
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ResponseWithBody<ChapterDTO>> findById(@PathVariable Long id){
        String traceId = UUID.randomUUID().toString();
        MDC.put(TRACE_ID, traceId);

        ChapterDTO chapterDTO = chapterService.findById(id);

        MDC.clear();
        return ResponseEntity.ok(new ResponseWithBody(chapterDTO, ResponseUtil.createSuccessStatus()));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Indicates that the request was executed successfully"),
            @ApiResponse(responseCode = "500", description = "Indicates that there is a server error occurs during executing the request")})
    @PostMapping(value = "/create", consumes = "application/json",produces = "application/json")
    public ResponseEntity<ResponseWithBody<ChapterDTO>> create(@RequestBody ChapterCreateDTO chapterCreateDTO){
        String traceId = UUID.randomUUID().toString();
        MDC.put(TRACE_ID, traceId);

        ChapterDTO chapterDTO = chapterService.save(chapterCreateDTO);

        MDC.clear();
        return ResponseEntity.ok(new ResponseWithBody(chapterDTO, ResponseUtil.createSuccessStatus()));
    }
}
