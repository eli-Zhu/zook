package com.zook.web.controller;

import com.alibaba.fastjson.JSON;
import com.zook.core.exception.ZookException;
import com.zook.core.service.DomainService;
import com.zook.core.vo.DomainVO;
import com.zook.persistence.operation.DomainQueryDO;
import com.zook.web.form.ResultMsg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 域资源管理
 * Created by Eli on 2018/8/14.
 */
@Controller
@RequestMapping("/domain")
public class DomainController extends BaseController {
    @Resource
    private DomainService domainService;

    /**
     * 主页
     *
     * @return
     */
    @RequestMapping("/list")
    public String list() {
        return "domain/list";
    }

    /**
     * 分页获取数据
     * @param domainQuery
     * @return
     */
    @RequestMapping("/getList")
    @ResponseBody
    public ResultMsg getList(DomainQueryDO domainQuery) {
        ResultMsg result=ResultMsg.success();

        result.setObj(domainService.pageQuery(domainQuery));
        return result;

    }


    /**
     * 创建域节点
     *
     * @param domain
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg create(DomainVO domain) {
        ResultMsg result = new ResultMsg();
        result.setResult(false);
        try {
            if (domainService.createDomain(domain)) {
                result = ResultMsg.success();
            }
        } catch (ZookException e) {
            result = ResultMsg.fail(e.getMessage());
        } catch (Exception e) {
            result = ResultMsg.fail();
        }
        return result;
    }

    /**
     * 编辑页
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(Long id, Model model) {
        DomainVO domain = new DomainVO();
        if (id != null) {
            domain = domainService.findById(id);
        }
        model.addAttribute("formData", JSON.toJSONString(domain));

        return new ModelAndView("domain/form");
    }

    /**
     * 更新
     *
     * @param id
     * @param domain
     * @return
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg update(Long id, DomainVO domain) {
        ResultMsg result = new ResultMsg();
        result.setResult(false);
        try {
            if (domainService.updateDomain(domain)) {
                result = ResultMsg.success();
            }
        } catch (ZookException e) {
            result = ResultMsg.fail(e.getMessage());
        } catch (Exception e) {
            result = ResultMsg.fail();
        }
        return result;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ResultMsg delete(Long id) {
        ResultMsg result = new ResultMsg();
        result.setResult(false);
        try {
            if (domainService.deleteDomain(id)) {
                result = ResultMsg.success();
            }
        } catch (ZookException e) {
            result = ResultMsg.fail(e.getMessage());
        } catch (Exception e) {
            result = ResultMsg.fail();
        }
        return result;
    }
}
