<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.contextPath}" />	
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${cp}/resources/equipStyles.css">
<meta charset="UTF-8">
<title>메이플스토리 장비창</title>
</head>
<body>
    <div id="main">
        <!-- 장비 아이템 -->
        <div id="eqip">
            <div id="eqipline" class="item-line">
                <div class="item" id="ring_1">
        			<img class="itemimg" id="sss" src="${maple.character_image}" alt="캐릭터이미지">
                </div>
                <div class="block" id="block_1"></div>
                <div class="item" id="ring_2"></div>
                <div class="block" id="block_2"></div>
                <div class="item" id="ring_3"></div>
                <div class="item" id="ring_4"></div>
                <div class="item" id="poket"></div>
                <div class="item" id="pendant_1"></div>
                <div class="block" id="block_3"></div>
                <div class="item" id="pendant_2"></div>
                <div class="item" id="weapon"></div>
                <div class="item" id="belt"></div>
                <div class="item" id="cap"></div>
                <div class="item" id="forehead"></div>
                <div class="item" id="eyeacc"></div>
                <div class="item" id="clothes"></div>
                <div class="item" id="pants"></div>
                <div class="item" id="shoes"></div>
                <div class="item" id="earacc"></div>
                <div class="item" id="shoulder"></div>
                <div class="item" id="gloves"></div>
                <div class="item" id="android"></div>
                <div class="item" id="emblem"></div>
                <div class="item" id="badge"></div>
                <div class="item" id="medal"></div>
                <div class="block" id="block_4"></div>
                <div class="block" id="block_5"></div>
                <div class="item" id="subweapon"></div>
                <div class="item" id="cape"></div>
                <div class="item" id="heart"></div>
            </div>
        </div>
        <!-- 펫 아이템 -->
        <div id="pet">
            <div class="pet-line" id="petline_1">
                <div class="item" id="pet_1"></div>
                <div class="item" id="petacc_1"></div>
            </div>
            <div class="pet-line" id="petline_2">
                <div class="item" id="pet_2"></div>
                <div class="item" id="petacc_2"></div>
            </div>
            <div class="pet-line" id="petline_3">
                <div class="item" id="pet_3"></div>
                <div class="item" id="petacc_3"></div>
            </div>
        </div>
    </div>
</body>
</html>
