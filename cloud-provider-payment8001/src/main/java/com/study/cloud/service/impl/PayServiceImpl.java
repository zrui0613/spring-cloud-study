package com.study.cloud.service.impl;

import com.study.cloud.entities.Pay;
import com.study.cloud.service.PayService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayServiceImpl implements PayService {

    @Override
    public int add(Pay pay) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public int update(Pay pay) {
        return 0;
    }

    @Override
    public Pay getById(Integer id) {
        return null;
    }

    @Override
    public List<Pay> getAll() {
        return null;
    }
}
