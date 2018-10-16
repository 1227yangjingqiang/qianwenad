package com.qianwenad.controller.sys;

import com.qianwenad.common.ApiListResponse;
import com.qianwenad.common.ApiResponse;
import com.qianwenad.common.mapper.AutoMapper;
import com.qianwenad.common.uitl.JsonUtil;
import com.qianwenad.model.sys.Resource;
import com.qianwenad.service.sys.ResourceService;
import com.qianwenad.vo.ResourceVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class ResourceRestApiController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "/resource/{id}", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getResourceById(@PathVariable Long id) {
        return new ResponseEntity<>(ApiResponse.ok(resourceService.findByPrimaryKey(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/resource", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse> createResource(@RequestBody Resource resource) {
        return new ResponseEntity<>(ApiResponse.ok(resourceService.create(resource)), HttpStatus.OK);
    }

    @RequestMapping(value = "/resource/list", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getResourceList(ResourceVO resourceVO) {
        log.info("getResourceList param:{}", JsonUtil.toJson(resourceVO));
        Resource r = new Resource();
        AutoMapper.mapping(resourceVO, r);
        ApiListResponse al = new ApiListResponse();
        al.setCount(resourceService.selectCount(r));
        al.setList(resourceService.selectPage(r, new PageRequest(resourceVO.getPage() - 1, resourceVO.getPageSize(), Sort.Direction.DESC, "id")));
        log.info("getResourceList res:{}", JsonUtil.toJson(al));
        return new ResponseEntity<>(ApiResponse.ok(al), HttpStatus.OK);
    }

}
