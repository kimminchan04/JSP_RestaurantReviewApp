<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
</head>
<body>
    <div>
        <h3>회원 가입</h3>
        <form action="../JoinController" method="post">
        <table>
            <tr>
                <td>아이디: </td>
                <td><input type="text" name="mid" required></td>
            </tr>
            <tr>
                <td>비밀번호: </td>
                <td><input type="password" name="mpw" required></td>
            </tr>
            <tr>
                <td>이름: </td>
                <td><input type="text" name="name" required></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="회원 가입">
                    <input type="reset" value="입력 취소">
                </td>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>