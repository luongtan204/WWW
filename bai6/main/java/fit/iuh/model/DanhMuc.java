package fit.iuh.model;

public class DanhMuc {
    private String maDM;
    private String tenDM;
    private String nguoiQL;
    private String ghichu;

    public DanhMuc(String maDM, String tenDM, String nguoiQL, String ghichu) {
        this.maDM = maDM;
        this.tenDM = tenDM;
        this.nguoiQL = nguoiQL;
        this.ghichu = ghichu;
    }

    public String getMaDM() {
        return maDM;
    }

    public void setMaDM(String maDM) {
        this.maDM = maDM;
    }

    public String getTenDM() {
        return tenDM;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
    }

    public String getNguoiQL() {
        return nguoiQL;
    }

    public void setNguoiQL(String nguoiQL) {
        this.nguoiQL = nguoiQL;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
}
