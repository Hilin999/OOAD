<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guitar销售系统</title>
<link href="../css/main.css" rel="stylesheet" type="text/css">
<link href="../css/bootstrap.css" rel="stylesheet" type="text/css">
<script src="../js/jquery.js"></script>
<script src="../js/search.js"></script>
</head>

<body>
   
     <div id="headerwrap">
       <h1>吉他查询</h1>
       <hr>
        <img src="../img/gui1.jpg" height="200" width="140" >    
		<div class="bootstrap-frm">
	        <label> <span>制造商</span>    
		         <input id="builder" type="text" name="builder" />
			</label> <br>
			<label> <span>价&nbsp;&nbsp;&nbsp;格</span>    
		         <input id="price" type="text" name="price" />
			</label> <br>	
			<label> <span>model</span>
			      <select id="model">
			         <option>FolkGuitar</option>
			         <option>Electronic</option>
			         <option>UKelele</option>
			         <option>Bass</option>
			      </select>
			</label> <br>
			<label> <span>弦数</span> 
			       <select id="type">
			         <option>6</option>
			         <option>7</option>
			         <option>8</option>
			      </select>
			</label><br>
			
			 <label>
		    </label> <span>&nbsp;</span>
		       <input id="btnQuery" type="submit" class="btn btn-default" value="查询" />&nbsp;&nbsp;&nbsp;&nbsp; </label>
		</div>
	<div id="Search">
        <table class="table table-responsive table-bordered"   id="mytbody">
        <thead>
        <tr>
        <th>编号</th>
        <th>价格</th>
        <th>制造商</th>
        <th>种类</th>
        <th>弦数</th>
        <th>后壳材质</th>
        <th>前壳材质</th>
        </tr>
        </thead>
        <tbody>   
        </tbody>
    </table>
  </div>	
	
  </div>
 

</body>
</html>