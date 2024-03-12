package exam.dto;

import exam.utils.CheckIdSubConstraint;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class SubDTO implements Validator {

    @CheckIdSubConstraint
    private String cccd;

    private String hoTen;

    private String ngaySinh;

    private String gioiTinh;

    private String soDienThoai;

    private String email;

    private String soTheBhyt;

    private String ngheNghiep;

    private String diaChi;

    private String ngayDangKy = LocalDate.now().toString();

    private Integer trangThaiTiem = 1;

    private Integer soLanTiem;

    private String ngayTiemGanNhat;

    public SubDTO() {
    }

    public SubDTO(String cccd, String hoTen, String ngaySinh, String gioiTinh, String soDienThoai, String email, String soTheBhyt, String ngheNghiep, String diaChi, String ngayDangKy, Integer trangThaiTiem, Integer soLanTiem, String ngayTiemGanNhat) {
        this.cccd = cccd;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.soTheBhyt = soTheBhyt;
        this.ngheNghiep = ngheNghiep;
        this.diaChi = diaChi;
        this.ngayDangKy = ngayDangKy;
        this.trangThaiTiem = trangThaiTiem;
        this.soLanTiem = soLanTiem;
        this.ngayTiemGanNhat = ngayTiemGanNhat;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoTheBhyt() {
        return soTheBhyt;
    }

    public void setSoTheBhyt(String soTheBhyt) {
        this.soTheBhyt = soTheBhyt;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(String ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public Integer getTrangThaiTiem() {
        return trangThaiTiem;
    }

    public void setTrangThaiTiem(Integer trangThaiTiem) {
        this.trangThaiTiem = trangThaiTiem;
    }

    public Integer getSoLanTiem() {
        return soLanTiem;
    }

    public void setSoLanTiem(Integer soLanTiem) {
        this.soLanTiem = soLanTiem;
    }

    public String getNgayTiemGanNhat() {
        return ngayTiemGanNhat;
    }

    public void setNgayTiemGanNhat(String ngayTiemGanNhat) {
        this.ngayTiemGanNhat = ngayTiemGanNhat;
    }

    @Override
    public String toString() {
        return "SubDTO{" +
                "cccd='" + cccd + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", email='" + email + '\'' +
                ", soTheBhyt='" + soTheBhyt + '\'' +
                ", ngheNghiep='" + ngheNghiep + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", ngayDangKy='" + ngayDangKy + '\'' +
                ", trangThaiTiem=" + trangThaiTiem +
                ", soLanTiem=" + soLanTiem +
                ", ngayTiemGanNhat='" + ngayTiemGanNhat + '\'' +
                '}';
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SubDTO dto = (SubDTO) target;


//        LocalDate ngayHienTai = LocalDate.now();
//        if(dto.getNgayKH() != null) {
//            if(ngayHienTai.isAfter(dto.getNgayKH())) {
//                errors.rejectValue("ngayKH", "none",
//                        "Ngay KH phai lon hon ngay hien tai!");
//            }
//        }
//
//        if(dto.getSoLuongVe() != null) {
//            if(dto.getSoLuongVe() < 0 || dto.getSoLuongVe() > 10) {
//                errors.rejectValue("soLuongVe", "none",
//                        "So luong phai lon hon 0 và nho hon 10!");
//            }
//        }
    }
}
