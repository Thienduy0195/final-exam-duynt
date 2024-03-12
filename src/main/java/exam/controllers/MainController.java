package exam.controllers;

import exam.dto.MainDTO;
import exam.entities.Person;
import exam.entities.TiemChung;
import exam.services.IMainService;
import exam.services.ISubService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/main")
public class MainController {

    private ModelMapper modelMapper;

    private IMainService mainService;

    private ISubService subService;

    @Autowired
    public MainController(ModelMapper modelMapper, IMainService mainService, ISubService subService) {
        this.modelMapper = modelMapper;
        this.mainService = mainService;
        this.subService = subService;
    }

    @GetMapping("")
    public String returnMain() {
        return "redirect:/main/list";
    }

    /**
     * @param model
     * @return
     * @author DuyNT58
     * @Author_birth_date: 1995-01-01
     * @TODO
     */
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        System.out.println("CREATE MAIN");
        model.addAttribute("mainDTO", new MainDTO());
        return "main/create";
    }

    /**
     * @param mainDTO
     * @param bindingResult
     * @param model
     * @return
     * @author DuyNT58
     * @Author_birth_date: 1995-01-01
     * @TODO
     */
    @PostMapping("/create")
    public String createNew(
            @Valid @ModelAttribute("mainDTO") MainDTO mainDTO,
            BindingResult bindingResult, Model model) {
        System.out.println("MAIN POST");
        System.out.println("BEFORE" + mainDTO.toString());
        System.out.println("SO LAN:" + mainService.countSL(subService.findById(mainDTO.getCccd())));
        try {
            mainDTO.validate(mainDTO, bindingResult);
            if (mainService.countSL(subService.findById(mainDTO.getCccd())) >= 3) {
                bindingResult.rejectValue("cccd", "error.cccd", "Nguoi nay da tiem du 3 lan, de nghi ban nhap thong tin tiem cho nguoi khac ");
            }

            if (bindingResult.hasErrors()) {
//                List<FieldError> errors = bindingResult.getFieldErrors();
//                errors.forEach(item -> {
//                    System.out.println(item);
//                });
                model.addAttribute("mainDTO", mainDTO);
                return "main/create";
            }

            TiemChung main = modelMapper.map(mainDTO, TiemChung.class);
            Person sub = subService.findById(mainDTO.getCccd());
            sub.setTrangThaiTiem(4);
            subService.update(sub);
            main.setLanTiem(mainService.countSL(sub) + 1);
            System.out.println("AFTER" + main.toString());
            mainService.save(main);
            return "redirect:/main/list";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/main/list";
    }

    /**
     * @param model
     * @return
     * @author DuyNT58
     * @Author_birth_date: 1995-01-01
     * @TODO
     */
    @GetMapping("/list")
    public String showList(Model model) {
        List<TiemChung> list = mainService.findAll();
        model.addAttribute("list", list);
        return "main/list";
    }
//
//    /**
//     * @author DuyNT58
//     * @Author_birth_date: 1995-01-01
//     * @param searchName
//     * @param maTT
//     * @param model
//     * @return
//     * @TODO
//     */
//    @GetMapping("/search")
//    public String search(
//            @RequestParam(value = "searchName", required = true) String searchName,
//            @RequestParam(value = "maLT", required = true) String maLT, Model model) {
//        List<DangKyVe> list = dangKyVeService.search(searchName, maLT);
//        model.addAttribute("searchName", searchName);
//        model.addAttribute("maLT", maLT);
//        model.addAttribute("list", list);
//        return "main/list";
//    }
//
//    /**
//     * @author DuyNT58
//     * @Author_birth_date: 1995-01-01
//     * @param model
//     * @param id
//     * @return
//     * @TODO
//     */
//    @GetMapping("/{id}")
//    public String showUpdateForm(Model model, @PathVariable("id") Integer id) {
//        DangKyVe dangKy = dangKyVeService.findById(id);
//        if (dangKy == null) {
//            return "commons/error-page";
//        }
//        subDTO dangKyDTO = modelMapper.map(dangKy, subDTO.class);
//        dangKyDTO.setMaLT(dangKy.getLoTrinh().getMaLT());
//        model.addAttribute("dangKyDTO", dangKyDTO);
//        return "main/update";
//    }
//
//    /**
//     * @author DuyNT58
//     * @Author_birth_date: 1995-01-01
//     * @param dangKyDTO
//     * @param bindingResult
//     * @param model
//     * @param id
//     * @param redirectAttributes
//     * @return
//     * @TODO
//     */
//    @PostMapping("/{id}")
//    public String update(@ModelAttribute("dangKyDTO") subDTO dangKyDTO,
//                         BindingResult bindingResult, Model model, @PathVariable("id") String id,
//                         RedirectAttributes redirectAttributes) {
//        System.out.println(dangKyDTO.toString());
//        DangKyVe dangKy = new DangKyVe();
//        dangKyDTO.validate(dangKyDTO, bindingResult);
//        boolean flag = true;
//        if (loTrinhService.findById(dangKyDTO.getMaLT()).isEmpty()) {
//            flag = false;
//            bindingResult.rejectValue("maLT", "maLT", "Ma lo trinh khong ton tai!");
//        }
//
//        if(dangKyVeService.findById(dangKyDTO.getMaDangKy()).getSoLuongVe() > dangKyDTO.getSoLuongVe()) {
//            bindingResult.rejectValue("soLuongVe", "maLT", "So luong ve khong hop le!");
//        }
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("dangKyDTO", dangKyDTO);
//            return "main/update";
//        }
//
//        dangKy = modelMapper.map(dangKyDTO, DangKyVe.class);
//
//        dangKy.setMaDangKy(dangKyDTO.getMaDangKy());
//        System.out.println(dangKy.toString());
//        LoTrinh loTrinh = new LoTrinh();
//        if (flag) {
//            loTrinh = loTrinhService.findById(dangKyDTO.getMaLT()).get();
//            dangKy.setLoTrinh(loTrinh);
//        }
//        dangKy.setTongTien(dangKyVeService.tinhTongTien(loTrinh, dangKyDTO.getSoLuongVe()));
//        dangKyVeService.update(dangKy);
//        redirectAttributes.addFlashAttribute("message",
//                "Update thong tin dang ky ve thanh cong!");
//        return "redirect:/main/list";
//    }
//
//    /**
//     * @author DuyNT58
//     * @Author_birth_date: 1995-01-01
//     * @return
//     * @TODO
//     */
//    @ModelAttribute("loTrinhs")
//    public List<LoTrinh> getTinhThanhs() {
//        return loTrinhService.findAll();
//    }

}
