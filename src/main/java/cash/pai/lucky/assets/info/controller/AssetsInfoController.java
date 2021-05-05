//package cash.pai.lucky.assets.info.controller;
//
//import cash.pai.lucky.admin.common.controller.CommonController;
//import cash.pai.lucky.assets.info.pojo.AssetsInfo;
//import cash.pai.lucky.assets.info.service.AssetsInfoService;
//import cash.pai.lucky.assets.info.vo.AssetsInfoVo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//
//@RestController
//@RequestMapping("/assets/info/")
//public class AssetsInfoController extends CommonController<AssetsInfoVo, AssetsInfo, String> {
//    @Autowired
//    private AssetsInfoService assetsInfoService;
//
//    @GetMapping("setting")
//    public ModelAndView setting() {
//        return new ModelAndView("assets/info/info", "assets", assetsInfoService.get("1").getData());
//    }
//}
