<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
    <div class="col-md-5">
        <c:choose>
            <c:when test="${not empty product.images}">
                <img src="${pageContext.request.contextPath}/upload/${product.images}" 
                     class="img-fluid border rounded" style="max-height:300px; object-fit:cover;">
            </c:when>
            <c:otherwise>
                <span class="text-muted fst-italic">[imageLink]</span>
            </c:otherwise>
        </c:choose>
    </div>

    <div class="col-md-7">
        <h4 class="fw-bold text-primary">${product.productName}</h4>
        <p><strong>Mã sản phẩm:</strong> ${product.productId}</p>
        <p><strong>Danh mục:</strong> ${product.category.categoryName}</p>
        <p><strong>Giá:</strong> ${product.price}₫</p>
        <p><strong>Số lượng:</strong> ${product.amount}</p>
        <p><strong>Mô tả:</strong> ${product.description}</p>
    </div>
</div>
