package com.qianwenad.controller.refund;

import com.qianwenad.common.ApiResponse;
import com.qianwenad.model.refund.Refund;
import com.qianwenad.service.refund.RefundService;
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
public class RefundRestApiController {

    @Autowired
    private RefundService refundService;

    @RequestMapping(value = "/refund/{id}", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getRefundById(@PathVariable Long id) {
        return new ResponseEntity<>(ApiResponse.ok(refundService.findByPrimaryKey(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/refund", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse> createRefund(@RequestBody Refund refund) {
        return new ResponseEntity<>(ApiResponse.ok(refundService.create(refund)), HttpStatus.OK);
    }

}
