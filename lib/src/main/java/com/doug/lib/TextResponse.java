package com.doug.lib;

/**
 * Created by wesine on 2018/9/13.
 */

public class TextResponse implements Response<String> {

    private String responseText;

    public TextResponse(String responseText) {
        this.responseText = responseText;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public String getResponseEntity() {
        return null;
    }

    public void setResponseEntity(String responseEntity) {
    }
}
