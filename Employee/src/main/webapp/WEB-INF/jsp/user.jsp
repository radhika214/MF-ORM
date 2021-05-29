<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
     <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
     <title>Insert title here</title>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
   </head>
   <body>
      <h3>Add / Edit Employee!!!</h3>
    
     <form:form method="post" action="employee" modelAttribute="customer">
      
             <div class="table-responsive">
          <table class="table table-bordered" style="width: 300px">
            <tr>
              <td>firstnmae :</td>
              <td><form:input type="text" path="fname" /></td>
            </tr>
            <tr>
              <td>lastName :</td>
              <td><form:input type="text" path="lname" /></td>
            </tr>
            <tr>
              <td>email :</td>
              <td><form:input type="text" path="email" /></td>
            </tr>
            <tr>
              <td>gender :</td>
              <td><form:input type="text" path="gender" /></td>
            </tr>
            <tr>
             <td>password :</td>
              <td><form:input type="text" path="password" /></td>
            </tr>
            <tr>
             <td>pno :</td>
              <td><form:input type="text" path="pno" /></td>
            </tr>
            <tr>
              <td></td>
              <td><input class="btn btn-primary btn-sm" type="submit" value="Submit" /></td>
            </tr>
          </table>
        </div>
      </form:form>
     <br>
     <h3>List of Employees</h3>
       <table class="table table-bordered" style="width: 300px">
         <tr>
           <th>Firstname</th>
           <th>lastname</th>
           <th>email</th>
           <th>Gender</th>
             <th>password</th>
               <th>pno</th>
           <th>Edit/Delete</th>
         </tr>
         <c:forEach items="${employeeList}" var="employee">
         <tr>
           <td width="60" align="center">${employee.fname}</td>
           <td width="60" align="center">${employee.lname}</td>
           <td width="60" align="center">${employee.email}</td>
           <td width="60" align="center">${employee.gender}</td>
            <td width="60" align="center">${employee.password}</td>
             <td width="60" align="center">${employee.pno}</td>
           <td width="60" align="center"><a href="edit/${customer.fname}">Edit</a>/<a href="delete/${employee.fname}">Delete</a></td>
         </tr>
      </c:forEach>
    </table>
  </body>
</html>