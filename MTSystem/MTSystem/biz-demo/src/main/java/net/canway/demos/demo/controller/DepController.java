package net.canway.demos.demo.controller;



import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.canway.demos.demo.pojos.DepBean;
import net.canway.demos.demo.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.resource.HttpResource;
import org.w3c.dom.ls.LSOutput;

import java.util.List;

@RestController
@RequestMapping("/dep")
@Api(tags = "DEP_MANAGER", description = "部门管理")
public class DepController {

    @Autowired
    private DepService depService;

    @GetMapping
    @ApiOperation("获取部门列表")
    public List<DepBean> list() {

        return  depService.list();
    }

    @GetMapping("/{depId}")
    @ApiOperation(value = "获取部门信息")
    public DepBean getDepName(
            @PathVariable
            @ApiParam(value = "部门ID", required = true)
                    Integer depId) {
        return depService.getDepById(depId);
    }

    @PutMapping
    @ApiOperation("更新部门信息")
    public Boolean update(
            @RequestBody
            @ApiParam("部门信息")
                    DepBean depBean
    ) {
        return depService.update(depBean);
    }

    @PostMapping
    @ApiOperation("添加部门信息")
    public Boolean add(
            @RequestBody
            @ApiParam("部门信息")
                    DepBean depBean) {
        return depService.add(depBean);
    }

    @DeleteMapping("/{depId}")
    @ApiOperation("通过部门ID删除部门信息")
    public Boolean delete(
            @PathVariable
            @ApiParam(value = "部门信息", required = true)
                    int depId) {
        return depService.delete(depId);
    }




}
