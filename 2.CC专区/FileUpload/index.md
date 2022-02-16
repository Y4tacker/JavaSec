# FileUpload1

## 简介

`org.apache.commons.fileupload.FileItem` 是在 `multipart/form-data` POST 请求中接收到的文件或表单项。

而 `org.apache.commons.fileupload.disk.DiskFileItem` 是 FileItem 的实现类，它用来封装一个请求消息实体中的全部项目，在 `FileUploadBase#parseRequest` 解析时进行封装，动作由 DiskFileItemFactory 的 `createItem` 方法来完成。

当上传的文件项目比较小时，直接保存在内存中（速度比较快），比较大时，以临时文件的形式，保存在磁盘临时文件夹。

而在这个过程中，就用到了几个 DiskFileItem 类中的属性：

- repository：File 类型的成员变量，如果文件保存到硬盘上的话，保存的位置。
- sizeThreshold：文件大小阈值，如果超过这个值，上传文件将会被储存在硬盘上。
- fileName：原始文件名
- dfos：一个 DeferredFileOutputStream 对象，用于 OutputStream 的写出
- dfosFile：一个 File 对象，允许对其序列化的操作



## 反序列化



### 通过反序列化写文件

很简单的一个东西，这里只做简单分析，可以看到在org.apache.commons.fileupload.disk.DiskFileItem#readObject

```java
private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        if (this.repository != null) {
            if (!this.repository.isDirectory()) {
                throw new IOException(String.format("The repository [%s] is not a directory", this.repository.getAbsolutePath()));
            }

            if (this.repository.getPath().contains("\u0000")) {
                throw new IOException(String.format("The repository [%s] contains a null character", this.repository.getPath()));
            }
        }

        OutputStream output = this.getOutputStream();
        if (this.cachedContent != null) {
            output.write(this.cachedContent);
        } else {
            FileInputStream input = new FileInputStream(this.dfosFile);
            IOUtils.copy(input, output);
            this.dfosFile.delete();
            this.dfosFile = null;
        }

        output.close();
        this.cachedContent = null;
    }
```

在里面如果`this.cachedContent != null`，则会去写文件

```java
output.write(this.cachedContent);
```

那我们了看看这个output的获取

```java
    public OutputStream getOutputStream() throws IOException {
        if (this.dfos == null) {
            File outputFile = this.getTempFile();
            this.dfos = new DeferredFileOutputStream(this.sizeThreshold, outputFile);
        }

        return this.dfos;
    }
```

这个返回的dfos是DeferredFileOutputStream，这里修饰符是transient，因此反序列化的时候不可控，但是序列化writeObject的时候需要

```
private transient DeferredFileOutputStream dfos;
```

我们可以看到在为空的时候会调用getTempFile

```java
    protected File getTempFile() {
        if (this.tempFile == null) {
            File tempDir = this.repository;
            if (tempDir == null) {
                tempDir = new File(System.getProperty("java.io.tmpdir"));
            }

            String tempFileName = String.format("upload_%s_%s.tmp", UID, getUniqueId());
            this.tempFile = new File(tempDir, tempFileName);
        }

        return this.tempFile;
    }
```

唯一可控的就是其目录repository，在1.3 版本以下，可以使用` \0 `截断来控制写入任意文件，但后面不行了在 1.3.1 及以上，只能指定目录，因此高版本下我们只能任意写入一些垃圾文件

### 通过反序列化删除文件

在readObject当中，可以看到当cachedContent为空

```java
if (this.cachedContent != null) {
            output.write(this.cachedContent);
        } else {
            FileInputStream input = new FileInputStream(this.dfosFile);
            IOUtils.copy(input, output);
            this.dfosFile.delete();
            this.dfosFile = null;
        }
```

则可以进行源文件拷贝到目标目录，但是拷贝后文件名不可控只能指定目录没意思，之后会把源文件进行删除操作



总之这个链子就是很简单没啥意义，还是记录一下





## 参考文章

https://blog.csdn.net/raintungli/article/details/56008382?spm=a2c6h.12873639.0.0.1e3e1d42hESaw8

https://github.com/su18/blogtalk/issues/32
