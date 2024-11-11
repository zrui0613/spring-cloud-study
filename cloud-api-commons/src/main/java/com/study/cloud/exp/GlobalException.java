package com.study.cloud.exp;

import com.study.cloud.resp.ResultData;
import com.study.cloud.resp.ReturnCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler(value = RuntimeException.class)
    public ResultData<String> exceptionHandler(Exception e){
        return ResultData.fail(ReturnCodeEnum.RC404.getCode(), e.getMessage());
    }
}
