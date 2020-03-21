package com.zn.fileSave;

import java.io.File;

/**
 * @ClassName IFileService
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/21 22:24
 */


public interface IFileService {
    public static final String SAVE_DIR = "D:" + File.separator + "mldndata" + File.separator;
    //定义保存的方法
    boolean save();
}
