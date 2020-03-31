package com.zn.tangshianalyze.web;

import com.zn.tangshianalyze.analyze.service.AnalyzeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * Author: yuisma
 * Created: 2020/02/18
 */
@RestController
@RequestMapping(value = "/analyze")
public class AnalyzeController {
    
    @Autowired
    private AnalyzeService analyzeService;
    
    @GetMapping(value = "/creation/ranking")
    public Map<String, Integer> creationRanking() {
        return analyzeService.creationRankingAnalyze();
    }
    
    @GetMapping(value = "/cloud/words")
    public Map<String, Integer> cloudWords() {
        return analyzeService.cloudWords();
    }
}
