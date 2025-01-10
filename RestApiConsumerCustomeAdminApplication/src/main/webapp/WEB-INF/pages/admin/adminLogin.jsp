<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@page isELIgnored="false" %>
  <frm:form modelAttribute="admin">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><frm:input path="adminUsername" class="input-field"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                  <td><frm:input path="adminPassword" class="input-field"/></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;">
                        <input type="submit" value="Login" class="submit-button" />
                        <br><br>
                        <a href="./forgot-password" class="link">Forgot Password?</a><br>
                        <a href="./adminRegisterPage" class="link">New User? Register Here</a>
                    </td>
                </tr>
            </table>
        </frm:form>