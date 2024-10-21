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
      <h2>Web MVC Framework Basic</h2>
      <div class="card">
        <div class="card-header">Book View</div>
        <div class="card-body">
            <table class="table table-bordered">
               <tr>
                  <td>번호</td>
                  <td>${book.num}</td>
               </tr>
             <tr>
                  <td>제목</td>
                  <td>${book.title}</td>
               </tr>
             <tr>
                  <td>가격</td>
                  <td>${book.price}</td>
               </tr>
             <tr>
                  <td>저자</td>
                  <td>${book.author}</td>
               </tr>
             <tr>
                  <td>페이지수</td>
                  <td>${book.page}</td>
               </tr>
            </table>
            <!-- 총액,  수량,  장바구니 담기 -->
            <div class="row mb-3">
               <div class="col-8 text-right">
                 <!-- 수량 선택을 위한 스텝퍼와 총액 표시를 우측 정렬 -->
                 <div class="d-inline-block mr-3">
                   <label for="quantityInput" class="mr-2">수량:</label>
                   <input type="number" id="quantityInput" value="1" min="1" class="form-control d-inline-block" style="width: auto;">
                 </div>
                 총액:<span id="totalPrice" class="d-inline-block">${book.price}</span> <!-- 예시로 book.price를 사용하였으나, 실제 총액 계산 로직 필요 -->
               </div>
               <div class="col-4">
                 <!-- 장바구니에 담기 버튼의 넓이를 100%로 설정하고 색상을 빨간색으로 변경 -->
                 <c:if test="${!empty cus}">
                    <button class="btn btn-danger btn-sm w-100" id="addToCart">장바구니에 담기</button>
                 </c:if>
                 <c:if test="${empty cus}">
                    <button class="btn btn-danger btn-sm w-100" id="addToCart" disabled>장바구니에 담기</button>
                 </c:if>
               </div>
             </div>
            <button class="btn btn-sm btn-primary action">목록</button>
            <c:if test="${!empty cus}">
               <button class="btn btn-sm btn-success action">수정</button>
               <button class="btn btn-sm btn-warning action">삭제</button>
            </c:if>
             <c:if test="${empty cus}">
                 <button class="btn btn-sm btn-success action" disabled>수정</button>
                 <button class="btn btn-sm btn-warning action" disabled>삭제</button>
              </c:if>
        </div>

       <div class="card-footer">인프런_마프 1탄_박매일</div>
   </div>
   </div>
    <form id="myForm" method="post" action="">
         <input type="hidden" name="num" id="num" value="${book.num}"/>
    </form>
 <script>
      document.getElementById("quantityInput").addEventListener("change", function(){
             let quantity=this.value;
             let total=quantity*${book.price};
             document.getElementById("totalPrice").innerHTML=total;
        } );
     // 장바구니 담기 : fetch().then().then().catch()
      document.getElementById("addToCart").addEventListener("click", function(){
          let book_num=${book.num};
          let quantity=document.getElementById("quantityInput").value;
          let customer_id="${cus.customer_id}";
          // json : {     }
          let data={
            "book_num" : book_num,
           "quantity"   :  parseInt(quantity),
            "customer_id" : customer_id
           }; // Object : JSON(문자열)
           console.log(data);
           let cartData=JSON.stringify(data);
           console.log(cartData);
           fetch("${cpath}/addToCart.do", {
               method : "POST",
               headers : { "Content-Type" : "application/json"},
               body : cartData
           })
           .then(response=>response.json())
           .then(data=>{
             if(data.success){
                    alert("장바구니 담기 성공");
                    location.href="${cpath}/list.do";
                 }else{
                  alert("장바구니 담기 실패");
             }
            })
           .catch(error=>{
               console.log("Error:"+ error);
            });
      });

       document.querySelector(".card-body").addEventListener("click", function(e){
         if(e.target.classList.contains("action")){
              let form=document.getElementById("myForm");
              let inputNum=document.getElementById("num");
              switch(e.target.classList[2]){
                  case "btn-primary" :
                       console.log("목록버튼클릭");
                       form.action="${cpath}/list.do"
                       if(inputNum){
                           inputNum.remove();
                       }
                       form.method="GET";
                       break;
                  case "btn-success" :
                      console.log("수정버튼클릭");
                      form.action="${cpath}/updateGet.do"
                      form.method="POST";
                      break;
                  case "btn-warning" :
                       console.log("삭제버튼클릭");
                       form.action="${cpath}/delete.do"
                       form.method="POST";
                       break;
              }
              form.submit();
         }
       });
   </script>
</body>
</html>