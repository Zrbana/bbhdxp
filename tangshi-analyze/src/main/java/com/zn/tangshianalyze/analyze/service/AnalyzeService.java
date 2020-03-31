package com.zn.tangshianalyze.analyze.service;


import com.zn.tangshianalyze.analyze.entity.PoetryInfo;

import java.util.List;
import java.util.Map;


/**
 * Author: yuisma
 * Created: 2020/02/11
 */
public interface AnalyzeService {
    
    List<PoetryInfo> queryPoetryInfoByTitle(String title);
    
    List<PoetryInfo> queryPoetryInfoByAuthor(String author);
    
    Map<String, Integer> creationRankingAnalyze();
    
    Map<String,Integer> cloudWords();
    
}
