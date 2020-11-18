package com.home;

/**
 * TODO
 *
 * @author ahao 2020-08-21
 */
public class Comment {
    private Integer id;
    private String commentImgs;
    private String content;
    private Integer star;

    public Comment() {
    }

    public Comment(Integer id, String commentImgs, String content, Integer star) {
        this.id = id;
        this.commentImgs = commentImgs;
        this.content = content;
        this.star = star;
    }

    public Integer getId() {
        return this.id;
    }

    public String getCommentImgs() {
        return this.commentImgs;
    }

    public String getContent() {
        return this.content;
    }

    public Integer getStar() {
        return this.star;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCommentImgs(String commentImgs) {
        this.commentImgs = commentImgs;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

}
