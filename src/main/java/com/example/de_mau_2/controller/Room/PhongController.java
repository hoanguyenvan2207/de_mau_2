package com.example.de_mau_2.controller.Room;

import com.example.de_mau_2.entity.Phong.*;
import com.example.de_mau_2.repository.Phong.LoaiPhongRepo;
import com.example.de_mau_2.repository.Phong.PhongRepo;
import com.example.de_mau_2.service.Phong.PhongService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/room")
public class PhongController {

    @Autowired
    private PhongRepo phongRepo;

    @Autowired
    private PhongService phongService;

    @Autowired
    private LoaiPhongRepo loaiPhongRepo;

    List<PhongRespone> dsPhongRespone = new ArrayList<>();

    @GetMapping("groups")
    public String groups(Model model,
                         @RequestParam(value = "page",defaultValue = "0") int page,
                         @RequestParam(defaultValue = "10") int size){
        model.addAttribute("page", phongService.findAll(page, size));
        model.addAttribute("phongRequest", new PhongRequest());
        return ("hien-thi");
    }

    @GetMapping("groups1")
    public String groups1(Model model){
        for (Phong phong: phongRepo.findAll()){
            dsPhongRespone.add(new PhongRespone(
                    phong.getId(),
                    phong.getTenPhong(),
                    phong.getSoLuongPhong(),
                    phong.getTrangThai(),
                    phong.getGhiChu(),
                    phong.getLoaiPhong().getId(),
                    phong.getLoaiPhong().getTenLoaiPhong()
            ));
            model.addAttribute("ds", dsPhongRespone);
            model.addAttribute("phongRequest", new PhongRequest());
        }
        return ("hien-thi");
    }

    @ModelAttribute("dsLoaiPhong")
    List<LoaiPhongRespone> getListLoaiPhong(){
        return loaiPhongRepo.getAllLoaiPhongRespone();
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("phongRequest") PhongRequest phongRequest, BindingResult bindingResult, Model model,
                      @RequestParam(value = "page",defaultValue = "0") int page,
                      @RequestParam(defaultValue = "10") int size) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("page", phongService.findAll(page, size));
            return ("hien-thi");
        }
        Phong phong = new Phong();
        LoaiPhong loaiPhong = loaiPhongRepo.findById(phongRequest.getIdLoaiPhong()).get();
        BeanUtils.copyProperties(phongRequest, phong);
        phong.setLoaiPhong(loaiPhong);
        phongRepo.save(phong);

        return "redirect:/room/groups";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id){
        phongRepo.deleteById(id);
        return "redirect:/room/groups";
    }

}
