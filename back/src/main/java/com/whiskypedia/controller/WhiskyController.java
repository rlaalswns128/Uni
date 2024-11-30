package com.whiskypedia.controller;

import com.whiskypedia.dto.WhiskyDTO;
import com.whiskypedia.service.WhiskyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/whisky")
public class WhiskyController {

    @Autowired
    private WhiskyService whiskyService;

    @GetMapping
    public ResponseEntity<List<WhiskyDTO>> getAllWhiskies() {
        List<WhiskyDTO> whiskies = whiskyService.getAllWhiskies();
        return ResponseEntity.ok(whiskies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WhiskyDTO> getWhiskyById(@PathVariable String id) {
        WhiskyDTO whisky = whiskyService.getWhiskyById(id);
        if (whisky != null) {
            return ResponseEntity.ok(whisky);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}