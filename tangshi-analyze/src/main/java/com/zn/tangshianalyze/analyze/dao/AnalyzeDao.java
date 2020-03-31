package com.zn.tangshianalyze.analyze.dao;


import com.zn.tangshianalyze.analyze.entity.PoetryInfo;

import java.util.List;

/**
 * Author: yuisma
 * Created: 2020/02/11
 */
public interface AnalyzeDao {
    
    List<PoetryInfo> loadAll();
}
