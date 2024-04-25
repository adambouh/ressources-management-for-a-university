<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link href="//fonts.googleapis.com/css?family=Hind:300,400,500,600,700" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../../css/home.css">
</head>
<body>

<!-- CONTENT -->
    <section id="content">
        <!-- NAVBAR -->
        <nav>
            <i (click)="addToggle()" class='bx bx-menu' ></i>
            <a href="#" class="nav-link">Categories</a>
            <form action="#">
                <div class="form-input">
                    <input type="search" placeholder="Search...">
                    <button type="button" class="search-btn"><i class='bx bx-search' ></i></button>
                </div>
            </form>
            <a href="#" class="notification"  onclick="event.preventDefault()" (click)="showNotificationsPage()">
                <i class='bx bxs-bell' ></i>
                <span class="num"><%@%>
          </span>
            </a>

            <a href="#" class="profile">
                <img src="https://secure.gravatar.com/avatar/d09eaad01aea86c51b4f892b4f8abf6f?s=100&d=wavatar&r=g">
            </a>
        </nav>
        <!-- NAVBAR -->

        <!-- MAIN -->

    </section>

    <!-- CONTENT -->