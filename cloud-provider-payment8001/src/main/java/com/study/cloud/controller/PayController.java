package com.study.cloud.controller;

import com.study.cloud.entities.Pay;
import com.study.cloud.entities.PayDTO;
import com.study.cloud.resp.ResultData;
import com.study.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PayController{
    @Resource
    private PayService payService;

    @PostMapping(value = "/pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    public ResultData<String> addPay(@RequestBody Pay pay)
    {
        System.out.println(pay.toString());
        int i = payService.add(pay);
        return ResultData.success("成功插入记录，返回值："+i);
    }

    @DeleteMapping(value = "/pay/del/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id) {
        int i = payService.delete(id);
        return ResultData.success(i);
    }

    @PutMapping(value = "/pay/update")
    @Operation(summary = "修改",description = "修改支付流水方法")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO)
    {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);

        int i = payService.update(pay);
        return ResultData.success("成功修改记录，返回值："+i);
    }

    @GetMapping(value = "/pay/get/{id}")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public ResultData<Pay> getById(@PathVariable("id") Integer id)
    {
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @GetMapping(value = "/pay/queryAll")
    public ResultData<List<Pay>> queryAll(){
        return ResultData.success(payService.getAll());
    }

}
