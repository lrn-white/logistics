package com.liu.service;

import com.liu.bean.Goods;
import com.liu.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lrn
 * @Date 2017/10/30
 */
@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    public Integer addGoods(Goods goods) { return goodsMapper.addGoods(goods); }

    public Integer deleteGoodsById(Integer id) { return goodsMapper.deleteGoodsById(id); }

    public Integer updateGoods(Goods goods) {
        return goodsMapper.updateGoods(goods);
    }

    public Goods getGoodsById(Integer id) { return goodsMapper.getGoodsById(id); }

    public Goods getGoodsByConsignee(String consignee) { return goodsMapper.getGoodsByConsignee(consignee); }

    public List<Goods> queryGoodsByList() { return goodsMapper.queryGoodsByList(); }
}
