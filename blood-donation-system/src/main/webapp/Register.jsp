<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create My Account | Blood Services</title>
    <style>
        body { margin:0; font-family:Arial, Helvetica, sans-serif; background:#f5f5f5; }
        .header { background:#fff; border-bottom:4px solid #d71f28; padding:15px 30px; display:flex; align-items:center; justify-content:space-between; }
        .header-left { display:flex; align-items:center; gap:10px; }
        .logo { width:40px; height:40px; background:#d71f28; color:white; font-weight:bold; display:flex; align-items:center; justify-content:center; border-radius:50%; }
        .header-right a { margin-left:20px; text-decoration:none; color:#333; font-weight:bold; }
        .container { display:flex; height:calc(100vh - 80px); }
        .form-section { width:25%; background:white; padding:30px; overflow-y:auto; }
        .form-section h2 { color:#d71f28; margin-bottom:20px; }
        .form-group { margin-bottom:15px; }
        .form-group label { font-weight:bold; display:block; margin-bottom:5px; }
        .form-group input, .form-group select { width:100%; padding:10px; border:1px solid #ccc; border-radius:4px; }
        .dob { display:flex; gap:10px; }
        .dob select { flex:1; }
        .btn { background:#d71f28; color:white; border:none; padding:12px; width:100%; font-size:16px; cursor:pointer; border-radius:4px; }
        .btn:hover { background:#b61b22; }
        .signin-link { margin-top:15px; text-align:center; }
        .signin-link a { color:#0066cc; text-decoration:none; font-weight:bold; }
.image-section {
    width: 75%;
    background: url('<c:url value="/images/img_2.png"/>') center/cover no-repeat;
}

    </style>
</head>
<body>

<div class="header">
    <div class="header-left">
        <div class="logo">+</div>
        <strong>American Red Cross | Blood Services</strong>
    </div>
    <div class="header-right">
        <a href="searchNav">Search</a>
    </div>
</div>

<div class="container">

    <div class="form-section">
        <h2>Create My Account</h2>

        <form action="<%= request.getContextPath() %>/addDoner" method="post">

            <div class="form-group">
                <label>Email Address *</label>
                <input type="email" name="donerEmail" required>
            </div>

            <div class="form-group">
                <label>Date of Birth *</label>
                <div class="dob">
                    <select name="donerBirthYear" required>
                        <option value="">Year</option>
                        <!-- Years 1950-2025 -->
                        <option value="1950">1950</option>
                        <option value="1951">1951</option>
                        <option value="1952">1952</option>
                        <option value="1953">1953</option>
                        <option value="1954">1954</option>
                        <option value="1955">1955</option>
                        <option value="1956">1956</option>
                        <option value="1957">1957</option>
                        <option value="1958">1958</option>
                        <option value="1959">1959</option>
                        <option value="1960">1960</option>
                        <option value="1961">1961</option>
                        <option value="1962">1962</option>
                        <option value="1963">1963</option>
                        <option value="1964">1964</option>
                        <option value="1965">1965</option>
                        <option value="1966">1966</option>
                        <option value="1967">1967</option>
                        <option value="1968">1968</option>
                        <option value="1969">1969</option>
                        <option value="1970">1970</option>
                        <option value="1971">1971</option>
                        <option value="1972">1972</option>
                        <option value="1973">1973</option>
                        <option value="1974">1974</option>
                        <option value="1975">1975</option>
                        <option value="1976">1976</option>
                        <option value="1977">1977</option>
                        <option value="1978">1978</option>
                        <option value="1979">1979</option>
                        <option value="1980">1980</option>
                        <option value="1981">1981</option>
                        <option value="1982">1982</option>
                        <option value="1983">1983</option>
                        <option value="1984">1984</option>
                        <option value="1985">1985</option>
                        <option value="1986">1986</option>
                        <option value="1987">1987</option>
                        <option value="1988">1988</option>
                        <option value="1989">1989</option>
                        <option value="1990">1990</option>
                        <option value="1991">1991</option>
                        <option value="1992">1992</option>
                        <option value="1993">1993</option>
                        <option value="1994">1994</option>
                        <option value="1995">1995</option>
                        <option value="1996">1996</option>
                        <option value="1997">1997</option>
                        <option value="1998">1998</option>
                        <option value="1999">1999</option>
                        <option value="2000">2000</option>
                        <option value="2001">2001</option>
                        <option value="2002">2002</option>
                        <option value="2003">2003</option>
                        <option value="2004">2004</option>
                        <option value="2005">2005</option>
                        <option value="2006">2006</option>
                        <option value="2007">2007</option>
                        <option value="2008">2008</option>
                        <option value="2009">2009</option>
                        <option value="2010">2010</option>
                        <option value="2011">2011</option>
                        <option value="2012">2012</option>
                        <option value="2013">2013</option>
                        <option value="2014">2014</option>
                        <option value="2015">2015</option>
                        <option value="2016">2016</option>
                        <option value="2017">2017</option>
                        <option value="2018">2018</option>
                        <option value="2019">2019</option>
                        <option value="2020">2020</option>
                        <option value="2021">2021</option>
                        <option value="2022">2022</option>
                        <option value="2023">2023</option>
                        <option value="2024">2024</option>
                        <option value="2025">2025</option>
                    </select>

                    <select name="donerBirthMonth" required>
                        <option value="">Month</option>
                        <option value="January">January</option>
                        <option value="February">February</option>
                        <option value="March">March</option>
                        <option value="April">April</option>
                        <option value="May">May</option>
                        <option value="June">June</option>
                        <option value="July">July</option>
                        <option value="August">August</option>
                        <option value="September">September</option>
                        <option value="October">October</option>
                        <option value="November">November</option>
                        <option value="December">December</option>
                    </select>

                    <select name="donerBirthDay" required>
                        <option value="">Day</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                        <option value="13">13</option>
                        <option value="14">14</option>
                        <option value="15">15</option>
                        <option value="16">16</option>
                        <option value="17">17</option>
                        <option value="18">18</option>
                        <option value="19">19</option>
                        <option value="20">20</option>
                        <option value="21">21</option>
                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                        <option value="25">25</option>
                        <option value="26">26</option>
                        <option value="27">27</option>
                        <option value="28">28</option>
                        <option value="29">29</option>
                        <option value="30">30</option>
                        <option value="31">31</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label>Donor ID (optional)</label>
                <input type="text" name="donorId">
            </div>

            <div class="form-group">
                <label>First Name *</label>
                <input type="text" name="donerFirstName" required>
            </div>

            <div class="form-group">
                <label>Last Name *</label>
                <input type="text" name="donerLastName" required>
            </div>

            <div class="form-group">
                <label>ZIP Code *</label>
                <input type="text" name="donerZipCode" required>
            </div>

            <div class="form-group">
                <label>Username *</label>
                <input type="text" name="donerUsername" required>
            </div>

            <div class="form-group">
                <label>Password *</label>
                <input type="password" name="donerPassword" required>
            </div>

            <div class="form-group">
                <label>Repeat Password *</label>
                <input type="password" name="confirmPassword" required>
            </div>

            <input class="btn" type="submit" value="Continue"/>
        </form>

        <div class="signin-link">
            Already Have An Account? <a href="#">Sign In</a>
        </div>
    </div>

    <div class="image-section"></div>
</div>
</body>
</html>
