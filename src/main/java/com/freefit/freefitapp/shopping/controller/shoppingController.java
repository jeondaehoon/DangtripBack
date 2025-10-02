package com.freefit.freefitapp.shopping.controller;

import com.freefit.freefitapp.shopping.service.shoppingService;
import com.freefit.freefitapp.vo.CartVO;
import com.freefit.freefitapp.vo.ShoppingVO;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class shoppingController {
    @Autowired
    private shoppingService service;

    @GetMapping("/shopping/categories")
    @ResponseBody
    public List<ShoppingVO> selectCategory() throws Exception{
        return service.selectCategory();
    }

    @GetMapping("/shopping/products")
    @ResponseBody
    public List<ShoppingVO> selectProduct(
            @RequestParam(value = "categoryId", required = false) Integer categoryId) throws Exception {
        return service.selectProduct(categoryId);
    }

    @GetMapping("/shopping/rankings")
    @ResponseBody
    public List<ShoppingVO> selectRankings() throws Exception{
        return service.selectRankings();
    }

    @PostMapping("/cart")
    @ResponseBody
    public ResponseEntity<String> addCart(@RequestBody CartVO vo) throws Exception{
        boolean add = service.addCart(vo);
        if (add) {
            return ResponseEntity.ok("추가 되었습니다.");
        } else {
            return ResponseEntity.status(500).body("추가 실패");
        }
    }
}
