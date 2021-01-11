package mobilePhone;

public abstract class DienThoai {
    private int ID;
    private String tenDienThoai;
    private double giaDienThoai;
    private int soLuongDienThoai;
    private String nhaSanXuat;

    public DienThoai(int ID, String tenDienThoai, double giaDienThoai, int soLuongDienThoai, String nhaSanXuat) {
        this.ID = ID;
        this.tenDienThoai = tenDienThoai;
        this.giaDienThoai = giaDienThoai;
        this.soLuongDienThoai = soLuongDienThoai;
        this.nhaSanXuat = nhaSanXuat;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenDienThoai() {
        return tenDienThoai;
    }

    public void setTenDienThoai(String tenDienThoai) {
        this.tenDienThoai = tenDienThoai;
    }

    public double getGiaDienThoai() {
        return giaDienThoai;
    }

    public void setGiaDienThoai(double giaDienThoai) {
        this.giaDienThoai = giaDienThoai;
    }

    public int getSoLuongDienThoai() {
        return soLuongDienThoai;
    }

    public void setSoLuongDienThoai(int soLuongDienThoai) {
        this.soLuongDienThoai = soLuongDienThoai;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    @Override
    public String toString() {
        return ID + ","
                + tenDienThoai + "," +
                giaDienThoai + ","
                + soLuongDienThoai + ","
                + nhaSanXuat;
    }
}
