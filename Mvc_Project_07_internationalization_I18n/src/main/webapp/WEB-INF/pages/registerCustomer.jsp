<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="sp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<body style="display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; background-color: #f0f0f0;">

    <div style="text-align: center; border: 2px solid #ccc; padding: 20px; background-color: white; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); border-radius: 8px;">
        <h1 style="color: red;">
            <sp:message code="registration.welcome" />
        </h1>

        <frm:form method="POST" modelAttribute="customer">
            <table style="margin: 0 auto;">
                <tr>
                    <td><sp:message code="registration.welcome" /></td>
                    <td><frm:input path="cno" /></td>
                </tr>
                <tr>
                    <td><sp:message code="registration.cust.name" /></td>
                    <td><frm:input path="name" /></td>
                </tr>
                <tr>
                    <td><sp:message code="registration.cust.adds" /></td>
                    <td><frm:input path="addrs" /></td>
                </tr>
                <tr>
                    <td><sp:message code="registration.cust.mobileNo" /></td>
                    <td><frm:input path="moblieno" /></td>
                </tr>
                <tr>
                    <td><sp:message code="registration.cust.submitCaption" /></td>
                    <td><input type="submit" value="<sp:message code='registration.cust.submitCaption' />" /></td>
                </tr>
            </table>
        </frm:form>

        <div style="margin-top: 20px; text-align: center;">
            <a href="?lang=de_DE" style="margin: 0 10px; text-decoration: none; color: #007bff;">Germany</a>
            <a href="?lang=fr_FR" style="margin: 0 10px; text-decoration: none; color: #007bff;">French</a>
            <a href="?lang=te_IN" style="margin: 0 10px; text-decoration: none; color: #007bff;">Telugu</a>
            <a href="?lang=hi_IN" style="margin: 0 10px; text-decoration: none; color: #007bff;">Hindi</a>
            <a href="?lang=en_US" style="margin: 0 10px; text-decoration: none; color: #007bff;">English</a>
        </div>
    </div>

</body>
