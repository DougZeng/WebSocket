package com.doug.lib;

/**
 * Created by wesine on 2018/9/13.
 */

public interface Response<T> {

    /**
     * 获取响应的文本数据
     */
    String getResponseText();

    /**
     * 设置响应的文本数据
     */
    void setResponseText(String responseText);

    /**
     * 获取该数据的实体，可能为空，具体看实现类
     */
    T getResponseEntity();

    /**
     * 设置数据实体
     */
    void setResponseEntity(T responseEntity);
}
