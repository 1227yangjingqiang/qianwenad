package com.qianwenad.controller.sys;

import com.qianwenad.common.ApiResponse;
import com.qianwenad.model.sys.Resource;
import com.qianwenad.service.sys.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/ad")
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

}
