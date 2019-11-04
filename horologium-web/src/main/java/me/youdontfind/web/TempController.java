package me.youdontfind.web;

import me.youdontfind.service.TempService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TempController {

    private final TempService tempService;

    public TempController(TempService tempService) {
        this.tempService = tempService;
    }

    @GetMapping(value = "/temp")
    public String tempGet() {
        return tempService.getHello();
    }

}
