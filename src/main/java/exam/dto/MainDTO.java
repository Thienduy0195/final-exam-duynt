package exam.dto;

import exam.services.SubServiceImpl;
import exam.utils.CheckIdExistsConstraint;
import exam.utils.CheckStatusConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MainDTO implements Validator {

    @Autowired
    private SubServiceImpl subService;

    private Integer maTc;

    @CheckIdExistsConstraint
    @CheckStatusConstraint
    private String cccd;

    private String ngayTiem;

    private Integer lanTiem;

    private String tenVacXin;

    public MainDTO() {
    }

    public MainDTO(Integer maTc, String cccd, String ngayTiem, Integer lanTiem, String tenVacXin) {
        this.maTc = maTc;
        this.cccd = cccd;
        this.ngayTiem = ngayTiem;
        this.lanTiem = lanTiem;
        this.tenVacXin = tenVacXin;
    }

    public Integer getMaTc() {
        return maTc;
    }

    public void setMaTc(Integer maTc) {
        this.maTc = maTc;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getNgayTiem() {
        return ngayTiem;
    }

    public void setNgayTiem(String ngayTiem) {
        this.ngayTiem = ngayTiem;
    }

    public Integer getLanTiem() {
        return lanTiem;
    }

    public void setLanTiem(Integer lanTiem) {
        this.lanTiem = lanTiem;
    }

    public String getTenVacXin() {
        return tenVacXin;
    }

    public void setTenVacXin(String tenVacXin) {
        this.tenVacXin = tenVacXin;
    }

    @Override
    public String toString() {
        return "MainDTO{" +
                "maTc=" + maTc +
                ", cccd='" + cccd + '\'' +
                ", ngayTiem='" + ngayTiem + '\'' +
                ", lanTiem=" + lanTiem +
                ", tenVacXin='" + tenVacXin + '\'' +
                '}';
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
//        MainDTO mainDTO = (MainDTO) target;
//        if (null == subService.findById(mainDTO.getCccd())) {
//            errors.rejectValue("cccd", "cccd", "Thong tin nguoi dang ky tiem chung khong ton tai!");
//        }
    }
}
