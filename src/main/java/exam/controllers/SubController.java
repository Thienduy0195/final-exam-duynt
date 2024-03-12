package exam.controllers;

import exam.dto.SubDTO;
import exam.entities.Person;
import exam.services.ISubService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping(value = "/sub")
public class SubController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ISubService subService;

//    @Autowired
//    private ISubService subService;

    @GetMapping("")
    public String returnMain() {
        return "redirect:/sub/list";
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
        System.out.println("CREATE");
        model.addAttribute("subDTO", new SubDTO());
        return "sub/create";
    }

    /**
     * @param subDTO
     * @param bindingResult
     * @param model
     * @return
     * @author DuyNT58
     * @Author_birth_date: 1995-01-01
     * @TODO
     */
    @PostMapping("/create")
    public String createNew(
            @Valid @ModelAttribute("subDTO") SubDTO subDTO,
            BindingResult bindingResult, Model model) {
        System.out.println("POST");
        System.out.println("BEFORE" + subDTO.toString());

        try {
//            subDTO.validate(subDTO, bindingResult);

            if (bindingResult.hasErrors()) {
                List<FieldError> errors = bindingResult.getFieldErrors();
                errors.forEach(item -> {
                    System.out.println(item);
                });
                model.addAttribute("subDTO", subDTO);
                return "sub/create";
            }
            Person main = modelMapper.map(subDTO, Person.class);
            System.out.println("AFTER" + main.toString());
            subService.save(main);
            return "redirect:/sub/list";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/sub/list";
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
        List<SubDTO> list = subService.findAllMapDTO();
        model.addAttribute("list", list);
        return "sub/list";
    }


    /**
     * @author DuyNT58
     * @Author_birth_date: 1995-01-01
     * @param searchName
     * @param model
     * @return
     * @TODO
     */
    @GetMapping("/search")
    public String search(
            @RequestParam(value = "searchName", required = true) String searchName, Model model) {
        List<SubDTO> list = subService.search(searchName);
        model.addAttribute("searchName", searchName);
        model.addAttribute("list", list);
        return "sub/list";
    }

//    @GetMapping("/search")
//    public String search(
//            @RequestParam(value = "searchName", required = true) String searchName,
//            @RequestParam(name = "page", defaultValue = "0") int page, Model model) {
//        try {
//            int start = page > 0 ? page - 1 : 0;
//            int recordsPerPage = 5;
//            int noOfRecords = subService
//                    .countRecordBySearch(searchName).size();
//            List<SubDTO> list = subService.search(
//                    searchName, (start) * recordsPerPage, recordsPerPage);
//            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
//            if (page < 1) {
//                page = 2;
//            } else if (page > noOfPages) {
//                page = noOfPages - 1;
//            }
//            model.addAttribute("searchName", searchName);
//            model.addAttribute("noOfPages", noOfPages);
//            model.addAttribute("currentPage", page);
//            model.addAttribute("list", list);
//            return "sub/list";
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "sub/list";
//    }

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
