# dblog

基于SSM（SpringMVC+Spring+MyBits）开发的博客，这个博客计划做成完全前后端分离的。

## 接口

### 编辑文章

http://baseUrl/post/save
### 文章列表

http://baseUrl/post/list

### 文章详情

http://baseUrl/post/view

### 文件上传

http://baseUrl/upload/file

example

```
POST /dblog/upload/file HTTP/1.1
Host: localhost:8081
Cache-Control: no-cache
Postman-Token: af848627-7f0b-bda2-ea8f-179d53fe91a3
Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW

------WebKitFormBoundary7MA4YWxkTrZu0gW
Content-Disposition: form-data; name="file"; filename=""
Content-Type: 


------WebKitFormBoundary7MA4YWxkTrZu0gW--
```

响应

```json
{
    "code": 0,
    "msg": null,
    "data": {
        "url": "/dblog/uploads/sngapm-storm.jar"
    }
}
```