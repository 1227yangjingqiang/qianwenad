package com.qianwenad.common;

/**
 * 错误码定义
 * 
 * @author dexterman
 * @date 2017-10-27
 */
public enum ResponseCode {
    
    SUCCESS(200, "success"),
	HTTP_REDIRECT(302, "redirect"),

	SYSTEM_ERROR(9999, "系统内部错误"),
	HTTP_PROTOCOL_ERROR(9998, "HTTP协议错误,请检查"),
	HTTP_IO_ERROR(9997, "HTTP数据传输失败,请检查网络连接"),
	NOT_SUPPORTED_HTTP_METHOD(9996, "不支持该http请求方法"),
	HTTP_RESP_BODY_EMPTY(9995, "http响应body为空"),
	HTTP_RESP_BODY_FORMAT_ERR(9994, "http响应body格式错误"),
	HTTP_RESP_STATUS_ERR(9993, "http响应状态码错误"),
	HTTP_RESP_BODY_FORMAT_NOT_SUPPORTED(9992, "不支持的响应格式"),
	HTTP_URL_SYNTAX_ERR(9991, "url语法不正确"),
	HTTP_UNSUPPORTED_ENCODING_ERR(9990, "请求内容使用了不支持的编码"),

    INVALID_INPUT_VALUE(10002, "输入参数不合法"),
    INVALID_USER_ID(10003, "用户ID不合法"),
    USER_NOT_LOGIN(10004, "用户未登录"),
    USER_NOT_ANY_ROLE(10005, "用户尚未分配角色"),
    ROLE_IS_NOT_EXIST(10006, "角色不存在"),
    ROLE_NOT_ANY_RESOURCE(10007, "该角色尚未分配有资源信息"),
    ASSIGN_RESOURCES_IS_EMPTY(10008, "分配的资源id列表为空"),
	READ_IMAGE_CONTENT_FAILED(22001, "无法读取文件内容"),
	UPLOAD_IMAGE_FAILED(22003, "文件上传失败"),
    ALREADY_EXIST(30001, "已存在"),
    NOT_FOUND(30002, "实体未找到"),
    SA_NOT_FOUND_BY_MOBILENO(30003, "根据手机号查询不到对应的顾问信息"),
    SA_FOUND_MORETHEN_ONE_BY_MOBILENO(30004, "当前手机号被注册多个顾问"),

	ADD_TO_QYWX_FAIL(31001, "创建顾问企业微信账号失败"),
	SEND_SMS_EXCEPTION(31002, "短信发送出现异常"),
	SA_ACCT_ALREADY_EXIST(31003, "顾问账号已存在"),

	TRIPLE_DES_ENCTYPT_FAIL(32001, "对称加密失败"),
	TRIPLE_DES_DECRYPT_FAIL(32002, "对称解密失败"),

	GET_RECOMMEND_LIST_ERR(33001, "查询推荐位列表出错"),
	GET_RECOMMEND_ERR(33002, "获取推荐位出错"),
	ADD_RECOMMEND_ERR(33003, "新增推荐位失败"),
	UPDATE_RECOMMEND_ERR(33004, "更新推荐位失败"),
	UNSUPPORTED_IMAGE_TYPE(33010, "不支持上传该文件类型"),

	CURRENT_TIME_IS_OVERDUE(34011, "当前时间已超过活动的开始时间"),
    ;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(Object... holders){
        return String.format(message, holders);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
