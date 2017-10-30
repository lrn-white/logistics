package com.liu.controller;

import com.liu.bean.Goods;
import com.liu.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author lrn
 * @Date 2017/10/30
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/addGoods")
    public Integer addGoods(Goods goods) {
        return goodsService.addGoods(goods);
    }

    @RequestMapping("/updateGoods")
    public Integer updateGoods(Goods goods) {
        return goodsService.updateGoods(goods);
    }

    @RequestMapping("/deleteGoods")
    public Integer deleteGoodsById(Integer id) {
        return goodsService.deleteGoodsById(id);
    }

    @RequestMapping("/getGoodsById")
    public Goods getGoodsById(Integer id) {
        return goodsService.getGoodsById(id);
    }

    @RequestMapping("/getGoodsByConsignee")
    public Goods getGoodsByConsignee(String consignee) { return goodsService.getGoodsByConsignee(consignee); }

    @RequestMapping("/getAll")
    public List<Goods> queryGoodsByList() {
        return goodsService.queryGoodsByList();
    }
}
