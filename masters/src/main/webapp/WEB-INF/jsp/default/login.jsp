<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<div>
    <c:if test="${param.login_error ne t}">
        <div class="errorblock">
            Your login attempt was not successful, try again.<br /> Caused :
            ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
        </div>
    </c:if>
    <form method="post" class="signin" action="<c:url value='j_spring_security_check' />">

        <fieldset>
            <table cellspacing="0">
                <tr>
                    <th><label for="username">Username</label></th>
                    <td><input id="username" 
                               name="j_username" 
                               type="text" />  <!--<co id="co_usernameField"/>-->
                    </td>
                </tr>
                <tr>
                    <th><label for="password">Password</label></th>
                    <td><input id="password" 
                               name="j_password" 
                               type="password" /> <!--<co id="co_passwordField"/>-->
<!--                        <small><a href="/account/resend_password">Forgot?</a></small>-->
                    </td>
                </tr>
                <tr>
                    <th></th>
                    <td><input id="remember_me" 
                               name="_spring_security_remember_me" 
                               type="checkbox"/> <!--<co id="co_rememberMe"/>-->
                        <label for="remember_me" 
                               class="inline">Remember me</label></td>
                </tr>
                <tr>
                    <th></th>
                    <td><input name="commit" type="submit" value="Sign In" /></td>
                </tr>
            </table>
        </fieldset>
    </form>

    <script type="text/javascript">
        document.getElementById('username_or_email').focus();
    </script>
</div>