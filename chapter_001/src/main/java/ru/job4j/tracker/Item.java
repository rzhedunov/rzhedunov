package ru.job4j.tracker;

/**
 * Class Profession 002.1.1.
 * @author rzhedunov
 * @since 2017-12-04
 * @version 002.1.1.
 */
public class Item {
    /** ID of the item. */
    private String id;
    /** Name of the item. */
    private String name;
    /** Description of the item. */
    private String desc;
    /** Universal time of the item creation. */
    private long created;
    /** All comments on the item. */
    private String[] comments = new String[10];
    /** Number of comments on the item. */
    private int cntComments = 0;

    /**
     * Конструктор по умолчанию
     */
    Item() {
    }

    /**
     * Конструктор с именем, описанием, датой создания
     */
    Item(String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }

    /**
     * Method getId - Id-getter.
     * @return string.
     */
    public String getId() {
        return id;
    }
    /**
     * Method setId - Id-setter.
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Method getName - Name-getter.
     * @return string.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Method setName - Name-setter.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Method getDesc - Desc-getter.
     * @return int.
     */
    public String getDesc() {
        return this.desc;
    }
    /**
     * Method setCreated - Created-setter.
     */
    public void setCreated(long created) {
        this.created = created;
    }
    /**
     * Method setCreated - Created-setter.
     */
    public long getCreated() {
        return this.created;
    }
    /**
     * Method setDesc - Desc-setter.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Method getcntComments - cntComments-getter.
     * @return int.
     */
    public int getCntComments() {
        return this.cntComments;
    }
    /**
     * Method addComment - adds a comment.
     */
    public void addComment(String comment) throws Exception {
        if (this.cntComments == 10) {
            throw new ArrayIndexOutOfBoundsException("Число комментариев превышает 10!");
        }
        this.cntComments++;
        comments[this.cntComments - 1] = comment;
    }
    /**
     * Method deleteComment - deletes a comment.
     */
    public void deleteComment(int numberOfComment) {
        System.arraycopy(comments, numberOfComment + 1, comments, numberOfComment, (cntComments - 1 - numberOfComment));
        comments[this.cntComments] = null;
        this.cntComments--;
    }
    /**
     * Method getComment - returns a comment on defined position.
     */
    public String getComment(int positionOfComment) throws Exception {
        if ((positionOfComment < this.cntComments) && (positionOfComment >= 0)) {
            return this.comments[positionOfComment];
        } else {
            throw new ArrayIndexOutOfBoundsException("Комментарий с указанным кодом отсутствует!");
        }
    }
}
