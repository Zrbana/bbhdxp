package com.Yimm.TangShiAnalyse.analyse.service;

import com.Yimm.TangShiAnalyse.analyse.model.AuthorCount;
import com.Yimm.TangShiAnalyse.analyse.model.WordCount;

import java.util.List;


public interface AnalyzeService {

    /*分析唐诗中作者的创作数量*/
    List<AuthorCount> analyzeAuthorCount();

    /*词云分析*/
    List<WordCount> analyzeWordCount();
}
