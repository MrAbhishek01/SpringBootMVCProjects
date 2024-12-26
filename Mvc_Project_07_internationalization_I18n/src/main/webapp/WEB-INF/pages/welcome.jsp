<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="sp"%>

<body style="display: flex; flex-direction: column; justify-content: center; align-items: center; height: 100vh; margin: 0; background-color: #f0f0f0;">

    <h1 style="color: red; text-align: center;">
        <sp:message code="home.welcome" />
    </h1>

    <h1 style="color: red; text-align: center;">
        <a href="registor" style="color: blue; text-decoration: none;">
            <sp:message code="home.link1" />
        </a>
    </h1>

    <div style="margin-top: 20px; text-align: center;">
        <a href="?lang=de_DE" style="margin: 0 10px; text-decoration: none; color: #007bff;">Germany</a>
        <a href="?lang=fr_FR" style="margin: 0 10px; text-decoration: none; color: #007bff;">French</a>
        <a href="?lang=te_IN" style="margin: 0 10px; text-decoration: none; color: #007bff;">Telugu</a>
        <a href="?lang=hi_IN" style="margin: 0 10px; text-decoration: none; color: #007bff;">Hindi</a>
        <a href="?lang=en_US" style="margin: 0 10px; text-decoration: none; color: #007bff;">English</a>
    </div>

</body>