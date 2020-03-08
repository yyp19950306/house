package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.entity.Users;
import com.team.house.service.HouseService;
import com.team.house.sms.SendMsgUtil;
import com.team.house.util.FileUploadUtil;
import com.team.house.util.HouseCondition;
import com.team.house.util.PageParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(value = "*",allowCredentials = "true")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @RequestMapping("/addHouse")
    public String  addHouse(House house, HttpSession session, @RequestParam(value = "file",required = false) MultipartFile file) {
        try {
            String path = "G:\\U4\\Work\\fileupload";
            String fileName = FileUploadUtil.upload(file, path);
            house.setPath(fileName);
            Users users = (Users) session.getAttribute("userInfo");
            //house.setUserId(1007);//测试时默认用户ID1007
            house.setUserId(users.getId());
            house.setId(System.currentTimeMillis() + "");
            Integer temp = houseService.addHouse(house);
            return "{\"result\":1}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"result\":0}";
        }
    }

    @RequestMapping("/getHouseByUserId")
    public Map<String,Object> getHouseByUserId(Integer pageNum, HttpSession session) {
        PageParameter pageParameter = new PageParameter();
        pageParameter.setPageNum(pageNum);
        Users users = (Users) session.getAttribute("userInfo");
        PageInfo<House> pageInfo = houseService.getHouseByUserId(pageParameter, users.getId());
        Map<String, Object> map = new HashMap<>();
        map.put("pages", pageInfo.getPages());
        map.put("list", pageInfo.getList());
        return map;
    }

    @RequestMapping("/deleteHouse")
    public String deleteHouse(String id,String fileName) {
        Integer temp = houseService.deleteHouse(id);
        if (temp > 0) {
            File file = new File("G:\\U4\\Work\\fileupload\\" + fileName);
            if (file.exists()) {
                file.delete();
            }
        }
        return "{\"result\":" + temp + "}";
    }

    @RequestMapping("/getHouseByCondition")
    public Map<String, Object> getHouseByCondition(HouseCondition houseCondition) {
        System.out.println(houseCondition.getPageNum());
        PageInfo<House> pageInfo = houseService.getHouseByCondition(houseCondition);
        Map<String, Object> map = new HashMap<>();
        map.put("pages", pageInfo.getPages());
        map.put("list", pageInfo.getList());
        return map;
    }

    @RequestMapping("/sendCode")
    public String sendCode(String smsMob,HttpSession session) {
        int code = (int) Math.round((Math.random() + 1) * 1000);
        session.setAttribute("randCode", code);
        session.setMaxInactiveInterval(300);
        String smsText = "验证码是：" + code;
        int result = SendMsgUtil.sendMsg(smsText, smsMob);
        return "{\"result\":" + result + "}";
    }

    @RequestMapping("/loginAction2")
    public String loginAction2(String inputCode, HttpSession session) {
        String randCode = session.getAttribute("randCode").toString();
        if (inputCode.equals(randCode)) {

            return "{\"result\":1}";
        } else {
            return "{\"result\":0}";
        }
    }
}
