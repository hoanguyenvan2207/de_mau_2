package com.example.de_mau_2.controller.SanPham;

import com.example.de_mau_2.entity.SanPham.*;
import com.example.de_mau_2.service.SanPham.LoaiSanPhamService;
import com.example.de_mau_2.service.SanPham.SanPhamServie;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamServie sanPhamServie;

    @Autowired
    private LoaiSanPhamService loaiSanPhamService;


    @GetMapping("/groups")
    public String showList(Model model,
                           @RequestParam(value = "page", defaultValue = "0") Integer page,
                           @RequestParam(defaultValue = "10") Integer size){

        model.addAttribute("page", sanPhamServie.findAllSanPhamRespne(page, size));
        model.addAttribute("sanPhamRequest", new SanPhamRequest());
        return "/san-pham/hien-thi";
    }

    @ModelAttribute("dsLoaiSanPham")
    List<LoaiSanPhamRespone> finAllLoaiSanPham(){
        return loaiSanPhamService.findAllLoaiSanPhamRespone();
    }

    @GetMapping("detail")
    public String detail(Model model, @RequestParam("id") Integer id,
                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                         @RequestParam(defaultValue = "10") Integer size){

        SanPham sanPham = sanPhamServie.findSanPhamById(id);
        SanPhamRequest sanPhamRequest = new SanPhamRequest();
        BeanUtils.copyProperties(sanPham, sanPhamRequest);

        model.addAttribute("sanPhamRequest", sanPhamRequest);
        model.addAttribute("sp", sanPhamRequest);
        model.addAttribute("page", sanPhamServie.findAllSanPhamRespne(page, size));
        return "/san-pham/hien-thi";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id){
        sanPhamServie.deleteSanPham(id);
        return "redirect:/san-pham/groups";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("sanPhamRequest") SanPhamRequest sanPhamRequest, BindingResult bindingResult,
                      @RequestParam(value = "page", defaultValue = "0") Integer page,
                      @RequestParam(defaultValue = "10") Integer size, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("page", sanPhamServie.findAllSanPhamRespne(page, size));
            return "/san-pham/hien-thi";
        }
        SanPham sanPham = new SanPham();
        BeanUtils.copyProperties(sanPhamRequest, sanPham);
        sanPhamServie.add(sanPham);
        return "redirect:/san-pham/groups";
    }
}
