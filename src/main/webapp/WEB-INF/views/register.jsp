<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

    <div class="container">
      <h2>Web Database Programming</h2>
      <div class="card">
        <div class="card-header">
                   <!-- 파일 업로드 폼 (수평 정렬) -->
                      <form action="${cpath}/registerBooksByFile.do" method="post" enctype="multipart/form-data" class="form-inline" style="margin-top: 20px; justify-content: center;">
                             <div class="form-group">
                                     <label for="fileUpload" class="mr-2">책 일괄 등록 (Excel):</label>
                                     <input type="file" class="form-control-file mr-2" id="fileUpload" name="bookFile">
                                     <button type="submit" class="btn btn-success btn-sm">업로드</button>
                                </div>
                      </form>
        </div>
        <div class="card-body">
                <form action="${cpath}/registerPost.do" method="post">
                    <div class="form-group">
                      <label for="title">제목:</label>
                      <input type="text" class="form-control" placeholder="Enter title" id="title" name="title">
                    </div>
                    <div class="form-group">
                         <label for="price">가격:</label>
                         <input type="text" class="form-control" placeholder="Enter price" id="title" name="price">
                    </div>
                    <div class="form-group">
                         <label for="author">저자:</label>
                         <input type="text" class="form-control" placeholder="Enter author" id="title" name="author">
                    </div>
                     <div class="form-group">
                          <label for="page">페이지수:</label>
                          <input type="text" class="form-control" placeholder="Enter page" id="page" name="page">
                     </div>
                     <button type="submit" class="btn btn-primary btn-sm">등록</button>
                     <button type="reset" class="btn btn-info btn-sm">취소</button>
                  </form>
         </div>
        <div class="card-footer">인프런_마프 1탄_박매일</div>
      </div>
    </div>

</body>
</html>