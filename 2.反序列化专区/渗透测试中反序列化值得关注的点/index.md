# 渗透测试中反序列化值得关注的点

## 写在前面

这篇文章主要是看到某些文章后有感而发

## 正文

### 压缩特征(压缩后一些数据格式改变)

- zip格式特征:PK*
- zip+base64：UE*
- gzip+base64：H4s*

### 反序列化数据特征(数据内容+请求类型)

- “AC ED 00 05” in Hex
- *“rO0” in Base64*
- Content-type = ‘*application/x-java-serialized-object*



## 参考文章

https://medium.com/@D0rkerDevil/how-i-found-a-1500-worth-deserialization-vulnerability-9ce753416e0a
