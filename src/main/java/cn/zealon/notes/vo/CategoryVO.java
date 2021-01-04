package cn.zealon.notes.vo;

import lombok.Data;

/**
 * 分类
 * @author: zealon
 * @since: 2020/12/22
 */
@Data
public class CategoryVO {
    private String id;
    private String title;
    private Integer sort;
    private Integer notesCount;
}
