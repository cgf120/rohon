package cn.rohon.config;

import cn.rohon.utils.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
@Api(tags = {"基础接口"})
@RestController
@ResponseStatus(HttpStatus.OK)
@RequestMapping(value = "/no-login")
public class RohonController {
    @ApiOperation(value = "服务器信息")
    @RequestMapping(value = "/ms/v2/cdias/server", method = RequestMethod.GET)
    public ResultData getCdiasServer(HttpServletRequest request) {
        Map map = new HashMap();
        Runtime r = Runtime.getRuntime();
        Properties props = System.getProperties();
        map.put("jvm.total.memory", r.totalMemory());
        map.put("jvm.free.memory", r.freeMemory());
        map.put("jvm.processors", r.availableProcessors());
        map.put("java.version", props.getProperty("java.version"));
        map.put("java.vendor", props.getProperty("java.vendor"));
        map.put("java.vendor.url", props.getProperty("java.vendor.url"));
        map.put("java.home", props.getProperty("java.home"));
        map.put("java.vm.specification.version", props.getProperty("java.vm.specification.version"));
        map.put("java.vm.specification.vendor", props.getProperty("java.vm.specification.vendor"));
        map.put("java.vm.specification.name", props.getProperty("java.vm.specification.name"));
        map.put("java.vm.version", props.getProperty("java.vm.version"));
        map.put("java.vm.vendor", props.getProperty("java.vm.vendor"));
        map.put("java.vm.name", props.getProperty("java.vm.name"));
        map.put("java.specification.version", props.getProperty("java.specification.version"));
        map.put("java.specification.name", props.getProperty("java.specification.name"));
        map.put("java.class.version", props.getProperty("java.class.version"));
        map.put("os.name", props.getProperty("os.name"));
        map.put("os.arch", props.getProperty("os.arch"));
        map.put("os.version", props.getProperty("os.version"));
        map.put("server.info", request.getServletContext().getServerInfo());

        return ResultData.converResullt(true,"系统正常",map);
    }
}
