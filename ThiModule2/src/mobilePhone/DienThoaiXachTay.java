package mobilePhone;

public class DienThoaiXachTay extends DienThoai {
    private String quocGiaXachTay;
    private String trangThaiDienThoai;

    public DienThoaiXachTay(int ID, String tenDienThoai, double giaDienThoai, int soLuongDienThoai, String nhaSanXuat,
                            String quocGiaXachTay, String trangThaiDienThoai) {
        super(ID, tenDienThoai, giaDienThoai, soLuongDienThoai, nhaSanXuat);
        this.quocGiaXachTay = quocGiaXachTay;
        this.trangThaiDienThoai = trangThaiDienThoai;
    }

    public String getQuocGiaXachTay() {
        return quocGiaXachTay;
    }

    public void setQuocGiaXachTay(String quocGiaXachTay) {
        this.quocGiaXachTay = quocGiaXachTay;
    }

    public String getTrangThaiDienThoai() {
        return trangThaiDienThoai;
    }

    public void setTrangThaiDienThoai(String trangThaiDienThoai) {
        this.trangThaiDienThoai = trangThaiDienThoai;
    }

    @Override
    public String toString() {
        return super.toString() + "," +
                    quocGiaXachTay + "," +
                    trangThaiDienThoai;
    }
}
