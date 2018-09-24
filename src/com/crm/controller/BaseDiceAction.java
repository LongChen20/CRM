package com.crm.controller;

import com.crm.domain.BaseDict;
import com.crm.service.BaseDiceService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;

import java.util.List;

/**
 * @author LGCN
 */
public class BaseDiceAction extends ActionSupport implements ModelDriven<BaseDict> {

    private BaseDict basedict = new BaseDict();

    private BaseDiceService baseDiceService;
    public void setBaseDiceService(BaseDiceService baseDiceService) {
        this.baseDiceService = baseDiceService;
    }

    public String getResource(){
        try {
            //更具类别办好查询字典表。返回JSON串到客户端显示。
            List<BaseDict> baseDicts = baseDiceService.findkeyTypeCode(basedict);
            //转JSON，JSONArray数组或List转JSON，JSONObject对象或Map转JSON。JsonConfig转json配置对象（配置不需要转的字段），
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.setExcludes(new String[]{"dict_sort","dict_enable","dict_memo"});
            JSONArray jsonArray = JSONArray.fromObject(baseDicts,jsonConfig);
            //返回页面
            ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
            ServletActionContext.getResponse().getWriter().print(jsonArray.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return NONE;
    }

    @Override
    public BaseDict getModel() {
        return basedict;
    }
}
