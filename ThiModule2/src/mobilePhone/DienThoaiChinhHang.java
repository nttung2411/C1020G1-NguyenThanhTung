package mobilePhone;

public class DienThoaiChinhHang extends DienThoai {
    private int thoiGianBaoHanh;
    private String phamViBaoHanh;

    public DienThoaiChinhHang(int ID, String tenDienThoai, double giaDienThoai, int soLuongDienThoai, String nhaSanXuat ,
                              int thoiGianBaoHanh , String phamViBaoHanh) {
        super(ID, tenDienThoai, giaDienThoai, soLuongDienThoai, nhaSanXuat);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.phamViBaoHanh = phamViBaoHanh;
    }

    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public String getPhamViBaoHanh() {
        return phamViBaoHanh;
    }

    public void setPhamViBaoHanh(String phamViBaoHanh) {
        this.phamViBaoHanh = phamViBaoHanh;
    }

    @Override
    public String toString() {
        return super.toString() + "," +
                thoiGianBaoHanh + "," +
                phamViBaoHanh;
    }
}
