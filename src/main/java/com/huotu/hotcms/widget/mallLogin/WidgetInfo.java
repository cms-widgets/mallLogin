/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.hotcms.widget.mallLogin;

import java.util.*;

import com.huotu.hotcms.service.common.PageType;
import com.huotu.hotcms.widget.*;
import me.jiangcai.lib.resource.service.ResourceService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.Map;


/**
 * @author CJ
 */
public class WidgetInfo implements Widget, PreProcessWidget {
    private static final Log log = LogFactory.getLog(WidgetInfo.class);
    public static final String VALID_PAGE_IDS = "pageIds";

    @Override
    public String groupId() {
        return "com.huotu.hotcms.widget.mallLogin";
    }

    @Override
    public String widgetId() {
        return "mallLogin";
    }

    @Override
    public String name(Locale locale) {
        if (locale.equals(Locale.CHINA)) {
            return "登录组件";
        }
        return "mallLogin";
    }

    @Override
    public String description(Locale locale) {
        if (locale.equals(Locale.CHINA)) {
            return "这是一个 A custom Widget，你可以对组件进行自定义修改。";
        }
        return "This is a mallLogin,  you can make custom change the component.";
    }

    @Override
    public String dependVersion() {
        return "1.0-SNAPSHOT";
    }

    @Override
    public WidgetStyle[] styles() {
        return new WidgetStyle[]{new DefaultWidgetStyle()};
    }

    @Override
    public Resource widgetDependencyContent(MediaType mediaType) {
        if (mediaType.equals(Widget.Javascript))
            return new ClassPathResource("js/widgetInfo.js", getClass().getClassLoader());
        return null;
    }

    @Override
    public Map<String, Resource> publicResources() {
        Map<String, Resource> map = new HashMap<>();
        map.put("thumbnail/defaultStyleThumbnail.png", new ClassPathResource("thumbnail/defaultStyleThumbnail.png"
                , getClass().getClassLoader()));
        return map;
    }

    @Override
    public void valid(String styleId, ComponentProperties componentProperties) throws IllegalArgumentException {
        WidgetStyle style = WidgetStyle.styleByID(this, styleId);
        //加入控件独有的属性验证

    }

    @Override
    public Class springConfigClass() {
        return null;
    }

    @Override
    public boolean disabled() {
        return CMSContext.RequestContext().getSite().getOwner() != null && CMSContext.RequestContext().getSite().getOwner().getCustomerId() != null;
    }

    @Override
    public PageType supportedPageType() {
        return PageType.Login;
    }

    @Override
    public ComponentProperties defaultProperties(ResourceService resourceService) throws IOException {
        ComponentProperties properties = new ComponentProperties();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "首页");
        map1.put("linkPath", "");
        map1.put("visibleValue", "");
        map1.put("flag", 0);
        map1.put("isParent", "false");
        map1.put("visible", "");
        map1.put("visibleName", "");
        map1.put("id", 1);
        List<Map<String, Object>> navbarPageInfoModels = new ArrayList<>();
        navbarPageInfoModels.add(map1);
        properties.put(VALID_PAGE_IDS, navbarPageInfoModels);
        return properties;
    }

    @Override
    public void prepareContext(WidgetStyle style, ComponentProperties properties, Map<String, Object> variables
            , Map<String, String> parameters) {

    }

}
