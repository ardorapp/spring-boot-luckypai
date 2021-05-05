//package cash.pai.lucky.web;
//
//import cash.pai.lucky.admin.annotation.Decrypt;
//import cash.pai.lucky.admin.annotation.Encrypt;
//import cash.pai.lucky.admin.common.pojo.PageCondition;
//import cash.pai.lucky.admin.common.pojo.PageInfo;
//import cash.pai.lucky.admin.common.pojo.Result;
//import cash.pai.lucky.admin.util.CopyUtil;
//import cash.pai.lucky.entity.LuckyCash;
//import cash.pai.lucky.entity.LuckyCashExample;
//import cash.pai.lucky.param.LuckyCashParam;
//import cash.pai.lucky.service.LuckyCashService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@Api(tags ="幸运现金")
//@RestController
//@RequestMapping("/assets/luckycash/")
//public class LuckyCashController{
//    @Autowired
//    private LuckyCashService luckyCashService;
//
//    @GetMapping("setting")
//    public ModelAndView setting() {
//        return new ModelAndView("assets/luckycash/luckycash", "luckycash", luckyCashService.findById("1"));
//    }
//
//    /**
//     * 获取列表红包
//     * @return
//     */
//    @ApiOperation(value="获取列表红包")
//    @PostMapping("page")
//    @Decrypt
//    @Encrypt
//    public Result<PageInfo<LuckyCash>> page(PageCondition pageCondition) {
//        List<LuckyCash> list = luckyCashService.findByMyCreate();
//
//        int records = list.size();
//        int pageSize = pageCondition.getRows();
//        int total = records % pageSize == 0 ? records / pageSize : records / pageSize + 1;
//
//        PageInfo<LuckyCash> pageInfo = new PageInfo<>();
//        pageInfo.setPage(pageCondition.getPage() + 1);//页码
//        pageInfo.setPageSize(pageSize);//页面大小
//        pageInfo.setRows(CopyUtil.copyList(list, LuckyCash.class));//分页结果
//        pageInfo.setRecords(records);//总记录数
//        pageInfo.setTotal(total);//总页数
//        return Result.of(pageInfo);
//    }
//
//    /**
//     * 创建一个新红包
//     * @return
//     */
//    @ApiOperation(value="创建一个新红包")
//    @PostMapping("create")
//    @ResponseBody
//    public Result create(@RequestBody @Valid LuckyCashParam luckyCashParam) {
//        Result result = luckyCashService.create(luckyCashParam);
//        return result;
//    }
//
//    /**
//     * 编辑保存红包
//     * @return
//     */
//    @ApiOperation(value="编辑保存红包")
//    @PostMapping("save")
//    @Decrypt
//    @Encrypt
//    public Result save(LuckyCash luckyCash) {
//        Result result = luckyCashService.save(luckyCash);
//        return result;
//    }
//
//    /**
//     * 删除红包
//     * @return
//     */
//    @ApiOperation(value="删除红包")
//    @PostMapping("delete")
//    @ResponseBody
//    public Result delete(@RequestBody @Valid String luckycashId) {
//        Result result = luckyCashService.delete(luckycashId);
//        return result;
//    }
//}
