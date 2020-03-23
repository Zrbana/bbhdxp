package com.Yimm.TangShiAnalyse.crawier.PipeLine;

import com.Yimm.TangShiAnalyse.crawier.common.Page;



/*清洗*/
public interface Pipeline {
    /*解析后的page传入进行页面清洗*/
    void pipeline(final Page page);
}
