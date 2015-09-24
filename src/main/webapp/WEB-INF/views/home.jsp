<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>spring-mvc-uploadify多文件上传</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/uploadify/uploadify.css" />">
    <script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/uploadify/jquery.uploadify.min.js" />"></script>
    <script>
        $(document).ready(function () {
            $("#file_upload").uploadify({
                'buttonText': '请选择',
                'height': 30,
                'swf': '<c:url value="/resources/uploadify/uploadify.swf" />',
                'uploader': '<c:url value="/fileupload" />',
                'width': 120,
                'auto': false,
                'fileObjName': 'file',
                'onUploadSuccess': function (file, data, response) {
                   console.log(file,data,response);
                }
            });
        });
    </script>
</head>
<body>
<input type="file" name="fileName" id="file_upload"/>
<a href="javascript:$('#file_upload').uploadify('upload', '*')">上传文件</a> | <a
        href="javascript:$('#file_upload').uploadify('stop')">停止上传!</a>
</body>
</body>
</html>
