package com.Yimm.TangShiAnalyse.analyse.dao;

import com.Yimm.TangShiAnalyse.analyse.entity.PoetryInfo;
import com.Yimm.TangShiAnalyse.analyse.model.AuthorCount;

import java.util.List;


/**
 * @author 16376
 */
public interface AnalyzeDao {

    /*将数据全部查询出来*/


    /*分析唐诗中作者的创作数量*/
    List<AuthorCount> analyzeAuthorCount();

    /*查询所有诗文，提供给业务层进行分析*/
    List<PoetryInfo> queryAllPoetryInfo();


}
