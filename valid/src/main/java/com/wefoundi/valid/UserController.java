package com.wefoundi.valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);


    @GetMapping("/get")
    public UserAddDTO get(@RequestParam("id") @Min(value = 1L, message = "编号必须大于 0") Integer id) {
        logger.info("[get][id: {}]", id);
        UserAddDTO userAddDTO = new UserAddDTO();
        userAddDTO.setUsername("张三");
        userAddDTO.setPassword("123456");
        return userAddDTO;
    }

    @PostMapping("/add")
    public void add(@RequestBody @Valid UserAddDTO userAddDTO) {
        logger.info("[add][userAddDTO: {}]", userAddDTO);
    }

}
