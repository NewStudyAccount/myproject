package com.example.domain.req;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SysArticleContentReq {


    /**
     * 文章id
     */
    @JsonProperty(value = "ARTICLE_ID")
    private Long articleId;

}
