package com.example.demo1227.pd;

import com.example.demo1227.serive.OrderSer;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderCon {
    @Autowired
    OrderSer ods;
    @GetMapping("/ordera")
    public String getAll(Model model){
        model.addAttribute("orders",ods.getAll());
        return "odl";
    }
    @GetMapping("/orderc")
    public String getByCustomer(Model model, HttpServletRequest request) {
        String cno = request.getParameter("cno");
        int cno2 = 0;
        if( cno != null ) {
            cno2 = Integer.parseInt(cno);
        }

        model.addAttribute("orders", ods.getocn(cno2));
        return "odl";

    }
    @GetMapping("/odn")
    public String odn(Model model, @RequestParam int ono){
        model.addAttribute("orders",ods.getoid(ono));
        return "odl";
    }
    @GetMapping("/qc")
    public String toQuery() {
        return "QCustomer";
    }
    @GetMapping("/qono")
    public String QueryByOrderno() {
        return "QOrder";
    }
}
