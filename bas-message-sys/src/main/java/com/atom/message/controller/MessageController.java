package com.atom.message.controller;


import com.atom.bas.common.Result;
import com.atom.bas.common.ResultUtil;
import com.atom.message.dto.SMSEntity;
import com.atom.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/***
 *
 * 消息服务
 * 1.提供发送消息[邮件 | 短信 | 极光 | 友盟]
 * 2.消息记录查询
 *
 *
 */
@RestController
@RequestMapping("message")
public class MessageController {


    @Autowired
    private MessageService messageService;


    /***
     * 发送消息
     *
     * @return
     */
    @RequestMapping("/sendMessage")
    public Result sendMessage(@RequestBody @Validated SMSEntity entity){
        return ResultUtil.success(messageService.sendMessage(entity));
    }











}
