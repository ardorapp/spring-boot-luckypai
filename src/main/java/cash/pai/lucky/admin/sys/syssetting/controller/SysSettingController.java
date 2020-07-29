package cash.pai.lucky.admin.sys.syssetting.controller;

import cash.pai.lucky.admin.common.controller.CommonController;
import cash.pai.lucky.admin.sys.syssetting.pojo.SysSetting;
import cash.pai.lucky.admin.sys.syssetting.service.SysSettingService;
import cash.pai.lucky.admin.sys.syssetting.vo.SysSettingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/sys/sysSetting/")
public class SysSettingController extends CommonController<SysSettingVo, SysSetting, String> {
    @Autowired
    private SysSettingService sysSettingService;

    @GetMapping("setting")
    public ModelAndView setting() {
        return new ModelAndView("sys/setting/setting", "sys", sysSettingService.get("1").getData());
    }
}
