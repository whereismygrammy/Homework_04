<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

# Java EE Podstawy - Snippety
> Krótkie kawałki kodu, które pokazują zależności, rozwiązują popularne problemy oraz pokazują jak używać niektórych funkcji.

#### Jak dodać napis do obiektu odpowiedzi.

```java
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

	response.getWriter().append("123 MyCode ");
}
```

#### Jak ustawić adres URL w adnotacji
```java
@WebServlet("/test")
```

#### Jak ustawić adres URL w pliku web.xml

```xml
<servlet>
    <servlet-name>TestServlet</servlet-name>
    <servlet-class>pl.coderslab.MyServlet
    </servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>TestServlet</servlet-name>
    <url-pattern>/AdresTestServlet</url-pattern>
</servlet-mapping>
```
#### Jak pobrać parametr przekazany metodą GET


```java
protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
   request.getParameter("paramName");
}
```

#### Jak ustawić parametr inicjalizacji dla całej aplikacji w web.xml
```xml
<context-param>
<param-name>numberOfRows</param-name>
<param-value>5</param-value>
</context-param>

```
#### Jak pobrać parametr inicjalizacji i zamienić go na wartość liczbową
````
int numberOfRows = Integer.parseInt(getServletContext().getInitParameter("numberOfRows"));

````

#### Jak zapisać dane użytkownika w plikach Cookie


```java
protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {  
    String cookieName = "cookieName";
    String cookieValue = "cookieValue";
    Cookie cookie = new Cookie(cookieName, cookieValue);
    cookie.setMaxAge(1*60*60); //1h * 60min * 60sec
    response.addCookie(cookie);
}
```

#### Jak załączyć fragment w pliku jsp

```jsp
<jsp:include page="header.jspf"/>
```

#### Jak zapisać import w pliku jsp

```jsp
<%@ page import="java.util.Date, java.util.Arrays"%>
```
#### Jak zadeklarować zmienną w pliku jsp

```jsp
<%! int counter = 0; %>
```


#### Jak pobrać parametr za pomocą EL
```jsp
${param.myname}
```
#### Jak umieścić dyrektywę taglib dla jstl core
```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
```
#### Pętla przy użyciu jstl w jsp
```
<% String[] animals = {"Pies", "Kot", "Nietoperz", "Ważka"}; %>
<ul>
<c:forEach var="animal" items="<%= animals%>">
<li> ${animal}</li>
</c:forEach>
</ul>
```

#### Instrukcja warunkowa jstl w jsp
```
<c:if test="${not empty param.myName}">
Jest ok - jest param
</c:if>
```

#### Jak ustawić i przekazać atrybuty z servletu do jsp
```java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("myAttribute", "myValue");
    getServletContext().getRequestDispatcher("/WEB-INF/jsp/first.jsp").forward(request, response);
}
```
#### Jak odebrać atrybut w jsp za pomocą EL
```
${myAttribute}
```

