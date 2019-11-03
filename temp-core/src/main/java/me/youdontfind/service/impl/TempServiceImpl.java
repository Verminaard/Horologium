package me.youdontfind.service.impl;

import me.youdontfind.service.TempService;
import org.springframework.stereotype.Service;

@Service
public class TempServiceImpl implements TempService {

    @Override
    public String getHello() {
        return "HelloWorld!";
    }

}
