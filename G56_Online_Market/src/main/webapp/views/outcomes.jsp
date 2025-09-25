<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Outcome List</title>
    <!-- Bootstrap CSS -->
    <jsp:include page="../css/css.jsp"/>
</head>
<body class="bg-light">
<jsp:include page="../fragments/NavbarHomePage.jsp"/>

<div class="container mt-5">
    <h2 class="text-center mb-4">📋 Outcome List</h2>

    <!-- Jadval -->
    <div class="card shadow-lg rounded-3">
        <div class="card-body">
            <table class="table table-bordered table-hover align-middle text-center">
                <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Quantity</th>
                    <th>Amount</th>
                    <th>Description</th>
                    <th>Created At</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="out" items="${outcomes}">
                    <tr>
                        <td>${out.id}</td>
                        <td>${out.quantity}</td>
                        <td>${out.amount}</td>
                        <td>${out.description}</td>
                        <td>${out.createdAt}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/outcomes/delete?id=${out.id}"
                               class="btn btn-sm btn-danger">
                                ❌ Delete
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Forma -->
    <div class="card mt-4 shadow-lg rounded-3">
        <div class="card-body">
            <h3 class="mb-3">➕ Yangi Outcome qo‘shish</h3>
            <form method="post" action="${pageContext.request.contextPath}/outcomes">
                <div class="mb-3">
                    <label for="quantity" class="form-label">Quantity</label>
                    <input type="number" id="quantity" name="quantity" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label for="amount" class="form-label">Amount</label>
                    <input type="number" step="0.01" id="amount" name="amount" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label for="description" class="form-label">Description</label>
                    <input type="text" id="description" name="description" class="form-control">
                </div>

                <button type="submit" class="btn btn-success w-100">Qo‘shish</button>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<jsp:include page="../js/js.jsp"/>
</body>
</html>

