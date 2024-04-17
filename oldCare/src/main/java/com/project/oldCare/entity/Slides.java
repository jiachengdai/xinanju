package com.project.oldCare.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Objects;

import lombok.Data;

/**
 *
 * @TableName slides
 */
@TableName(value ="slides")
@Data
public class Slides implements Serializable {
    /**
     * 轮播图ID：
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 标题：
     */
    private String title;

    /**
     * 内容：
     */
    private String content;

    /**
     * 链接：
     */
    private String url;
    private String tourl;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slides slides = (Slides) o;
        return Objects.equals(id, slides.id) && Objects.equals(title, slides.title) && Objects.equals(content, slides.content) && Objects.equals(url, slides.url) && Objects.equals(tourl, slides.tourl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, url, tourl);
    }

    @Override
    public String toString() {
        return "Slides{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                ", tourl='" + tourl + '\'' +
                '}';
    }




    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}
