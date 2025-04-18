
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Student Attendance</title></head>
<body>
  <form action="AttendanceServlet" method="post">
    Student ID: <input type="text" name="studentId"><br>
    Date: <input type="date" name="date"><br>
    Status:
    <select name="status">
      <option value="Present">Present</option>
      <option value="Absent">Absent</option>
    </select><br>
    <input type="submit" value="Submit Attendance">
  </form>
</body>
</html>
