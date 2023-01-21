package com.PIMS.PIMS.controller;

import com.PIMS.PIMS.model.Vartype;
import com.PIMS.PIMS.service.VartypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VartypeController {

    @Autowired
    VartypeService vartypeService;

    @GetMapping("/")
    public String Findall(Model model) {
        model.addAttribute("vartype", vartypeService.finallVartyps());
        return "all-vartype";
    }

    @GetMapping("/add")
    public String addVartype(Model model) {
        model.addAttribute("vartype", new Vartype());
        return "add-vartype";
    }

    @PostMapping("/addvartype")
    public String CreateVartype(Vartype vartype) {
        vartypeService.addVartype(vartype);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editVartype(Model model, @PathVariable("id") int id) {
        model.addAttribute("vartype", vartypeService.findVartypeById(id));
        return "edit.vartype";
    }

    @PostMapping("/updatevartype")
    public String updatVartype(Vartype vartype) {
        vartypeService.updateVartype(vartype);
        return "redirect:?";
    }

    @GetMapping("/delete/{id}")
    public String deleteVartupe(@PathVariable("id") int id) {
        vartypeService.deleteById(id);
        return "redirect:/";
    }
@GetMapping("/teste")
public String test(){
Vartype st=new Vartype();
st.setId(1);
st.setName("ait");
st.setSiginificado("analise");
vartypeService.addVartype(st);
return "ok";
}
}