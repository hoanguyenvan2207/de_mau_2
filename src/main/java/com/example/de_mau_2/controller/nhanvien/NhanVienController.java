package com.example.de_mau_2.controller.nhanvien;

import com.example.de_mau_2.entity.NhanVien.ChucVuRespone;
import com.example.de_mau_2.entity.NhanVien.NhanVien;
import com.example.de_mau_2.entity.NhanVien.NhanVienRequest;
import com.example.de_mau_2.entity.NhanVien.NhanVienRespone;
import com.example.de_mau_2.service.NhanVien.ChucVuService;
import com.example.de_mau_2.service.NhanVien.NhanVienService;
import lombok.Getter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nhan-vien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private ChucVuService chucVuService;

    @GetMapping("/groups")
    public String showList(){
        return "/nhan-vien/groups";
    }

    @ModelAttribute("page")
    Page<NhanVienRespone> getNhanVienRes(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(defaultValue = "10")Integer size){
        return nhanVienService.findAllNhanVienRes(page, size);
    }

    @ModelAttribute("dsChucVu")
    List<ChucVuRespone> getAllChucVu(){
        return chucVuService.findAllChucVu();
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id){
        nhanVienService.deleteNhanVien(id);
        return "redirect:/nhan-vien/groups";
    }

    @GetMapping("/detail")
    public String detail(Model model,@RequestParam("id") Integer id){
        NhanVienRespone nhanVienRespone = new NhanVienRespone();
        NhanVien nhanVien = nhanVienService.findNhanVienById(id);

        BeanUtils.copyProperties(nhanVien, nhanVienRespone);
        nhanVienRespone.setIdChucVu(nhanVien.getChucVu().getId());
        model.addAttribute("nv", nhanVienRespone);
        return "/nhan-vien/groups";
    }

    @PostMapping("/add")
    public String add(NhanVienRequest nhanVienRequest){
        NhanVien nhanVien = new NhanVien();

        BeanUtils.copyProperties(nhanVienRequest, nhanVien);
        nhanVienService.addNhanVien(nhanVien);
        return "redirect:/nhan-vien/groups";
    }

    @GetMapping("/search")
    public String search(Model model,
                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                         @RequestParam(defaultValue = "10")Integer size,
                         @RequestParam(value = "ten", required = false)String ten){
        model.addAttribute("page", nhanVienService.findNhanVienByTen(ten, page, size));
        return "nhan-vien/groups";
    }
}
