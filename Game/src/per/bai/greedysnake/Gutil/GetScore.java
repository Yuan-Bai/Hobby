package per.bai.greedysnake.Gutil;

public class GetScore {
    private int id;
    private int score;
    private int pageSize = 10;
    private int start;
    private int pageNow = 1;
    private int totalPage;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getStart() {
        return start;
    }

    public void setStart() {
        this.start = (pageNow-1)*pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
