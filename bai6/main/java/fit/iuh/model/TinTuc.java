package fit.iuh.model;

public class TinTuc {
    private String maTT;
    private String tieude;
    private String noidungTT;
    private  String lienket;
    private DanhMuc danhMuc;

    public TinTuc(String maTT, String tieude, String noidungTT, String lienket, DanhMuc danhMuc) {
        this.maTT = maTT;
        this.tieude = tieude;
        this.noidungTT = noidungTT;
        this.lienket = lienket;
        this.danhMuc = danhMuc;
    }

    public String getMaTT() {
        return maTT;
    }

    public void setMaTT(String maTT) {
        this.maTT = maTT;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getNoidungTT() {
        return noidungTT;
    }

    public void setNoidungTT(String noidungTT) {
        this.noidungTT = noidungTT;
    }

    public String getLienket() {
        return lienket;
    }

    public void setLienket(String lienket) {
        this.lienket = lienket;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }
}
